package com.ek.struts2.ch2.model.dao;

import org.hibernate.Session;

import com.ek.struts2.ch2.model.pojo.UserInfo;
import com.ek.struts2.ch2.model.util.HibernateSessionFactory;

public class UserInfo1DAO {
	private Session session = HibernateSessionFactory.getSession();
	
	public void save(UserInfo user){
	
		session.save(user);
	}
	
	public UserInfo findById(Integer uuid){
		 
		return (UserInfo)session.get(UserInfo.class, uuid);
		
	}

}
