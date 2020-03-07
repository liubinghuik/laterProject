package com.accp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Employee;
import com.accp.domain.Tpayment;
import com.accp.domain.Tpaymentdetail;
import com.accp.domain.Tpaymentprepay;
import com.accp.service.TpaymentService;
import com.github.pagehelper.PageInfo;

@RestController()
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private TpaymentService tpaymentService;
	
	@GetMapping("/ShowPayments")
	public PageInfo<Tpayment> ShowPayments(Integer pageNum,Integer pageSize,String startseachtime,
			String endseachtime,String id,String sid) {
		return tpaymentService.ShowPayments(pageNum, pageSize, startseachtime, endseachtime, id, sid);
	}
	
	/**
	 * 按单号查询
	 * @param id
	 * @return
	 */
	@GetMapping("/showpaymentByid")
	public Tpayment showpaymentByid(String id) {
		return tpaymentService.showpaymentByid(id);
	}
	
	/**
	 * 新增单据
	 * @param tpayment
	 * @param vouchingman
	 * @return
	 */
	@PostMapping("/addPayment")
	public int addPayment(@RequestBody Tpayment tpayment,HttpSession session) {
		Employee employee=new Employee();
		employee.setPersonid("1001");
		session.setAttribute("user", employee);
		Employee vouchingman=(Employee) session.getAttribute("user");
		return tpaymentService.addPayment(tpayment, vouchingman.getPersonid());
	}
	
	/**
	 * 软删除单据
	 * @param id
	 * @return
	 */
	@PostMapping("/deletePayment")
	public int deletePayment(String id) {
		return tpaymentService.deletePayment(id);
	}
	
	/**
	 * 修改单据信息
	 * @param tpayment
	 * @return
	 */
	@PostMapping("/updatePayment")
	public int updatePayment(@RequestBody Tpayment tpayment) {
		return tpaymentService.updatePayment(tpayment);
	}
	
	/**
	 * 审核
	 * @param id
	 * @return
	 */
	@PostMapping("/ckPayment")
	public int ckPayment(String id) {
		return tpaymentService.ckPayment(id);
	}
	
	/**
	 * 反审核
	 * @param id
	 * @return
	 */
	@PostMapping("/cancelckPayment")
	public int cancelckPayment(String id) {
		return tpaymentService.cancelckPayment(id);
	}
	
	/**
	 * 转单
	 * @param sid
	 * @return
	 */
	@GetMapping("/postZD")
	public List<Tpaymentdetail> postZD(String sid) {
		return tpaymentService.postZD(sid);
	}
	
	/**
	 * 转预付单
	 * @param sid
	 * @return
	 */
	@GetMapping("/postZDp")
	public List<Tpaymentprepay> postZDp(String sid) {
		return tpaymentService.postZDp(sid);
	}
	
	/**
	 * 自动生成单据编号
	 * @param date
	 * @return
	 */
	@GetMapping("/postId")
	public String postId(String date) {
		return tpaymentService.postId(date);
	}
}
