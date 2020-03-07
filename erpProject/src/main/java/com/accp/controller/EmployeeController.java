package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.domain.Department;
import com.accp.domain.Employee;
import com.accp.service.EmployeeService;
import com.github.pagehelper.PageInfo;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/showPerson")
	public PageInfo<Employee> showPerson(Integer pageNum,Integer pageSize,
			String personID,String name,String departID){
		return employeeService.showPerson(pageNum, pageSize, personID, name, departID);
	}
	@PostMapping("/addEmployee")
	public int addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	@PostMapping("/updateEmployee")
	public int updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	@PostMapping("/deleteEmployee")
	public int deleteEmployee(String personid) {
		return employeeService.deleteEmployee(personid);
	}
	@GetMapping("/showEmployeeById")
	public Employee showEmployeeById(String personid) {
		return employeeService.showEmployeeById(personid);
	}
	@GetMapping("/idIsExist")
	public boolean idIsExist(String personid) {
		return employeeService.idIsExist(personid);
	}
	@GetMapping("/showDepartments")
	public List<Department> showDepartments() {
		return employeeService.showDepartments();
	}
}
