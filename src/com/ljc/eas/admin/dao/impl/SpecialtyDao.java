package com.ljc.eas.admin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ljc.eas.admin.dao.ISpecialtyDao;
import com.ljc.eas.admin.pojo.Specialty;
import com.ljc.eas.base.BaseDao;

@Repository
public class SpecialtyDao extends BaseDao implements ISpecialtyDao {

	@Override
	public List<Specialty> queryAll() {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		String hql="from Specialty";
		Query query=session.createQuery(hql);
        List<Specialty> listSpecialty=query.list();
        session.close();
		return listSpecialty;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		String hql="delete from Specialty specialty where specialty.id=?";
		Query query=session.createQuery(hql);
		query.setLong(0,id);
        query.executeUpdate();
        session.close();
		return 1;
	}

	@Override
	public int add(Specialty record) {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		session.save(record);
        session.close();
		return 1;
	}

	@Override
	public int update(Specialty record) {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		session.update(record);
		session.flush();
        session.close();
		return 0;
	}

	@Override
	public Specialty queryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specialty queryById(long id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Specialty> queryByPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		String hql="from Specialty as Specialty order by Specialty.id desc";
		Query query=session.createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageNumber*pageSize);
		List<Specialty> listSpecialty=query.list();
		session.close();
		return listSpecialty;
	}

	@Override
	public long queryCount() {
		// TODO Auto-generated method stub
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		String hql="select count(specialty) from Specialty specialty";
		Query query=session.createQuery(hql);
		long count=(Long) query.uniqueResult();
		session.close();
		return count;
	}

}
