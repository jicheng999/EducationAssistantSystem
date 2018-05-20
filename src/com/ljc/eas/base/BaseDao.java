package com.ljc.eas.base;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private HibernateTemplate hibernateTemplate;

	protected HibernateTemplate getHibernateTemplate() {
		hibernateTemplate=new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
