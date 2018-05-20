$(function() {
	var editor = new datagridEditor('#dg');
	editor.removeUrl = "/EducationAssistantSystem/admin/removeClass";
	editor.addUrl = "/EducationAssistantSystem/admin/addClasse";
	editor.updateUrl = "/EducationAssistantSystem/admin/updateClass";
	editor.queryUrl = "/EducationAssistantSystem/admin/showClassAction";
	var page_num = 1;
	editor.pageNumber = page_num;
	var page_size = 15;
	editor.pageSize = page_size;
	$('#dg').datagrid({
		title : '班级列表',
		iconCls : 'icon-large-chart',
		rownumbers : true,
		singleSelect : true,
		fit : true,
		pagination : true,
		url:'/EducationAssistantSystem/linkRsc/easyui/json/test.json',
		//url : '/EducationAssistantSystem/admin/showClass',
		toolbar : editor.getToolBar(),
		queryParams : editor.getQueryParam(),
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
		columns : [ [ 
		              {
			field : 'number',
			title : '班级编号',
			width : 300,
			editor : {type : 'validatebox',options : {required : true}}
		} ,
		{
			field : 'specialty_name',
			title : '专业名称',
			width : 300,
			editor : {type : 'validatebox',options : {required : true}}
		},
		{
			field : 'college',
			title : '所属学院',
			width : 300,
			editor : {type : 'validatebox',options : {required : true}}
		},
		{
			field : 'teacher',
			title : '辅导员',
			width : 300,
			editor : {type : 'validatebox',options : {required : true}}
		}
		              ] ],
		loadFilter : function(data) {
			//data = JSON.parse(data);
			return data;
		}
	});
	editor.ini();

});