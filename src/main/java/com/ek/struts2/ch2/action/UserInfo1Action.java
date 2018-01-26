package com.ek.struts2.ch2.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.ek.struts2.ch2.from.UserInfoForm;
import com.ek.struts2.ch2.model.dao.UserInfo1DAO;
import com.ek.struts2.ch2.model.pojo.UserInfo;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfo1Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserInfoForm userInfoForm;
	private List<UserInfoForm> userInfoList = null;
	private File[] myfiles;
	private String uuid;
	private InputStream inputStream;
	
	//自定义result 中可以取到这个文件名
	private String downFileName;
	

	public String getDownFileName() {
		return downFileName;
	}

	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public File[] getMyfiles() {
		return myfiles;
	}

	public void setMyfiles(File[] myfiles) {
		this.myfiles = myfiles;
	}

	public String save() {
		 
			UserInfo pojo = new UserInfo();
			pojo.setUsername(userInfoForm.getUsername());
			pojo.setSex("1");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				pojo.setBirthday(sdf.parse(userInfoForm.getBirthday()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		
			
			FileInputStream input = null;
			try {
				int i = 0;
				for (File myfile : myfiles) {
					input = new FileInputStream(myfile); //获得一个输入流
					byte[] filetemp = new byte[input.available()]; //得到输入流的大小
					input.read(filetemp); //写入文件流
					if (i == 0) {
						pojo.setPhoto1(filetemp);
					} else if (i == 1) {
						pojo.setPhoto2(filetemp);
					} else {
						pojo.setPhoto3(filetemp);
					}
					i++;
				}
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
			
			UserInfo1DAO dao = new UserInfo1DAO();
			dao.save(pojo);
			
		return SUCCESS;
	}

	public String list() {

		return "listpage";
	}
	
	//看看这个http://blog.csdn.net/softimes/article/details/7084984
	public String downLoad(){
		
		UserInfo1DAO dao = new UserInfo1DAO();
		
/**	这种是不推荐的 推荐使用值栈 值栈中取uuid    */
//		ActionContext  actionContext =ActionContext.getContext(); 
//		String[] uuid = (String[])actionContext.getParameters().get("uuid");//所有请求参数的值都在这个map里 相当于 request 这个方法得到的是数组
//		if(uuid==null||uuid.length==0){
//			return null;
//		}
//		UserInfo userinfo = dao.findById(Integer.valueOf(uuid[0]));
		
		
		/** 推荐的方式 值栈中添加一个uuid */
		if(uuid==null){ 
			return null;
		}
		UserInfo userinfo = dao.findById(Integer.valueOf(uuid));

		
/** 	不需要这样去response , 推荐在struts配置文件中 配一个result-type来实现    */
//		HttpServletResponse response = ServletActionContext.getResponse(); 
//		response.setContentType("application/x-msdownload"); //setContentType 设置mime类型
//		response.setHeader("Content-Disposition", "attachment;filename=".concat(userinfo.getUsername())); //setHeader头信息 , Content-Disposition 的作用 当ContentType为下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
//		//把2进制输出
//		OutputStream output = null;
//		try {
//			output = response.getOutputStream(); //得到一个输出流
//			output.write(userinfo.getPhoto1()); //写数据
//			output.flush(); //清空缓冲区 (上传的时候没有,下载才有)
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			if(output!=null){
//				try {
//					output.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
 //			}
//		}
		
		
		/** 推荐的方式  值栈中添加一个 inputStream 再在struts配置文件中配置 inputName*/
		inputStream = new ByteArrayInputStream(userinfo.getPhoto1());
		downFileName = userinfo.getUsername();// 用户名作为文件名
		
		//不用配置文件 下载不用返回页面 return null; 
		//用配置文件 return "download";
		//用配置文件 (自定义的 result-type)
		return "mydownload";
		
	}

}