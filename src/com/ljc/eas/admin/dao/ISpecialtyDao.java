package com.ljc.eas.admin.dao;

import java.util.List;
import com.ljc.eas.admin.pojo.Specialty;

public interface ISpecialtyDao {
	public List<Specialty> queryAll();
	public int delete(long id);
    public int add(Specialty record);
    public int update(Specialty record);
    public Specialty queryByName(String name);
    public Specialty queryById(long id);
    public List<Specialty> queryByPage(int pageNumber,int pageSize);
    public long queryCount();
}
