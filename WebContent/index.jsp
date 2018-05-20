<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用教学辅助系统!</title>
<link href="linkRsc/css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="linkRsc/js/jquery-1.6.4.js"></script>
<script type="text/javascript">

  $(function(){
	  var buttonbox=$("#buttonLogin #button");
	  buttonbox.hover(function(){
		  buttonbox.css("background-image","url(linkRsc/images/login-button-hover.png)");
	},function(){
		buttonbox.css("background-image","url(linkRsc/images/login-button-normal.png)");
	  }); 
	      buttonbox.mousedown(function(){
	    	  buttonbox.css("background-image","url(linkRsc/images/login-button-pressed.png)");
	      });
	      buttonbox.mouseup(function(){
		      buttonbox.css("background-image","url(linkRsc/images/login-button-hover.png)");
		      window.location.href="loginAction";
	  });
  })
 </script>
</head>
<body>
<div id="imgbox">
<div id="buttonLogin">
<div id="button">hello</div>
</div>
</div>
</body>
</html>