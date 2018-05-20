package com.ljc.eas.admin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ljc.eas.admin.pojo.College;
import com.ljc.eas.admin.service.ICollegeService;
import com.ljc.eas.base.BaseAction;

@ParentPackage("easDefaultPackge")
@InterceptorRefs(value={@InterceptorRef(value="loginValidate",params={"role",
"admin"}), @InterceptorRef("defaultStack")})
@Namespace("/admin")
public class CollegeAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ICollegeService collegeService;
	private String param;
	private String result;
	
	public ICollegeService getCollegeService() {
		return collegeService;
	}
	public void setCollegeService(ICollegeService collegeService) {
		this.collegeService = collegeService;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Action(value = "collegeAction", results = { @Result(name = SUCCESS, type = "dispatcher", location = "/WEB-INF/views/jsp/admin/college.jsp")})
	public String College(){
		return SUCCESS;
	}
	
	@Action(value="showCollegeAction",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String showCollege(){
		Map<String,Integer> map=(Map<String, Integer>) JSON.parse(param);
		List<College> collegeList=collegeService.qeuryCollegesByPage(map.get("pageNumber"), map.get("pageSize"));
		Long count=collegeService.queryCount();
		Map<String,Object> mapResult=new HashMap<String,Object>();
		mapResult.put("rows", collegeList);
		mapResult.put("total", count);
		result=JSONObject.toJSONString(mapResult);
		return SUCCESS;
	}
	
	@Action(value="updateCollege",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String updateCollege(){
		College college=JSON.toJavaObject(JSON.parseObject(param),College.class);
		collegeService.updateCollege(college);
		return SUCCESS;
	}
	
	@Action(value="addCollege",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String addCollege(){
		College college=JSON.toJavaObject(JSON.parseObject(param),College.class);
		collegeService.addCollege(college);
		return SUCCESS;
	}
	
	@Action(value="removeCollege",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String removeCollege(){
		College college=JSON.toJavaObject(JSON.parseObject(param),College.class);
		collegeService.deleteCollege(college.getId());
		return SUCCESS;
	}
}
