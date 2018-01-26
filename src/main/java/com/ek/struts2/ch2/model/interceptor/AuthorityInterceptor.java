package com.ek.struts2.ch2.model.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
//		ActionContext ctx = actionInvocation.getInvocationContext();
//		Map<String,Object> session = ctx.getSession();
//		
//		Action action = (Action) actionInvocation.getAction(); 
//		//登录用户session存在
//			if(session.get("sessionLoginUser")!=null){
//				return actionInvocation.invoke();
//			}
//		
//		//属于LoginAction的实例
//		if (action instanceof LoginAction) {  
//			 return actionInvocation.invoke();  
//		 } else{
//			 ctx.put("mesg", "登录时间以超时，请重新登录！");
//			return Action.LOGIN;
//		}
 
		return actionInvocation.invoke();
	} 

}