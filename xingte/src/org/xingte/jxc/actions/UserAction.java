package org.xingte.jxc.actions;
import org.xingte.jxc.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven {
	private User user;
	public void setUser(User user) {
		this.user = user;
	}
	public String scc(){
		return SUCCESS;
	}
	public String add(){
		return "add";
	}
	//清除session并退出
	public String logonout(){
		ActionContext.getContext().getSession().clear();
		return "quit";
	}
	//返回当前登录用户对象
	public String CurrentUser(){
		user=(User)ActionContext.getContext().getSession().get("user");
		System.out.print(user+"hao");
		return "current";
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
