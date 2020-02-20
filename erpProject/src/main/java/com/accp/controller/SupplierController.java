package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Supplier;
import com.accp.service.SupplierService;

@RestController("/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	/**
	 * 展示供应商列表
	 * @return
	 */
	@GetMapping("/showSupList")
	@ResponseBody
	public List<Supplier> showSupList() {
		return supplierService.showSupList();
	}
}