package com.accp.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Employee;
import com.accp.domain.Tprepay;
import com.accp.domain.Tprepaydetail;
import com.accp.service.TprepayService;
import com.github.pagehelper.PageInfo;

@RestController()
@RequestMapping("/tprepar")
public class TpreparController {
	@Autowired
	private TprepayService tprepayService;
	
	@GetMapping("/showPrepays")
	public PageInfo<Tprepay> showPrepays(Integer pageNum,Integer pageSize,String startseachtime,
			String endseachtime,String id,String sid) {
		return tprepayService.showPrepays(pageNum, pageSize, startseachtime, endseachtime, id, sid);
	}
	/**
	 * 自动生成单据
	 * @param date
	 * @return
	 */
	@GetMapping("/postId")
	public String postId(String date) {
		return tprepayService.postId(date);
	}
	/**
	 * 按单号查询
	 * @param id
	 * @return
	 */
	@GetMapping("/showPrepayById")
	public Tprepay showPrepayById(String id) {
		return tprepayService.showPrepayById(id);
	}
	
	/**
	 * 新增单据
	 * @param tprepay
	 * @return
	 */
	@PostMapping("/addTprepay")
	public int addTprepay(@RequestBody Tprepay tprepay,HttpSession session) {
		Employee employee=new Employee();
		employee.setPersonid("1001");
		session.setAttribute("user", employee);
		Employee vouchingman=(Employee) session.getAttribute("user");
		return tprepayService.addTprepay(tprepay,vouchingman.getPersonid());
	}
	/**
	 * 软删除单据
	 * @param id
	 * @return
	 */
	@PostMapping("/deleteTprepay")
	public int deleteTprepay(String id) {
		return tprepayService.deleteTprepay(id);
	}
	/**
	 * 审核
	 * @param id
	 * @return
	 */
	@PostMapping("/ckTprepay")
	public int ckTprepay(String id,HttpSession session) {
		Employee employee=new Employee();
		employee.setPersonid("1001");
		session.setAttribute("user", employee);
		Employee auditman=(Employee) session.getAttribute("user");
		return tprepayService.ckTprepay(id,auditman.getPersonid());
	}
	/**
	 * 反审核
	 * @param id
	 * @return
	 */
	@PostMapping("/cancelCKTprepay")
	public int cancelCKTprepay(String id) {
		return tprepayService.cancelCKTprepay(id);
	}
	/**
	 * 修改单据
	 * @param tprepay
	 * @return
	 */
	@PostMapping("/updateTprepay")
	public int updateTprepay(@RequestBody Tprepay tprepay) {
		return tprepayService.updateTprepay(tprepay);
	}
	/**
	 * 采购订单转预付款单
	 * @param sid
	 * @return
	 */
	@GetMapping("/postZD")
	public List<Tprepaydetail> postZD(String sid) {
		return tprepayService.postZD(sid);
	}
}
