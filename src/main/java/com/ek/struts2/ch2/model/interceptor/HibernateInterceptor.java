package com.ek.struts2.ch2.model.interceptor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ek.struts2.ch2.model.util.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 过滤器加载了HibernateSessionFactory 获得hibernate1的 session
 * @author EK
 * @date 2017年7月26日
 */
public class HibernateInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {
		//加载一下HibernateSessionFactory
		HibernateSessionFactory.getSessionFactory();
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tr = null;
		String returnResult = null;
		
		try {
			tr = session.beginTransaction();
			returnResult = arg0.invoke();  //走到这里调用其它的拦截器,然后走到Action , 没有拦截器就走到Action
			tr.commit();
		} catch (Exception e) {
			if(tr!=null){
				tr.rollback();
			}
			e.printStackTrace();
		}finally{
			HibernateSessionFactory.closeSession();
		}
		
		return returnResult;
	}

}