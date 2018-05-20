package com.ljc.eas.admin.dao;

import java.util.List;
import com.ljc.eas.admin.pojo.College;

public interface ICollegeDao {
	public List<College> queryAll();
	public int delete(long id);
    public int add(College record);
    public int update(College record);
    public College queryByName(String name);
    public College queryById(long id);
    public List<College> queryByPage(int pageNumber,int pageSize);
    public long queryCount();
}
