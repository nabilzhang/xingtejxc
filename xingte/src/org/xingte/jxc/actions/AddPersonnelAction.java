package org.xingte.jxc.actions;

import org.xingte.jxc.dto.PersonnelDTO;
import org.xingte.jxc.service.PersonnelService;
import com.opensymphony.xwork2.ModelDriven;

public class AddPersonnelAction implements ModelDriven{
	private PersonnelService personnelService=new PersonnelService();
	private PersonnelDTO personnelDTO=new PersonnelDTO();
	private String result;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public PersonnelDTO getPersonnelDTO() {
		return personnelDTO;
	}
	public void setPersonnelDTO(PersonnelDTO personnelDTO) {
		this.personnelDTO = personnelDTO;
	}
	
	public String Add(){
		personnelService.addPersonnel(getPersonnelDTO());
		result="1";
		return "add";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return personnelDTO;
	}
}
