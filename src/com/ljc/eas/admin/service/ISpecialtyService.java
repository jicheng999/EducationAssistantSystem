package com.ljc.eas.admin.service;

import java.util.List;

import com.ljc.eas.admin.pojo.Specialty;

public interface ISpecialtyService {
	
	public List<Specialty> queryAllSpecialty();
	public List<Specialty> qeurySpecialtyByPage(int pageNumber,int pageSize);
	public int deleteSpecialty(long id);
	public int addSpecialty(Specialty specialty);
	public int updateSpecialty(Specialty specialty);
	public Long queryCount();

}
