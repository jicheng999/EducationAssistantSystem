<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix = "s" uri = "/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Cache" content="no-cache">
<title>登陆</title>
<link href="linkRsc/css/login.css" rel="stylesheet" type="text/css" />
<link href="linkRsc/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="linkRsc/js/jquery-1.6.4.js"></script>
<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
	        var error=$("#errorMessage");
	        error.html("");
		     if($("#username").val().length<8){
		    	 error.html("用户名不能少于8个字符*");
		     }else if($("#password").val().length<8){
		    	 error.html("密码不能少于8个字符*");
		     }else if($("#verifytext").val().length<4){
		    	 error.html("验证码不能少于4个字符*");
		     }else {
		    	 var role=$("input:radio[name='role']:checked").val();
		    	 var data ={
		    			 username:$("#username").val(),
		    			 role:role,
		                password:$("#password").val(),
			            verifyCode: $("#verifytext").val()}; 
		    			 $.ajax({
		    				     url:"login",
		    					 dataType: "json", 
		    					 async: true,
		    					 data:data,
		    					 type:"post",
		    					 success: function(data) {
		    						 var data=eval("("+data+")");
		    						 if (data.loginResult) {
		    							 location.href =data.url;
									}else{
										error.html(data.message); 
			    						 $("#verifytext").attr("value","");
			    						 $("#Verify").attr("src","securityCodeImageAction?timestamp="+new Date().getTime());
									}
		    						   /* var mes=eval("("+result+")");
		    					        error.html(mes.username); */
		    			 } })
		    	//return true;
		     }
		     //return false;
	});
	
	$("#Verify").click(function(){
		$(this).attr("src","securityCodeImageAction?timestamp="+new Date().getTime());
	});
});
 </script>
</head>
<body>
<div id="DIV-bigest">
<div class="login">
	<form onsubmit="return false" id="form">
		<div class="logo"></div>
		
		<div id="errorMessage_div"><label id="errorMessage"></label></div>
		
		<div class="login_form">
		<div class="role">
		  <ul>
		    <li> <label>学&nbsp;&nbsp;&nbsp;生&nbsp;<input name="role" value="student" checked="checked" type="radio"></label></li>
		    <li><label>教&nbsp;&nbsp;&nbsp;师&nbsp;<input name="role" value="teacher" type="radio"></label></li>
		    <li><label>管理员&nbsp;<input name="role" value="admin" type="radio"></label></li>
		  </ul>
		</div>
			<div class="user">
				<input class="text_value" value="" maxlength="30" name="username" type="text" id="username">
				<input class="text_value" value="" maxlength="30" name="password" type="password" id="password">
			</div>
			<button class="button" id="submit" type="submit">登录</button>
		</div>
	     
		<div id="tip">
		    <div id="tip_div">
		    <table id="tip_table">
		        <tr><td><input id="verifytext" value="" name="verifyCode" maxlength="4" type="text"></td>
		               <td><img src="securityCodeImageAction" id="Verify" style="cursor:pointer;"  alt="看不清，换一张"/></td></tr>
		    </table></div>
		</div>
		
		<jsp:include page="/WEB-INF/views/jsp/common/footer.jsp"/>
	</form>
</div>
</div>
</body>
</html>