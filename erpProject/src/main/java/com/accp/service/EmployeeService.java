package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Department;
import com.accp.domain.Employee;
import com.accp.mapper.DepartmentMapper;
import com.accp.mapper.EmployeeMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public PageInfo<Employee> showPerson(Integer pageNum,Integer pageSize,
			String personID,String name,String departID){
		if (pageNum==null) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=10;
		}
		Page<Employee> page=PageHelper.startPage(pageNum, pageSize);
		employeeMapper.showPerson(personID, name, departID);
		return page.toPageInfo();
	}
	/**
	 * 新增员工
	 * @param employee
	 * @return
	 */
	public int addEmployee(Employee employee) {
		int i= 0;
		i=employeeMapper.insertSelective(employee);
		return i;
	}
	
	public int updateEmployee(Employee employee) {
		int i=0;
		i=employeeMapper.updateByPrimaryKeySelective(employee);
		return i;
	}
	
	public int deleteEmployee(String personid) {
		int i=0;
		Employee employee=new Employee();
		employee.setPersonid(personid);
		employee.setState(1);
		i=employeeMapper.updateByPrimaryKeySelective(employee);
		return i;
	}
	
	public Employee showEmployeeById(String personid) {
		Employee employee=employeeMapper.selectByPrimaryKey(personid);
		return employee;
	}
	
	public boolean idIsExist(String personid) {
		boolean b=false;
		Employee employee=employeeMapper.selectByPrimaryKey(personid);
		if (employee!=null) {
			b=true;
		}
		return b;
	}
	
	public List<Department> showDepartments() {
		List<Department> departments=departmentMapper.selectByExample(null);
		return departments;
	}
}
