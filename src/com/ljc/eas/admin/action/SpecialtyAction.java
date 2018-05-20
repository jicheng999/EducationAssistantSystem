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
import com.ljc.eas.admin.pojo.Specialty;
import com.ljc.eas.admin.service.ISpecialtyService;
import com.ljc.eas.base.BaseAction;


@ParentPackage("easDefaultPackge")
@InterceptorRefs(value={@InterceptorRef(value="loginValidate",params={"role",
"admin"}), @InterceptorRef("defaultStack")})
@Namespace("/admin")
public class SpecialtyAction extends BaseAction {
	@Autowired
	ISpecialtyService specialtyService;
	
	private String param;
	private String result;
	public ISpecialtyService getSpecialtyService() {
		return specialtyService;
	}
	public void setSpecialtyService(ISpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
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
	
	@Action(value="specialtyAction",results={@Result(name=SUCCESS,type="dispatcher",location="/WEB-INF/views/jsp/admin/specialtyManager.jsp")})
	public String specailtyAction(){
		
		return SUCCESS;
	}
	
	@Action(value="showSpecialtyAction",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String showSpecialtyAction(){
		Map<String,Integer> map=(Map<String, Integer>) JSON.parse(param);
		List<Specialty> specialtyList=specialtyService.qeurySpecialtyByPage(map.get("pageNumber"), map.get("pageSize"));
		Long count=specialtyService.queryCount();
		Map<String,Object> mapResult=new HashMap<String,Object>();
		mapResult.put("rows", specialtyList);
		mapResult.put("total", count);
		result=JSONObject.toJSONString(mapResult);
		return SUCCESS;
	}
	
	@Action(value="addSpecialtyAction",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String addSpecialtyAction(){
		Specialty specialty=JSON.toJavaObject(JSON.parseObject(param),Specialty.class);
		specialtyService.addSpecialty(specialty);
		return SUCCESS;
	}
	
	@Action(value="removeSpecialtyAction",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String removeSpecialtyAction(){
		Specialty specialty=JSON.toJavaObject(JSON.parseObject(param),Specialty.class);
		specialtyService.deleteSpecialty(specialty.getId());
		return SUCCESS;
	}
	
	@Action(value="updateSpecialtyAction",results={@Result(name=SUCCESS,type="json",params={"root","result"})})
	public String updateSpecialtyAction(){
		Specialty specialty=JSON.toJavaObject(JSON.parseObject(param),Specialty.class);
		specialtyService.updateSpecialty(specialty);
		return SUCCESS;
	}
	
	

}
