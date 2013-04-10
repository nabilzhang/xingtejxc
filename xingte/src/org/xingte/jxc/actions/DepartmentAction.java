package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.model.Department;
import org.xingte.jxc.service.DepartmentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven {
	private DepartmentService departmentService=new DepartmentService();
	private Department department;
	
	
	public Department getDepartment() {
		return department;
	}
	
	public String result;
	

	public String getResult() {
		return result;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	private List departmentList;
	//返回所有部门列表
	public String reDepartmentList(){
		departmentList=departmentService.getAllDepartments();
		return "alldepartment";
	}
	//添加部门
	public String AddDepartment(){
		departmentService.addDepartment(department);
		result="1";
		return "addDpartment";
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return departmentList;
	}

	public void setDepartmentList(List departmentList) {
		this.departmentList = departmentList;
	}


	

}
