package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.dto.UserGroupDTO;
import org.xingte.jxc.service.UserGroupService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserGroupAction extends ActionSupport implements ModelDriven {
	private UserGroupService userGroupService=new UserGroupService();
	private List<UserGroupDTO> userGroupDTOs;
	
	public List<UserGroupDTO> getUserGroupDTOs() {
		return userGroupDTOs;
	}

	public void setUserGroupDTOs(List<UserGroupDTO> userGroupDTOs) {
		this.userGroupDTOs = userGroupDTOs;
	}
	
	public String getAllUserGroupDTOs(){
		userGroupDTOs=userGroupService.getAllUserGroupDTOs();
		return "all";
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userGroupDTOs;
	}

}
