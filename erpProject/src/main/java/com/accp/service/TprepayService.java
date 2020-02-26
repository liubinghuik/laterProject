package com.accp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Department;
import com.accp.domain.DepartmentExample;
import com.accp.domain.Employee;
import com.accp.domain.Purchaseorder;
import com.accp.domain.PurchaseorderExample;
import com.accp.domain.Supplier;
import com.accp.domain.Tpaymentprepay;
import com.accp.domain.TpaymentprepayExample;
import com.accp.domain.Tprepay;
import com.accp.domain.TprepayExample;
import com.accp.domain.Tprepaydetail;
import com.accp.domain.TprepaydetailExample;
import com.accp.mapper.DepartmentMapper;
import com.accp.mapper.EmployeeMapper;
import com.accp.mapper.PurchaseorderMapper;
import com.accp.mapper.SupplierMapper;
import com.accp.mapper.TpaymentprepayMapper;
import com.accp.mapper.TprepayMapper;
import com.accp.mapper.TprepaydetailMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TprepayService {
	@Autowired
	private TprepayMapper tprepayMapper;
	@Autowired
	private TprepaydetailMapper tprepaydetailMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private TpaymentprepayMapper tpaymentprepayMapper;
	@Autowired
	private PurchaseorderMapper purchaseorderMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	/**
	 * 采购订单转预付款单
	 * @param sid
	 * @return
	 */
	public List<Tprepaydetail> postZD(String sid) {
		//1.根据供应商编号查询对应的已审核未结案的采购订单
		PurchaseorderExample purchaseorderExample=new PurchaseorderExample();
		purchaseorderExample.createCriteria().andCustomeridEqualTo(sid).andAuditEqualTo(1).andBillstatusEqualTo(1);
		List<Purchaseorder> purchaseorders=purchaseorderMapper.selectByExample(purchaseorderExample);
		List<Purchaseorder> list=purchaseorderMapper.selectByExample(purchaseorderExample);
		if (purchaseorders!=null&&purchaseorders.size()>=0) {
			//2.筛选出未转单的采购订单
			for (Purchaseorder purchaseorder : purchaseorders) {
				TprepaydetailExample tprepaydetailExample=new TprepaydetailExample();
				tprepaydetailExample.createCriteria().andSourcenoEqualTo(purchaseorder.getBillno());
				List<Tprepaydetail> tprepaydetails=tprepaydetailMapper.selectByExample(tprepaydetailExample);
				if(tprepaydetails!=null&&tprepaydetails.size()>0) {
					list.remove(purchaseorder);
				}
			}
		}else {
			return null;
		}
		//3.进行转单操作
		List<Tprepaydetail> tprepaydetails=new ArrayList<Tprepaydetail>();
		if (list!=null&&list.size()>0) {
			for (Purchaseorder purchaseorder : list) {
				Tprepaydetail tprepaydetail=new Tprepaydetail();
				tprepaydetail.setSourceno(purchaseorder.getBillno());
				tprepaydetail.setSourcetype("采购订单");
				tprepaydetails.add(tprepaydetail);
			}
		}
		return tprepaydetails;
	}
	/**
	 * 自动生成单据编号
	 * @param date
	 * @return
	 */
	public String postId(String date) {
		String[] dateStrs=date.split("-");
		String id="";
		for (String string : dateStrs) {
			id+=string;
		}
		TprepayExample tprepayExample=new TprepayExample();
		tprepayExample.createCriteria().andIdLike("%"+id+"%");
		List<Tprepay> tprepays=tprepayMapper.selectByExample(tprepayExample);
		if (tprepays!=null&&tprepays.size()>0) {
			if (tprepays.size()<9) {
				id+="0";
				id+=(tprepays.size()+1);
			}else {
				id+=(tprepays.size()+1);
			}
		} else {
			id+="01";
		}
		return id;
	}
	/**
	 * 分页查询
	 * @param pageNum 页码
	 * @param pageSize 数量
	 * @param startseachtime 开始时间
	 * @param endseachtime 结束时间
	 * @param id 单据编号
	 * @param sid 供应商编号
	 * @return
	 */
	public PageInfo<Tprepay> showPrepays(Integer pageNum,Integer pageSize,String startseachtime,
			String endseachtime,String id,String sid) {
		if (pageNum==null) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=10;
		}
		Page<Tprepay> page=PageHelper.startPage(pageNum, pageSize);
		tprepayMapper.showPrepay(startseachtime, endseachtime, id, sid);
		return page.toPageInfo();
	}
	/**
	 * 按单号查询
	 * @param id
	 * @return
	 */
	public Tprepay showPrepayById(String id) {
		Tprepay tprepay=tprepayMapper.selectByPrimaryKey(id);
		TprepaydetailExample tprepaydetailExample=new TprepaydetailExample();
		tprepaydetailExample.createCriteria().andPidEqualTo(id).andStateNotEqualTo(0);
		List<Tprepaydetail> tprepaydetails=tprepaydetailMapper.selectByExample(tprepaydetailExample);
		tprepay.setPrepaydetails(tprepaydetails);
		Department department=departmentMapper.selectByPrimaryKey(tprepay.getDepartid());
		tprepay.setDepartName(department.getDepartname());
		Employee vouchingman =employeeMapper.selectByPrimaryKey(tprepay.getVouchingman());
		if (tprepay.getAuditman()!=null) {
			Employee auditman =employeeMapper.selectByPrimaryKey(tprepay.getAuditman());
			tprepay.setAuditmanName(auditman.getName());			
		}
		tprepay.setVouchingmanName(vouchingman.getName());
		return tprepay;
	}
	/**
	 * 新增单据
	 * @param tprepay
	 * @return
	 */
	public int addTprepay(Tprepay tprepay,String vouchingman) {
		int i=0;
		tprepay.setVouchingman(vouchingman);
		Employee employee=employeeMapper.selectByPrimaryKey(vouchingman);
		tprepay.setDepartid(employee.getDepartid());
		i=tprepayMapper.insertSelective(tprepay);
		List<Tprepaydetail> tprepaydetails=tprepay.getPrepaydetails();
		if (tprepaydetails!=null&&tprepaydetails.size()>0) {
			for (Tprepaydetail tprepaydetail : tprepaydetails) {
				tprepaydetail.setBalance(tprepaydetail.getPrepay());
				tprepaydetail.setPid(tprepay.getId());
				tprepaydetail.setState(1);
				tprepaydetailMapper.insertSelective(tprepaydetail);
			}
		}
		return i;
	}
	/**
	 * 软删除单据
	 * @param id
	 * @return
	 */
	public int deleteTprepay(String id) {
		//获取单据主表信息
		Tprepay tprepay=tprepayMapper.selectByPrimaryKey(id);
		//当单据审核后不能删除
		if (tprepay.getAuditstate()==2) {
			return 101;
		}
		Tprepay record=new Tprepay();
		record.setId(id);
		record.setAuditstate(0);
		//修改单据状态
		int i=tprepayMapper.updateByPrimaryKeySelective(record);
		//修改供应商账款数据
		//获取
		return i;
	}
	/**
	 * 审核
	 * @param id
	 * @return
	 */
	public int ckTprepay(String id,String auditman) {
		Tprepay record=new Tprepay();
		record.setId(id);
		record.setAuditstate(2);
		record.setAuditman(auditman);
		int i=tprepayMapper.updateByPrimaryKeySelective(record);
		return i;
	}
	/**
	 * 反审核
	 * @param id
	 * @return
	 */
	public int cancelCKTprepay(String id) {
		//当预付款被使用时无法取消审核
		TpaymentprepayExample tpaymentprepayExample=new TpaymentprepayExample();
		tpaymentprepayExample.createCriteria().andPrepayidEqualTo(id);
		List<Tpaymentprepay> tpaymentprepays=tpaymentprepayMapper.selectByExample(tpaymentprepayExample);
		if (tpaymentprepays!=null&&tpaymentprepays.size()>0) {
			return 101;
		}
		Tprepay record=new Tprepay();
		record.setId(id);
		record.setAuditstate(1);
		record.setAuditman(null);
		int i=tprepayMapper.updateByPrimaryKeySelective(record);
		return i;
	}
	/**
	 * 修改单据
	 * @param tprepay
	 * @return
	 */
	public int updateTprepay(Tprepay tprepay) {
		int i=0;
		i=tprepayMapper.updateByPrimaryKeySelective(tprepay);
		//获取传输的详表信息
		List<Tprepaydetail> tprepaydetails=tprepay.getPrepaydetails();
		//获取数据库中的详表信息
		TprepaydetailExample tprepaydetailExample=new TprepaydetailExample();
		tprepaydetailExample.createCriteria().andPidEqualTo(tprepay.getId()).andStateNotEqualTo(0);
		List<Tprepaydetail> tprepaydetails2=tprepaydetailMapper.selectByExample(tprepaydetailExample);
		//第三方保存数据库信息
		List<Tprepaydetail> list=tprepaydetailMapper.selectByExample(tprepaydetailExample);
		//对比处理详表信息
		//1.当数据库中没有数据时直接新增
		if (tprepaydetails2==null||tprepaydetails2.size()==0) {
			for (Tprepaydetail tprepaydetail : tprepaydetails) {
				tprepaydetailMapper.insertSelective(tprepaydetail);
			}
		}//2.当数据库中有数据时
		else {
			//对比传入的数据和数据库的数据
			for (Tprepaydetail tprepaydetail : tprepaydetails) {
				//辅助判断
				boolean isExist=false;
				for (Tprepaydetail tprepaydetail2 : tprepaydetails2) {
					//如果数据匹配直接修改
					if (tprepaydetail.getId()==tprepaydetail2.getId()) {
						tprepaydetailMapper.updateByPrimaryKeySelective(tprepaydetail);
						list.remove(tprepaydetails2);
						isExist=true;
					}
				}
				//如果没有匹配数据就新增
				if (!isExist) {
					tprepaydetail.setBalance(tprepaydetail.getPrepay());
					tprepaydetail.setState(1);
					tprepaydetail.setPid(tprepay.getId());
					tprepaydetailMapper.insertSelective(tprepaydetail);
				}
			}
			//软删除后台有，前台没有的数据
			for (Tprepaydetail tprepaydetail : list) {
				tprepaydetail.setState(0);
				tprepaydetailMapper.updateByPrimaryKeySelective(tprepaydetail);
			}
		}
		return i;
	}
}
