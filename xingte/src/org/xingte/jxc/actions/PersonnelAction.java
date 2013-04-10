package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.service.PersonnelService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PersonnelAction extends ActionSupport implements ModelDriven{
	private PersonnelService personnelService=new PersonnelService();
	
	private List PersonnelDTOList;
	

	public void setPersonnelDTOList(List personnelDTOList) {
		PersonnelDTOList = personnelDTOList;
	}
	
	public String getAllPersonnels(){
		this.PersonnelDTOList=personnelService.getAllPersonnelDTOs();
		return "getallpersonnels";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return PersonnelDTOList;
	}

}
