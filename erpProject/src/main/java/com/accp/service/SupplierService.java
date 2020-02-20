package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Supplier;
import com.accp.domain.SupplierExample;
import com.accp.mapper.SupplierMapper;

@Service
@Transactional
public class SupplierService {
	@Autowired
	private SupplierMapper supplierMapper;
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
