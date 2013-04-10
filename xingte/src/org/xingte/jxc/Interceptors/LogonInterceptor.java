package org.xingte.jxc.Interceptors;

import java.util.Map;

import org.xingte.jxc.model.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LogonInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map session=arg0.getInvocationContext().getSession();
		User user=(User)session.get("user");
		if(null!=user){
			System.out.println("OK");
			return arg0.invoke();
		}else{
			System.out.print("loginaaaa");
			return "global.login";
		}
	}
	
}
