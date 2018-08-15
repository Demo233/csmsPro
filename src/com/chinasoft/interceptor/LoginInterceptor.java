package com.chinasoft.interceptor;

import java.lang.reflect.Method;

import org.apache.struts2.ServletActionContext;

import com.chinasoft.annotation.Login;
import com.chinasoft.domain.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		ActionProxy proxy =  invocation.getProxy();
		
		Action action = (Action) proxy.getAction();
		
		//拿到执行的方法
		String methodName = proxy.getMethod();
		Method method = action.getClass().getMethod(methodName);
		
		// 判断方法上是否有Login注解,如果有就判断Session中User是否为空
		if(method!=null){
			// 得到方法上的注解
			Login login = method.getAnnotation(Login.class);
			if(login!=null){
				User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
				if(user == null){
					return "noLogin";
				}
			}
		}
		return invocation.invoke();
	}

}
