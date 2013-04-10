package org.xingte.jxc.service;

import java.util.List;

import org.xingte.jxc.daoimpl.DepartmentDaoImpl;
import org.xingte.jxc.model.Department;


public class DepartmentService {
	private DepartmentDaoImpl departmentDaoImpl=new DepartmentDaoImpl();
	
	public void addDepartment(Department department){
		departmentDaoImpl.addOne(department);
	}
	
	public List<Department> getAllDepartments(){
		return  departmentDaoImpl.getAll();
	}
}
