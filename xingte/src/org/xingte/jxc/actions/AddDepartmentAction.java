package org.xingte.jxc.actions;

import org.xingte.jxc.model.Department;
import org.xingte.jxc.service.DepartmentService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddDepartmentAction extends ActionSupport {
	private DepartmentService departmentService=new DepartmentService();
	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String AddDepartment(){
		Department department=new Department();
		department.setName(name);
		department.setDescription(description);
		departmentService.addDepartment(department);
		result="1";
		return "addDepartment";
	}

}
