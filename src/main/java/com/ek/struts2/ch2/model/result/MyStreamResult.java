package com.ek.struts2.ch2.model.result;

import org.apache.struts2.dispatcher.StreamResult;

import com.opensymphony.xwork2.ActionInvocation;

public class MyStreamResult extends StreamResult {

	// 这个还要在配置文件中配置
	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
		
		//在下载的action中把downFileName 存到值栈中
		String downFileName = (String) invocation.getStack().findValue(conditionalParse("downFileName", invocation)); //覆盖一下值栈取文件名称
		super.setContentDisposition("attachment;filename="+downFileName);  //设置一下父类的这个属性
		super.doExecute(finalLocation, invocation); //调用执行一下父类的方法
	}

	
}