package org.xingte.jxc.actions;

import java.util.List;

import org.xingte.jxc.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserListAction extends ActionSupport implements ModelDriven {
	private UserService userService=new UserService();
	
	private List userList;

	public void setUserList(List userList) {
		userList = userList;
	}
	
	public String returnList(){
		userList=userService.getAllUserDTOs();
		return "all";
	}

	@Override
	public Object getModel() {
		return userList;
	}
	
}
