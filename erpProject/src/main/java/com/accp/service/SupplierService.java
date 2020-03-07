package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Employee;
import com.accp.domain.Supplier;
import com.accp.domain.SupplierExample;
import com.accp.domain.Supplieraddress;
import com.accp.domain.SupplieraddressExample;
import com.accp.domain.Suppliercategory;
import com.accp.mapper.EmployeeMapper;
import com.accp.mapper.SupplierMapper;
import com.accp.mapper.SupplieraddressMapper;
import com.accp.mapper.SuppliercategoryMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class SupplierService {
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private SupplieraddressMapper supplieraddressMapper;
	@Autowired
	private SuppliercategoryMapper suppliercategoryMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public PageInfo<Supplier> showSupllier(Integer pageNum,Integer pageSize,
			String sid,String fullName,String classId) {
		if (pageNum==null) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=10;
		}
		Page<Supplier> page=PageHelper.startPage(pageNum, pageSize);
		supplierMapper.showSupplier(sid, fullName, classId);
		return page.toPageInfo();
	}
	
	public Supplier showSupplierBysid(String sid) {
		Supplier supplier=supplierMapper.selectByPrimaryKey(sid);
//		设置地址
		SupplieraddressExample supplieraddressExample=new SupplieraddressExample();
		supplieraddressExample.createCriteria().andSidEqualTo(sid);
		List<Supplieraddress> supplieraddresses=supplieraddressMapper.selectByExample(supplieraddressExample);
		if (supplieraddresses!=null&&supplieraddresses.size()>0) {
			supplier.setSupplieraddress(supplieraddresses.get(0));
		}
//		设置采购人员姓名
		String personid=supplier.getPersonid();
		if (personid!=null&&!personid.equals("")) {
			Employee employee=employeeMapper.selectByPrimaryKey(personid);
			supplier.setPersonName(employee.getName());
		}
//		设置期末预付款
		Double curAdvRecv=supplierMapper.getcurAdvRecvBySid(sid);
		supplier.setCurAdvRecv(curAdvRecv);
//		设置期末应付款
		Double curReceivable=supplierMapper.getcurReceivableBySid(sid);
		supplier.setCurReceivable(curReceivable);
		return supplier;
	}
	
	public int addSupplier(Supplier supplier) {
		int i=0;
		supplier.setCoulumn3("0");
		i=supplierMapper.insertSelective(supplier);
//		获取地址
		Supplieraddress supplieraddress=supplier.getSupplieraddress();
		if (supplieraddress!=null) {
			supplieraddress.setSid(supplier.getSid());
			supplieraddressMapper.insertSelective(supplieraddress);
		}
		return i;
	}
	
	public int updateSupplier(Supplier supplier) {
		int i=0;
		i=supplierMapper.updateByPrimaryKeySelective(supplier);
//		获取地址
		Supplieraddress supplieraddress=supplier.getSupplieraddress();
		if (supplieraddress!=null) {
			if (supplieraddress.getId()==null) {
				supplieraddress.setSid(supplier.getSid());
				supplieraddressMapper.insertSelective(supplieraddress);
			}else {
				supplieraddressMapper.updateByPrimaryKeySelective(supplieraddress);				
			}
		}
		return i;
	}
	
	public int deleteSupplier(String sid) {
		int i=0;
		Supplier supplier=new Supplier();
		supplier.setSid(sid);
		supplier.setCoulumn3("1");
		i=supplierMapper.updateByPrimaryKeySelective(supplier);
		return i;
	}
	
	public List<Suppliercategory> showSuppliercategorys() {
		return suppliercategoryMapper.selectByExample(null);
	}
	
	public boolean isIdExist(String sid) {
		boolean b=false;
		Supplier supplier=supplierMapper.selectByPrimaryKey(sid);
		if (supplier!=null) {
			b=true;
		}
		return b;
	}
	
	/**
	 * 展示供应商列表
	 * @return
	 */
	public List<Supplier> showSupList() {
		SupplierExample supplierExample=new SupplierExample();
		supplierExample.createCriteria().andCoulumn3EqualTo("0");
		List<Supplier> suppliers=supplierMapper.selectByExample(supplierExample);
		return suppliers;
	}
}
