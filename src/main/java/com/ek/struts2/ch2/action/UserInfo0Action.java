package com.ek.struts2.ch2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ek.struts2.ch2.from.UserInfoForm;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfo0Action extends ActionSupport {

	private UserInfoForm userInfoForm;
	private List<UserInfoForm> userInfoList=null;
	private File myfile; //文件域 ( java.io.File)
	private String myfileContentType; // 文件类型   ...ContentType (必须以ContentType结尾)
	private String myfileFileName; // 文件名   ...FileName (必须以FileName结尾)
	 
	
	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public UserInfoForm getUserInfoForm() {
		return userInfoForm;
	}

	public void setUserInfoForm(UserInfoForm userInfoForm) {
		this.userInfoForm = userInfoForm;
	}

	public List<UserInfoForm> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfoForm> userInfoList) {
		this.userInfoList = userInfoList;
	}

	
	
	public String save(){
		
		System.out.println(userInfoForm.getUsername());
		System.out.println(userInfoForm.getSex());
		System.out.println(userInfoForm.getBirthday());	
		System.out.println(this.myfile);
		System.out.println(this.myfileContentType);
		System.out.println(this.myfileFileName);
		FileInputStream input = null;
		try {
			input = new 	FileInputStream(this.myfile);
			byte [] filetemp = new byte[input.available()];
			System.out.println(filetemp);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return SUCCESS;
	}
	
	


	public String list(){
		
		UserInfoForm userinfo1 = new UserInfoForm();
		userinfo1.setUsername("ek1");
		userinfo1.setSex("1");
		userinfo1.setBirthday("1983-04-24");
		
		UserInfoForm userinfo2 = new UserInfoForm();
		userinfo2.setUsername("ek2");
		userinfo2.setSex("1");
		userinfo2.setBirthday("1988-04-24");
		
		List<UserInfoForm> userList = new ArrayList<UserInfoForm>();
		userList.add(userinfo1);
		userList.add(userinfo2);
		
		this.userInfoList = userList;
		
		return "listpage";
	}
}