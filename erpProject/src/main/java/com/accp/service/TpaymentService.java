package com.accp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Department;
import com.accp.domain.Employee;
import com.accp.domain.Supplier;
import com.accp.domain.Taccountpayable;
import com.accp.domain.TaccountpayableExample;
import com.accp.domain.Tpayment;
import com.accp.domain.TpaymentExample;
import com.accp.domain.Tpaymentdetail;
import com.accp.domain.TpaymentdetailExample;
import com.accp.domain.Tpaymentprepay;
import com.accp.domain.TpaymentprepayExample;
import com.accp.domain.Tprepay;
import com.accp.domain.TprepayExample;
import com.accp.domain.Tprepaydetail;
import com.accp.domain.TprepaydetailExample;
import com.accp.domain.Tpurchasereceipt;
import com.accp.domain.TpurchasereceiptExample;
import com.accp.domain.Tpurchasereturn;
import com.accp.domain.TpurchasereturnExample;
import com.accp.mapper.DepartmentMapper;
import com.accp.mapper.EmployeeMapper;
import com.accp.mapper.SupplierMapper;
import com.accp.mapper.TaccountpayableMapper;
import com.accp.mapper.TpaymentMapper;
import com.accp.mapper.TpaymentdetailMapper;
import com.accp.mapper.TpaymentprepayMapper;
import com.accp.mapper.TprepayMapper;
import com.accp.mapper.TprepaydetailMapper;
import com.accp.mapper.TpurchasereceiptMapper;
import com.accp.mapper.TpurchasereturnMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TpaymentService {
	@Autowired
	private TpaymentMapper tpaymentMapper;
	@Autowired
	private TpaymentdetailMapper tpaymentdetailMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private TaccountpayableMapper taccountpayableMapper;
	@Autowired
	private TpaymentprepayMapper tpaymentprepayMapper;
	@Autowired
	private TpurchasereceiptMapper tpurchasereceiptMapper;
	@Autowired
	private TpurchasereturnMapper tpurchasereturnMapper;
	@Autowired
	private TprepayMapper tprepayMapper;
	@Autowired
	private TprepaydetailMapper tprepaydetailMapper;
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
		TpaymentExample tpaymentExample=new TpaymentExample();
		tpaymentExample.createCriteria().andIdLike("%"+id+"%");
		List<Tpayment> tpayments=tpaymentMapper.selectByExample(tpaymentExample);
		if (tpayments!=null&&tpayments.size()>0) {
			if (tpayments.size()<9) {
				id+="0";
				id+=(tpayments.size()+1);
			}else {
				id+=(tpayments.size()+1);
			}
		} else {
			id+="01";
		}
		return id;
	}
	/**
	 * 查询分页信息
	 * @param pageNum
	 * @param pageSize
	 * @param startseachtime
	 * @param endseachtime
	 * @param id
	 * @param sid
	 * @return
	 */
	public PageInfo<Tpayment> ShowPayments(Integer pageNum,Integer pageSize,String startseachtime,
			String endseachtime,String id,String sid) {
		if (pageNum==null) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=10;
		}
		Page<Tpayment> page=PageHelper.startPage(pageNum, pageSize);
		tpaymentMapper.showPayment(startseachtime, endseachtime, id, sid);
		return page.toPageInfo();
	}
	/**
	 * 按单号查询
	 * @param id
	 * @return
	 */
	public Tpayment showpaymentByid(String id) {
		Tpayment tpayment = tpaymentMapper.selectByPrimaryKey(id);
		Department department=departmentMapper.selectByPrimaryKey(tpayment.getDepartid());
		tpayment.setDepartName(department.getDepartname());
		TpaymentdetailExample tpaymentdetailExample=new TpaymentdetailExample();
		//详单状态不为0
		tpaymentdetailExample.createCriteria().andPidEqualTo(id).andStateNotEqualTo(0);
		List<Tpaymentdetail> tpaymentdetails=tpaymentdetailMapper.selectByExample(tpaymentdetailExample);
		tpayment.setTpaymentdetails(tpaymentdetails);
		Employee vouchingman =employeeMapper.selectByPrimaryKey(tpayment.getVouchingman());
		if (tpayment.getAuditman()!=null) {
			Employee auditman =employeeMapper.selectByPrimaryKey(tpayment.getAuditman());
			tpayment.setAuditmanName(auditman.getName());			
		}
		tpayment.setVouchingmanName(vouchingman.getName());
		//预付取用数据
		TpaymentprepayExample tpaymentprepayExample=new TpaymentprepayExample();
		tpaymentprepayExample.createCriteria().andPaymentidEqualTo(id).andStateNotEqualTo(0);
		List<Tpaymentprepay> tpaymentprepays=tpaymentprepayMapper.selectByExample(tpaymentprepayExample);
		if (tpaymentprepays!=null&&tpaymentprepays.size()>0) {
			for (Tpaymentprepay tpaymentprepay : tpaymentprepays) {
				Tprepay tprepay=tprepayMapper.selectByPrimaryKey(tpaymentprepay.getPrepayid());
				TprepaydetailExample tprepaydetailExample=new TprepaydetailExample();
				tprepaydetailExample.createCriteria().andPidEqualTo(tprepay.getId()).andStateNotEqualTo(0);
				List<Tprepaydetail> tprepaydetails=tprepaydetailMapper.selectByExample(tprepaydetailExample);
				Double money=0.0;
				for (Tprepaydetail prepaydetail : tprepaydetails) {
					money+=prepaydetail.getPrepay();
				}
				tpaymentprepay.setMoney(money);
			}
			tpayment.setTpaymentprepays(tpaymentprepays);
		}
//		设置供应商名称
		Supplier supplier=supplierMapper.selectByPrimaryKey(tpayment.getSid());
		tpayment.setSname(supplier.getFullname());
		return tpayment;
	}
	/**
	 * 新增单据
	 * @param tpayment
	 * @param vouchingman
	 * @return
	 */
	public int addPayment(Tpayment tpayment,String vouchingman) {
		int i=0;
		tpayment.setVouchingman(vouchingman);
		Employee employee=employeeMapper.selectByPrimaryKey(vouchingman);
		tpayment.setDepartid(employee.getDepartid());
		tpayment.setAuditstate(1);
		tpayment.setVouchingman(vouchingman);
		i=tpaymentMapper.insertSelective(tpayment);
		//新增详单
		List<Tpaymentdetail> tpaymentdetails=tpayment.getTpaymentdetails();
		List<Tpaymentdetail> list=tpaymentdetailMapper.selectByExample(null);
		if (tpaymentdetails!=null&&tpaymentdetails.size()>0) {
			int j=1;
			for (Tpaymentdetail tpaymentdetail : tpaymentdetails) {
				int id=list.size();
				id+=j;
				j++;
				//设置主表编号，单据状态0
				tpaymentdetail.setId(id);
				tpaymentdetail.setPid(tpayment.getId());
				tpaymentdetail.setState(1);
				tpaymentdetailMapper.insertSelective(tpaymentdetail);
			}
		}
		//新增取用预付记录
		List<Tpaymentprepay> tpaymentprepays=tpayment.getTpaymentprepays();
		//新增记录
		if (tpaymentprepays!=null&&tpaymentprepays.size()>0) {
			for (Tpaymentprepay tpaymentprepay : tpaymentprepays) {
				//设置主表编号，单据状态为0
				tpaymentprepay.setPaymentid(tpayment.getId());
				tpaymentprepay.setState(1);
				tpaymentprepayMapper.insertSelective(tpaymentprepay);
			}
		}
		return i;
	}
	/**
	 * 软删除单据
	 * @param id
	 * @return
	 */
	public int deletePayment(String id) {
		int i=0;
		Tpayment cktpayment=tpaymentMapper.selectByPrimaryKey(id);
		if (cktpayment.getAuditstate()==2) {
			return 101;
		}
		Tpayment tpayment=new Tpayment();
		tpayment.setId(id);
		tpayment.setAuditstate(0);
		i=tpaymentMapper.updateByPrimaryKeySelective(tpayment);
		TpaymentdetailExample tpaymentdetailExample=new TpaymentdetailExample();
		tpaymentdetailExample.createCriteria().andPidEqualTo(id);
		List<Tpaymentdetail> tpaymentdetails=tpaymentdetailMapper.selectByExample(tpaymentdetailExample);
		for (Tpaymentdetail tpaymentdetail : tpaymentdetails) {
			tpaymentdetail.setState(0);
			tpaymentdetailMapper.updateByPrimaryKeySelective(tpaymentdetail);
		}
		TpaymentprepayExample tpaymentprepayExample=new TpaymentprepayExample();
		tpaymentprepayExample.createCriteria().andPaymentidEqualTo(id).andStateEqualTo(1);
		List<Tpaymentprepay> tpaymentprepays=tpaymentprepayMapper.selectByExample(tpaymentprepayExample);
		if (tpaymentprepays!=null&&tpaymentprepays.size()>0) {
			for (Tpaymentprepay tpaymentprepay : tpaymentprepays) {
				tpaymentprepay.setState(0);
				tpaymentprepayMapper.updateByPrimaryKeySelective(tpaymentprepay);
			}
		}
		return i;
	}
	/**
	 * 修改单据信息
	 * @param tpayment
	 * @return
	 */
	public int updatePayment(Tpayment tpayment) {
		int i=0;
		i=tpaymentMapper.updateByPrimaryKeySelective(tpayment);
		//修改详表数据
		//获取详表信息
		List<Tpaymentdetail> tpaymentdetails=tpayment.getTpaymentdetails();
		//修改详表
		if(tpaymentdetails!=null&&tpaymentdetails.size()>0) {
			for (Tpaymentdetail tpaymentdetail : tpaymentdetails) {
				tpaymentdetailMapper.updateByPrimaryKeySelective(tpaymentdetail);
			}
		}
		return i;
	}
	/**
	 * 审核
	 * @param id
	 * @return
	 */
	public int ckPayment(String id) {
		int i=0;
		//修改主单状态
		Tpayment tpayment=new Tpayment();
		tpayment.setId(id);
		tpayment.setAuditstate(2);
		i=tpaymentMapper.updateByPrimaryKeySelective(tpayment);
		//获取详单数据
		TpaymentdetailExample tpaymentdetailExample=new TpaymentdetailExample();
		tpaymentdetailExample.createCriteria().andPidEqualTo(id).andStateNotEqualTo(0);
		List<Tpaymentdetail> tpaymentdetails=tpaymentdetailMapper.selectByExample(tpaymentdetailExample);
		for (Tpaymentdetail tpaymentdetail : tpaymentdetails) {
			//根据详单数据修改应付款信息
			TaccountpayableExample taccountpayableExample=new TaccountpayableExample();
			taccountpayableExample.createCriteria().andBillsnoEqualTo(tpaymentdetail.getSourceno());
			List<Taccountpayable> taccountpayables=taccountpayableMapper.selectByExample(taccountpayableExample);
			for (Taccountpayable taccountpayable : taccountpayables) {
				taccountpayable.setBalance(0.0);
				taccountpayable.setState(1);
				taccountpayableMapper.updateByPrimaryKeySelective(taccountpayable);
			}
		}
		//获取取用预付信息
		TpaymentprepayExample tpaymentprepayExample=new TpaymentprepayExample();
		tpaymentprepayExample.createCriteria().andPaymentidEqualTo(id).andStateNotEqualTo(0);
		List<Tpaymentprepay> tpaymentprepays=tpaymentprepayMapper.selectByExample(tpaymentprepayExample);
		if (tpaymentprepays!=null&&tpaymentprepays.size()>0) {
			for (Tpaymentprepay tpaymentprepay : tpaymentprepays) {
				//根据取用预付信息修改预付款信息
				Tprepay tprepay=tprepayMapper.selectByPrimaryKey(tpaymentprepay.getPrepayid());
				tprepay.setAudit(1);
				tprepayMapper.updateByPrimaryKeySelective(tprepay);
			}
		}
		return i;
	}
	/**
	 * 反审核
	 * @param id
	 * @return
	 */
	public int cancelckPayment(String id) {
		int i=0;
		//验证时间，和现在超出一周不能反审核
		Tpayment tpayment=tpaymentMapper.isOutTime(id);
		if (tpayment!=null&&tpayment.getId()!=null) {
			//修改主表状态
			tpayment.setAuditstate(1);
			i=tpaymentMapper.updateByPrimaryKeySelective(tpayment);
			//获取详单数据
			TpaymentdetailExample tpaymentdetailExample=new TpaymentdetailExample();
			tpaymentdetailExample.createCriteria().andPidEqualTo(id).andStateNotEqualTo(0);
			List<Tpaymentdetail> tpaymentdetails=tpaymentdetailMapper.selectByExample(tpaymentdetailExample);
			for (Tpaymentdetail tpaymentdetail : tpaymentdetails) {
				//根据详单数据修改应付款信息
				TaccountpayableExample taccountpayableExample=new TaccountpayableExample();
				taccountpayableExample.createCriteria().andBillsnoEqualTo(tpaymentdetail.getSourceno());
				List<Taccountpayable> taccountpayables=taccountpayableMapper.selectByExample(taccountpayableExample);
				for (Taccountpayable taccountpayable : taccountpayables) {
					taccountpayable.setBalance(taccountpayable.getPayment());
					taccountpayable.setState(0);
					taccountpayableMapper.updateByPrimaryKeySelective(taccountpayable);
				}
			}
			//获取取用预付信息
			TpaymentprepayExample tpaymentprepayExample=new TpaymentprepayExample();
			tpaymentprepayExample.createCriteria().andPaymentidEqualTo(id).andStateNotEqualTo(0);
			List<Tpaymentprepay> tpaymentprepays=tpaymentprepayMapper.selectByExample(tpaymentprepayExample);
			if (tpaymentprepays!=null&&tpaymentprepays.size()>0) {
				for (Tpaymentprepay tpaymentprepay : tpaymentprepays) {
					//根据取用预付信息修改预付款信息
					Tprepay tprepay=tprepayMapper.selectByPrimaryKey(tpaymentprepay.getPrepayid());
					tprepay.setAudit(0);
					tprepayMapper.updateByPrimaryKeySelective(tprepay);
				}
			}
			return i;			
		}else {
			return 101;
		}
	}
	/**
	 * 转单
	 * @param sid
	 * @return
	 */
	public List<Tpaymentdetail> postZD(String sid) {
		//获取供应商信息
		Supplier supplier=supplierMapper.selectByPrimaryKey(sid);
		List<Tpaymentdetail> tpaymentdetails=new ArrayList<Tpaymentdetail>();
		//从应付款明细中查询数据
		TaccountpayableExample taccountpayableExample=new TaccountpayableExample();
		taccountpayableExample.createCriteria().andSidEqualTo(sid).andStateEqualTo(0);
		List<Taccountpayable> taccountpayables=taccountpayableMapper.selectByExample(taccountpayableExample);
		if (taccountpayables!=null&&taccountpayables.size()>0) {
//			通过应付明细数据查询对应单据得到数据
			for (Taccountpayable taccountpayable : taccountpayables) {
				String billType=taccountpayable.getBillstype();
				String billNo=taccountpayable.getBillsno();
				TpaymentdetailExample tpaymentdetailExample=new TpaymentdetailExample();
				tpaymentdetailExample.createCriteria().andSourcenoEqualTo(billNo).andStateEqualTo(1);
				List<Tpaymentdetail> isPaymentds=tpaymentdetailMapper.selectByExample(tpaymentdetailExample);
				if (isPaymentds!=null&&isPaymentds.size()>0) {
					continue;
				}
				//单据来源为入库单时
				if (billType.equals("入库单")) {
					//查询对应数据：原单单号，原单日期，供应商编号，供应商名称，部门编号，部门名称，
					//采购人员名称，原单金额，现行金额
					TpurchasereceiptExample tpurchasereceiptExample=new TpurchasereceiptExample();
					tpurchasereceiptExample.createCriteria().andBillnoEqualTo(billNo);
					Tpurchasereceipt tpurchasereceipt=tpurchasereceiptMapper.selectByExample(tpurchasereceiptExample).get(0);
					//设置值
					Tpaymentdetail tpaymentdetail=new Tpaymentdetail();
					tpaymentdetail.setSourcetype("入库单");
					tpaymentdetail.setSourceno(tpurchasereceipt.getBillno());
					tpaymentdetail.setSourcedate(tpurchasereceipt.getBilldate());
					tpaymentdetail.setSid(sid);
					tpaymentdetail.setSname(supplier.getFullname());
					//获取采购人员及部门
					Employee employee=employeeMapper.selectByPrimaryKey(tpurchasereceipt.getSalesname());
					Department department=departmentMapper.selectByPrimaryKey(employee.getDepartid());
					tpaymentdetail.setDepartid(department.getDepartid());
					tpaymentdetail.setDepartname(department.getDepartname());
					tpaymentdetail.setBuyer(employee.getName());
					//设置原金额，现行金额
					tpaymentdetail.setPayment(taccountpayable.getPayment());
					tpaymentdetail.setBalance(taccountpayable.getBalance());
					tpaymentdetails.add(tpaymentdetail);
				} else {
					//单据来源为退货单时
					//查询对应数据：原单单号，原单日期，发票编码，供应商编号，供应商名称，部门编号，部门名称，
					//采购人员名称，项目名称，币别，汇率，原单金额，现行金额
					TpurchasereturnExample tpurchasereturnExample=new TpurchasereturnExample();
					tpurchasereturnExample.createCriteria().andBillnoEqualTo(billNo);
					Tpurchasereturn tpurchasereturn=tpurchasereturnMapper.selectByExample(tpurchasereturnExample).get(0);
					//设置值
					Tpaymentdetail tpaymentdetail=new Tpaymentdetail();
					tpaymentdetail.setSourcetype("退货单");
					tpaymentdetail.setSourceno(tpurchasereturn.getBillno());
					tpaymentdetail.setSourcedate(tpurchasereturn.getBilldate());
					tpaymentdetail.setSid(sid);
					tpaymentdetail.setSname(supplier.getFullname());
					//获取采购人员及部门
					Employee employee=employeeMapper.selectByPrimaryKey(tpurchasereturn.getSalesname());
					Department department=departmentMapper.selectByPrimaryKey(employee.getDepartid());
					tpaymentdetail.setDepartid(department.getDepartid());
					tpaymentdetail.setDepartname(department.getDepartname());
					tpaymentdetail.setBuyer(employee.getName());
					//设置原金额，现行金额
					tpaymentdetail.setPayment(taccountpayable.getPayment());
					tpaymentdetail.setBalance(taccountpayable.getBalance());
					tpaymentdetails.add(tpaymentdetail);
				}
			}
		}
		return tpaymentdetails;
	}
	/**
	 * 转预付单
	 * @param sid
	 * @return
	 */
	public List<Tpaymentprepay> postZDp(String sid) {
		List<Tpaymentprepay> tpaymentprepays=new ArrayList<Tpaymentprepay>();
		//查询未被使用预付主单信息
		TprepayExample tprepayExample=new TprepayExample();
		tprepayExample.createCriteria().andSidEqualTo(sid).andAuditstateEqualTo(2).andAuditEqualTo(0);
		List<Tprepay> tprepays=tprepayMapper.selectByExample(tprepayExample);
		if (tprepays!=null&&tprepays.size()>0) {
			//根据预付单信息查询数据:来源单号，预付金额，剩余金额，取用金额
			for (Tprepay tprepay : tprepays) {
				TpaymentprepayExample tpaymentprepayExample=new TpaymentprepayExample();
				tpaymentprepayExample.createCriteria().andStateEqualTo(1).andPrepayidEqualTo(tprepay.getId());
				List<Tpaymentprepay> ispaymentps=tpaymentprepayMapper.selectByExample(tpaymentprepayExample);
				if (ispaymentps!=null&&ispaymentps.size()>0) {
					continue;
				}
				Tpaymentprepay tpaymentprepay=new Tpaymentprepay();
				tpaymentprepay.setPrepayid(tprepay.getId());
				//从预付详表获取预付金额和余额
				Double money=0.0;
				Double balance=0.0;
				TprepaydetailExample tprepaydetailExample=new TprepaydetailExample();
				tprepaydetailExample.createCriteria().andPidEqualTo(tprepay.getId()).andStateEqualTo(1);
				List<Tprepaydetail> tprepaydetails=tprepaydetailMapper.selectByExample(tprepaydetailExample);
				for (Tprepaydetail tprepaydetail : tprepaydetails) {
					money+=tprepaydetail.getPrepay();
					balance+=tprepaydetail.getBalance();
				}
				tpaymentprepay.setMoney(money);
				tpaymentprepay.setBalance(balance);
				tpaymentprepay.setTakenmoney(balance);
				tpaymentprepays.add(tpaymentprepay);
			}
		}
		return tpaymentprepays;
	}
	
}
