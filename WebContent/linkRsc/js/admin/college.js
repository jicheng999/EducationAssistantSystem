$(function() {
	/*var param = '';
	param = JSON.stringify(param);
	var data = {
		param : param
	}
	$.ajax({
		url : '/EducationAssistantSystem/admin/showCollegeAction',
		dataType : 'json',
		async : true,
		data : data,
		type : 'post',
		success : function(data) {
			
			 * var data = eval("(" + data + ")"); for ( var index in data) {
			 * alert(data[index].name); }
			 

		}
	});*/

	var editor = new datagridEditor('#dg');
	editor.removeUrl = "/EducationAssistantSystem/admin/removeCollege";
	editor.addUrl = "/EducationAssistantSystem/admin/addCollege";
	editor.updateUrl = "/EducationAssistantSystem/admin/updateCollege";
	editor.queryUrl="/EducationAssistantSystem/admin/showCollegeAction";
	var page_num=1;
	editor.pageNumber=page_num;
	var page_size=15;
	editor.pageSize=page_size;
	$('#dg').datagrid({
		title : '学院列表',
		iconCls : 'icon-large-chart',
		rownumbers : true,
		singleSelect : true,
		fit: true,
		pagination : true,
		// url:'/EducationAssistantSystem/linkRsc/easyui/json/test.json',
		url : '/EducationAssistantSystem/admin/showCollegeAction',
		toolbar : editor.getToolBar(),
		queryParams:editor.getQueryParam(),
		onClickCell : function(index, field, value) {
			editor.clickCell(index, field, value);
		},
		onDblClickCell : function(index, field, value) {
			editor.dblClickCell(index, field, value);
		},
		onBeforeEdit : function() {

		},
		onAfterEdit : function(rowIndex, rowData, changes) {
			editor.afterEdit(rowIndex, rowData, changes);
		},
		// striped:true,
		columns : [ [ {
			field : 'name',
			title : '学院名称',
			width : 300,
			editor : {
				type : 'validatebox',
				options : {
					required : true
				}
			}
		} ] ],
		loadFilter : function(data) {
			data = JSON.parse(data);
			return data;
			console.log('学习git操作修改处')
		}
	});
	editor.ini();


});