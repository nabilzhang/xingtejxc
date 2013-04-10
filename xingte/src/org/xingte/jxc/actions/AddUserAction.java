package org.xingte.jxc.actions;

import org.xingte.jxc.model.User;
import org.xingte.jxc.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddUserAction extends ActionSupport implements ModelDriven {
	private UserService userService=new UserService();	
	private User user=new User();//这里一定要先new出来,否则无法接受客户端发送的消息
	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public String addUser(){
		System.out.println(user);
		userService.addUser(user);
		return "add";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
