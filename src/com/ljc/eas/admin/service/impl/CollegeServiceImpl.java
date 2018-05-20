package com.ljc.eas.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljc.eas.admin.dao.ICollegeDao;
import com.ljc.eas.admin.pojo.College;
import com.ljc.eas.admin.service.ICollegeService;

@Service
public class CollegeServiceImpl implements ICollegeService{
	
	@Autowired
	private ICollegeDao collegeDao;

	public ICollegeDao getCollegeDao() {
		return collegeDao;
	}

	public void setCollegeDao(ICollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	@Override
	public List<College> queryAllColleges() {
		// TODO Auto-generated method stub
		return collegeDao.queryAll();
	}
	
	@Override
	public List<College> qeuryCollegesByPage(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return collegeDao.queryByPage(pageNumber, pageSize);
	}

	@Override
	public int deleteCollege(long id) {
		// TODO Auto-generated method stub
		return collegeDao.delete(id);
	}

	@Override
	public int addCollege(College college) {
		// TODO Auto-generated method stub
		collegeDao.add(college);
		return 1;
	}

	@Override
	public int updateCollege(College college) {
		// TODO Auto-generated method stub
		College queryCollege=collegeDao.queryById(college.getId());
		if (queryCollege!=null) {
			    queryCollege.setName(college.getName());
		    	collegeDao.update(queryCollege);
			    return 1;
		}else{
			return -1;
		}
	}

	@Override
	public Long queryCount() {
		// TODO Auto-generated method stub
		return collegeDao.queryCount();
	}



}
