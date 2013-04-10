package org.xingte.jxc.actions;
import java.util.Map;

import org.xingte.jxc.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IndexAction extends ActionSupport implements ModelDriven<User> {
	private User user;
	public void setUser(User user) {
		this.user = user;
	}

	public String execute(){
		this.user=(User)ActionContext.getContext().getSession().get("user");
		System.out.println(user);
		System.out.println("home");
		String result=SUCCESS;
		return result;
	}
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
