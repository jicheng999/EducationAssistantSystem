<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>panel</title>
<link href="/EducationAssistantSystem/linkRsc/css/common.css" 
rel="stylesheet" type="text/css" />
<link href="/EducationAssistantSystem/linkRsc/css/panel.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
<div id="DIV-bigest"> 
<jsp:include page="/WEB-INF/views/jsp/common/header.jsp"/>
<div id="menu">
<ul>
<li><div class="menuButton"><a href="#">教学管理</a></div>
<div class="list">
<ul>
<li><a href="#">学生信息</a></li>
<li><a href="#">课堂信息</a></li>
<li><a href="#">作业管理</a></li>
</ul>
</div>
</li>
<li><div class="menuButton"><a href="#">交流区</a></div>
<div class="list">
<ul>
<li><a href="#">example</a></li>
<li><a href="#">example</a></li>
</ul>
</div>
</li>
<li>
<div class="menuButton"><a href="#">设置</a></div>
<div class="list">
<ul>
<li><a href="#">个人资料</a></li>
<li><a href="#">修改资料</a></li>
<li><a href="#">修改密码</a></li>
<li><a href="#">注销登录</a></li>
</ul>
</div>
</li>
</ul>
  </div>
<div id="workspace"></div>
<jsp:include page="/WEB-INF/views/jsp/common/footer.jsp"/>
</div>
</body>
</html>