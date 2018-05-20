<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta HTTP-EQUIV="pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
<meta HTTP-EQUIV="expires" CONTENT="0">

<link rel="stylesheet" type="text/css"
	href="/EducationAssistantSystem/linkRsc/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="/EducationAssistantSystem/linkRsc/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="/EducationAssistantSystem/linkRsc/css/personalInfo.css" />
	<link rel="stylesheet" type="text/css"
	href="/EducationAssistantSystem/linkRsc/uploadify/uploadify.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="centerDiv">
		<div id="inforPanel">
		<div id="toolbar">
       <!--  <a id='editBtn'>编辑</a>
        <a id='saveBtn'>保存</a> -->
    </div>
		<div>
			<div id="info-left" class="info-dev">
				<div id="imgDiv">
					<img id="photo" src=${data.admin.photo_path} />
				</div>
				<div id="imgButton">
				    <div id="uploadFile"></div>
				</div>

			</div>
			<div id="info-right" class="info-dev">
			     <table id="infoTable">
			          <tr>
			               <td>姓名</td>
			               <td id='name_text'>${data.admin.name}</td>
			          </tr> 
			           <tr>
			               <td>性别</td>
			               <td id='sex_combobox'>${data.admin.sex}</td>
			          </tr> 
			           <tr>
			               <td>出生日期</td>
			               <td id='birthday_calendar'>${data.admin.birthday}</td>
			          </tr> 
			           <tr>
			               <td>管理员类型</td>
			               <td id='typeid_commbox'>${data.admin.typeid}</td>
			          </tr> 
			           <tr>
			               <td>电话</td>
			               <td id='phone_text'>${data.admin.phone}</td>
			          </tr> 
			           <tr>
			               <td>邮箱</td>
			               <td id='email_text'>${data.admin.email}</td>
			          </tr> 
			           <tr>
			               <td>QQ</td>
			               <td id='qq_text'>${data.admin.qq}</td>
			          </tr> 
			     </table>
			    <!--  <table id="infoTable">
			          <tr>
			               <td>姓名</td>
			               <td></td>
			          </tr> 
			           <tr>
			               <td>性别</td>
			               <td></td>
			          </tr> 
			           <tr>
			               <td>出生日期</td>
			               <td></td>
			          </tr> 
			           <tr>
			               <td>管理员类型</td>
			               <td></td>
			          </tr> 
			           <tr>
			               <td>电话</td>
			               <td></td>
			          </tr> 
			           <tr>
			               <td>邮箱</td>
			               <td></td>
			          </tr> 
			           <tr>
			               <td>QQ</td>
			               <td></td>
			          </tr> 
			     </table> -->
			</div>
			</div>
		</div>
	</div>
	<input type="hidden" id="hiddenData" value=${data.sessionId}/>
</body>
<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/js/admin/personalInfo.js"></script>
<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/js/swfobject.js"></script>
	<script type="text/javascript"
	src="/EducationAssistantSystem/linkRsc/uploadify/jquery.uploadify.js"></script>
</html>