package org.xingte.jxc.actions;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.xingte.jxc.model.User;
import org.xingte.jxc.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxLoginAction extends ActionSupport implements SessionAware {
	/**
	 * 接收用户名
	 */
	private String name;
	/**
	 * 接收用户输入密码
	 */
	private String password;
	/**
	 * session属性
	 */
	private Map session;
	/**
	 * 向客户端返回登录处理结果
	 */
	private String result;
	
	public void setResult(String result) {
		this.result = result;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getResult(){
		return result;
	}
	
	/**
	 * 执行登录并返回结果
	 */
	public String execute() throws Exception,UnsupportedEncodingException{
		User user=new User();
		user.setName(this.name);
		user.setPassword(this.password);
		this.result="0";
		System.out.print(result);
		UserService userService = new UserService();
		if(userService.Logon(user)){
			this.result="1";
			user=userService.GetOneUserByName(user.getName());
			session.put("user",user);
			System.out.println(user);
			System.out.println(result);
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
}
