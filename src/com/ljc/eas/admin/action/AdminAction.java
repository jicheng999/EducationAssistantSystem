package com.ljc.eas.admin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ljc.eas.admin.pojo.Admin;
import com.ljc.eas.admin.service.IAdminService;
import com.ljc.eas.base.BaseAction;
import com.ljc.eas.common.util.JsonHelper;
import com.opensymphony.xwork2.ActionContext;

 

@ParentPackage("easDefaultPackge")
@InterceptorRefs(value={@InterceptorRef(value="loginValidate",params={"role",
"admin"}), @InterceptorRef("defaultStack")})
@Namespace("/admin")
public class AdminAction extends BaseAction {

	@Autowired
	private IAdminService adminService;
	
	List<File> uploadFile;
	List<String> uploadFileFileName;
	List<String> uploadFileContentType;
	private String result;
	private String param;
	
	
	public List<File> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<File> uploadFile) {
		this.uploadFile = uploadFile;
	}
	public List<String> getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(List<String> uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public List<String> getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(List<String> uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
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
	/*@Action(value = "/login", results = {
			@Result(name = "success", type = "json", params = { "root",
					"result" }),
			@Result(name = "error", type = "json", params = { "root", "result" }) })
	public String login() throws Exception {
		// TODO Auto-generated method stub
		
		String jsonStr = JsonHelper.getJsonStr(ActionContext.getContext()
				.getParameters(), "param");
		Map<String, Object> session = ActionContext.getContext().getSession();
		String jsonStr=param;
		JSONObject jsonObject = JSON.parseObject(jsonStr);
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		String verifyCode = jsonObject.getString("verifyCode");
		String errorMSG = LoginUtil.loginCheck(username, password, verifyCode,
				session);
		if (errorMSG != null) {
			result = LoginUtil.loginFail(errorMSG);
			return ERROR;
		} else if (as.login(username, password) != null) {
			result = LoginUtil.loginSuccess("admin", username);
			return SUCCESS;
		} else {
			result = LoginUtil.loginFail("账号或密码错误*");
			return ERROR;
		}
	}*/

	@Action(value = "panelAction", results = { @Result(name = "success", type = "dispatcher", location = "/WEB-INF/views/jsp/admin/adminPanel.jsp")})
	public String showPanel() {
		return SUCCESS;
	}
	
	@Action(value="personalInfoAction",results={@Result(name="success",type="dispatcher",location = "/WEB-INF/views/jsp/admin/personalInfo.jsp")})
	public String selectPersonalInfo(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username=(String) session.get("username");
		//Admin admin=adminService.personalInfo("ljc123456");//测试使用
		Admin admin=adminService.personalInfo(username);//运行用
		/*JSONObject jsonObject=new JSONObject();
		jsonObject=(JSONObject) JSON.toJSON(admin);*/
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("admin", adminToMap(admin));
		map.put("sessionId",ServletActionContext.getRequest().getSession().getId());
		ServletActionContext.getRequest().setAttribute("data",map );
		return SUCCESS;
	}
	
	@Action(value="uploadPhotoAction",results = {
			@Result(name = "success", type = "json", params = { "root",
			"result" }),
	@Result(name = "error", type = "json", params = { "root", "result" }) })
	public String uploadPhoto() throws FileNotFoundException, Exception{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username=(String) session.get("username");
		  File dir=new File(getSavePath());  
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        
	        for(int i=0;i<uploadFile.size();i++){  
	            //FileOutputStream fos=new FileOutputStream(getSavePath()+"//"+getUploadFileFileName().get(i)); 
	        	String fileName=getUploadFileFileName().get(i);
	        	String fileType=fileName.substring(fileName.lastIndexOf("."), fileName.length());
	        	String relativePath="linkRsc/images/photos/admin/"+session.get("username")+fileType;
	        	String filePath=getSavePath()+relativePath;
	        	FileOutputStream fos=new FileOutputStream(filePath);  
	            FileInputStream fis=new FileInputStream(getUploadFile().get(i));  
	            byte []buffers=new byte[2048];  
	            int len=0;  
	            while((len=fis.read(buffers))!=-1){  
	                fos.write(buffers,0,len);  
	            }  
	            fos.close();
	            fis.close();
	            Admin admin=new Admin();
		        admin.setUsername((String)session.get("username"));
		        admin.setPhoto_path("/EducationAssistantSystem/"+relativePath);
		        adminService.updateAdminPhoto(admin);
		        result="/EducationAssistantSystem/"+relativePath;
	        }   
	       
	        return SUCCESS;  
	}
	
	@Action(value="changePasswordAction",results={
			@Result(name=SUCCESS,type="json", params = { "root", "result" }),
			@Result(name = ERROR, type = "json", params = { "root", "result" }),
			@Result(name="changePage",type="dispatcher",location = "/WEB-INF/views/jsp/admin/changePassword.jsp")
			})
	public String changePassword(){
		if (param.equals("changePage")) {
			return "changePage";
		}else{
			Map<String, Object> session = ActionContext.getContext().getSession();
			String jsonStr=param;
			JSONObject jsonObject = JSON.parseObject(jsonStr);
			String oldPassword = jsonObject.getString("oldPassword");
			String newPassword = jsonObject.getString("newPassword");
			String repeatPassword = jsonObject.getString("repeatPassword");
			if (newPassword.equals(repeatPassword)) {
				String username=(String)session.get("username");
				Admin queryAdmin=adminService.login(username, oldPassword);
				if (queryAdmin!=null) {
					Admin admin=queryAdmin;
					admin.setPassword(newPassword);
					adminService.updateAdminPassword(oldPassword, admin);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("changeResult", true);
					result =JSONObject.toJSONString(map);
					return SUCCESS;
				}else{
					Map<String, Object> map = new HashMap<String, Object>();
					String errorMessage="旧密码输入错误，请重新输入！";
					map.put("errorMessage", errorMessage);
					map.put("changeResult", false);
					result =JSONObject.toJSONString(map);
					return ERROR;
				}
				
				
			}else{
				Map<String, Object> map = new HashMap<String, Object>();
				String errorMessage="两次新密码输入不一致，请重新输入！";
				map.put("errorMessage", errorMessage);
				JSONObject json = new JSONObject();
				result =JSONObject.toJSONString(map);
				return ERROR;
			}
		}		
	}
	
	private Map<String, Object> adminToMap(Admin admin){
		Map<String,Object> map=new HashMap<String,Object>();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy年MM月dd日");
		map.put("name", admin.getName());
		map.put("username", admin.getUsername());
		map.put("email", admin.getEmail());
		map.put("phone", admin.getPhone());
		map.put("qq", admin.getQq());
		map.put("sex", admin.getSex());
		map.put("birthday",sd.format(admin.getBirthday()));
		map.put("regist_time", admin.getRegist_time());
		map.put("typeid", admin.getTypeid()==0?"高级管理员":"普通管理员");
		map.put("photo_path", admin.getPhoto_path());
		return map;
	}
	
	private String getSavePath() throws Exception 
	{
		String str=ServletActionContext.getServletContext().getRealPath("");
        return str;
    }
}