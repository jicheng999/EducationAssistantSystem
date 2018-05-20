<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>jQuery Easy UI</title>
<meta charset="UTF-8" />
<meta HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"> 
<meta HTTP-EQUIV="expires" CONTENT="0"> 

<link rel="stylesheet" type="text/css"
	href="/EducationAssistantSystem/linkRsc/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="/EducationAssistantSystem/linkRsc/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="/EducationAssistantSystem/linkRsc/css/adminPanel.css" />
</head>
<body class="easyui-layout">
	<div
		data-options="region:'north',title:'North Title',split:false,noheader:true"
		style="height: 100px;"></div>
	<div data-options="region:'west',title:'导航',iconCls:'icon-world',split:true,style:{borderWidth:5}"
		style="width: 200px;">
		<ul id="nav"></ul>
		</div>

	<div data-options="region:'center',title:'center title',noheader:true"
		style="padding: 5px; background: #eee;">
		
		<div id="tabs">
			<div title="起始页" iconCls="icon-house"  style="padding: 0 10px; display: block;">
			     <p>欢迎使用教辅系统</p>
			</div>
		</div>
		
	</div>

	<div
		data-options="region:'south',title:'South Title',split:false,noheader:true,height:30"
		style="height: 30px; line-height: 30px; text-align: center; background-color: #0071e1;">
		<div id="footer"><jsp:include
				page="/WEB-INF/views/jsp/common/footer.jsp" /></div>
	</div>
</body>
<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/js/admin/adminPanel.js"></script>
<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/easyui/locale/easyui-lang-zh_CN.js"></script>
</html>
