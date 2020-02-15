package com.accp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
