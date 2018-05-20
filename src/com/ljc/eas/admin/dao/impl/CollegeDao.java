package com.ljc.eas.admin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ljc.eas.admin.dao.ICollegeDao;
import com.ljc.eas.admin.pojo.College;
import com.ljc.eas.base.BaseDao;

@Repository
public class CollegeDao extends BaseDao implements ICollegeDao{

	@Override
	public List<College> queryAll() {
		// TODO Auto-generated method stub
		String hql="from College as college order by college.id desc";
		List<College> collegeList=(List <College>)(getHibernateTemplate().find(hql));
		if (collegeList.isEmpty()) {
			return null;
		}
		else {
			return collegeList;
		}
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		String hql="delete from College college where college.id=?";
		Query query=session.createQuery(hql);
		query.setLong(0, id);
		int dele=query.executeUpdate();
		session.close();
		return dele;
	}

	@Override
	public int add(College record) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(record);
		return 0;
	}

	@Override
	public int update(College record) {
		// TODO Auto-generated method stub
			getHibernateTemplate().update(record);
			return 1;
	}

	@Override
	public College queryByName(String name) {
		// TODO Auto-generated method stub
		String hql="from College as college where college.name=?";
		Object[] parameters=new String[]{name}; 
		List<College> listCollege=(List<College>)(getHibernateTemplate().find(hql,parameters));
		if (listCollege.isEmpty()) {
			return null;
		}else{
			return listCollege.get(0);
		}
	}

	@Override
	public College queryById(long id) {
		// TODO Auto-generated method stub
		String hql="from College as college where college.id=?";
		Object[] parameters={id}; 
		List<College> listCollege=(List<College>)(getHibernateTemplate().find(hql,parameters));
		if (listCollege.isEmpty()) {
			return null;
		}else{
			return listCollege.get(0);
		}
	}

	@Override
	public List<College> queryByPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		String hql="from College as college order by college.id desc";
		Query query=session.createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageNumber*pageSize);
		List<College> collegeList=query.list();
		session.close();
		if (collegeList.isEmpty()) {
			return null;
		}
		else {
			return collegeList;
		}
	}

	@Override
	public long queryCount() {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		String hql="select count(college) from College college";
		Query query=session.createQuery(hql);
		long count=(Long) query.uniqueResult();
		session.close();
		return count;
	}
    
}
