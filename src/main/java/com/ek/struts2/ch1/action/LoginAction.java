package com.ek.struts2.ch1.action;

import com.ek.struts2.ch1.form.LoginForm;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private LoginForm loginForm;
	
	public LoginForm getLoginForm() {
		return loginForm;
	}
	public void setLoginForm(LoginForm loginForm) {
		this.loginForm = loginForm;
	}

	
	

	@Override
	public void validate() {
		if(loginForm.getUsername()==null||"".equals(loginForm.getUsername())){
			super.addFieldError("loginForm.username", "must enter an user name!");
			this.addActionError("222");
		}
		if(loginForm.getPassword()==null||"".equals(loginForm.getPassword())){
			super.addFieldError("loginForm.password", "must enter a password!");
		}
	}
	
	
	public String login(){
		if(loginForm==null){
			return this.INPUT;
		}
		if("ek".equals(loginForm.getUsername())&&"123".equals(loginForm.getPassword())){
			return this.SUCCESS;
		}
		return this.INPUT;
	}
}
