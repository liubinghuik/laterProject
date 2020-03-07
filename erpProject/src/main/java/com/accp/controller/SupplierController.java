package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Supplier;
import com.accp.domain.Suppliercategory;
import com.accp.service.SupplierService;
import com.github.pagehelper.PageInfo;

@RestController()
@RequestMapping("/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	@GetMapping("/showSupllier")
	public PageInfo<Supplier> showSupllier(Integer pageNum,Integer pageSize,
			String sid,String fullName,String classId) {
		return supplierService.showSupllier(pageNum, pageSize, sid, fullName, classId);
	}
	@GetMapping("/showSupplierBysid")
	public Supplier showSupplierBysid(String sid) {
		return supplierService.showSupplierBysid(sid);
	}
	@PostMapping("/addSupplier")
	public int addSupplier(@RequestBody Supplier supplier) {
		return supplierService.addSupplier(supplier);
	}
	@PostMapping("/updateSupplier")
	public int updateSupplier(@RequestBody Supplier supplier) {
		return supplierService.updateSupplier(supplier);
	}
	@PostMapping("/deleteSupplier")
	public int deleteSupplier(String sid) {
		return supplierService.deleteSupplier(sid);
	}
	@GetMapping("/showSuppliercategorys")
	public List<Suppliercategory> showSuppliercategorys() {
		return supplierService.showSuppliercategorys();
	}
	@PostMapping("/isIdExist")
	public boolean isIdExist(String sid) {
		return supplierService.isIdExist(sid);
	}
	/**
	 * 展示供应商列表
	 * @return
	 */
	@GetMapping("/showSupList")
	public List<Supplier> showSupList() {
		return supplierService.showSupList();
	}
}
