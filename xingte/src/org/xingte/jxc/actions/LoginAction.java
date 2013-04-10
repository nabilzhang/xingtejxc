package org.xingte.jxc.actions;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.xingte.jxc.model.User;
import org.xingte.jxc.service.UserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven,SessionAware{

	private User user=new User();
	
	private Map session;
	
	public void setSession(Map session) {
		this.session = session;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String logincheck() throws UnsupportedEncodingException {
		UserService userService = new UserService();
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		if (userService.Logon(user)) {
			user=userService.GetOneUserByName(user.getName());
			session.put("user",user);
			System.out.println(session.get("user"));
			return SUCCESS;
		}

		return "failed";
	}

	public String failed() {
		return "failed";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
