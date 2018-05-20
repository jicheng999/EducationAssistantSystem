package com.ljc.eas.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljc.eas.admin.dao.ISpecialtyDao;
import com.ljc.eas.admin.pojo.Specialty;
import com.ljc.eas.admin.service.ISpecialtyService;

@Service
public class SpecialtyService implements ISpecialtyService {
	
	@Autowired
	ISpecialtyDao specialtyDao;
	
	public ISpecialtyDao getSpecialtyDao() {
		return specialtyDao;
	}

	public void setSpecialtyDao(ISpecialtyDao specialtyDao) {
		this.specialtyDao = specialtyDao;
	}

	@Override
	public List<Specialty> queryAllSpecialty() {
		// TODO Auto-generated method stub
		return specialtyDao.queryAll();
	}

	@Override
	public List<Specialty> qeurySpecialtyByPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return specialtyDao.queryByPage(pageNumber, pageSize);
	}

	@Override
	public int deleteSpecialty(long id) {
		// TODO Auto-generated method stub
		return specialtyDao.delete(id);
	}

	@Override
	public int addSpecialty(Specialty specialty) {
		// TODO Auto-generated method stub
		return specialtyDao.add(specialty);
	}

	@Override
	public int updateSpecialty(Specialty specialty) {
		// TODO Auto-generated method stub
		return specialtyDao.update(specialty);
	}

	@Override
	public Long queryCount() {
		// TODO Auto-generated method stub
		return specialtyDao.queryCount();
	}

}
