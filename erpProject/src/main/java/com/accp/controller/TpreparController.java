package com.accp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Employee;
import com.accp.domain.Tprepay;
import com.accp.service.TprepayService;
import com.github.pagehelper.PageInfo;

@RestController("/tprepar")
public class TpreparController {
	@Autowired
	private TprepayService tprepayService;
	
	@GetMapping("/showPrepays")
	@ResponseBody
	public PageInfo<Tprepay> showPrepays(Integer pageNum,Integer pageSize,String startseachtime,
			String endseachtime,String id,String sid) {
		return tprepayService.showPrepays(pageNum, pageSize, startseachtime, endseachtime, id, sid);
	}
	
	/**
	 * 按单号查询
	 * @param id
	 * @return
	 */
	@GetMapping("/showPrepayById")
	@ResponseBody
	public Tprepay showPrepayById(String id) {
		return tprepayService.showPrepayById(id);
	}
	
	/**
	 * 新增单据
	 * @param tprepay
	 * @return
	 */
	@PostMapping("/addTprepay")
	@ResponseBody
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
	@ResponseBody
	public int deleteTprepay(String id) {
		return tprepayService.deleteTprepay(id);
	}
	/**
	 * 审核
	 * @param id
	 * @return
	 */
	@PostMapping("/ckTprepay")
	@ResponseBody
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
	@ResponseBody
	public int cancelCKTprepay(String id) {
		return tprepayService.cancelCKTprepay(id);
	}
	/**
	 * 修改单据
	 * @param tprepay
	 * @return
	 */
	@PostMapping("/updateTprepay")
	@ResponseBody
	public int updateTprepay(@RequestBody Tprepay tprepay) {
		return tprepayService.updateTprepay(tprepay);
	}
}
