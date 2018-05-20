package com.ljc.eas.admin.service;

import java.util.List;

import com.ljc.eas.admin.pojo.College;

public interface ICollegeService {
	
	public List<College> queryAllColleges();
	public List<College> qeuryCollegesByPage(int pageNumber,int pageSize);
	public int deleteCollege(long id);
	public int addCollege(College collge);
	public int updateCollege(College college);
	public Long queryCount();
}
