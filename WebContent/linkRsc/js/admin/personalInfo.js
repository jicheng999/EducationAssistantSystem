$(function() {
	var panelWidth = 720;
	$("#inforPanel").panel({
		width : panelWidth,
		height : 460,
		title : '个人信息'/*,
		tools : [ {
			iconCls : 'icon-edit',
			handler : function() {
				$('#name').text("123");
			}
		}, {
			iconCls : 'icon-save',
			handler : function() {
				alert('save')
			}
		} ]*/
	});
	
	$('#editBtn').linkbutton({
		iconCls : 'icon-edit',
		plain:"true"
	}).click(function() {
        editUser();
        $('#saveBtn').linkbutton({
        	disabled:false
        })
	});
	
	$('#saveBtn').linkbutton({
		iconCls : 'icon-save',
		plain:"true",
		disabled:true
	}).click(function() {
        saveUser();
        $('#saveBtn').linkbutton({
        	disabled:true
        })
	});
	
	
	
	/*$("#toolbar").toolbar({
		
	});*/

	// $("#centerDiv").draggable();

	// alert(parent.callFather());
	$("#centerDiv").css({
		"width" : panelWidth,
		"margin" : "0 auto",
	});

/*	$('#imgBtn').linkbutton({
		iconCls : 'icon-reload'
	}).click(function() {
		//var str=photoFileClick();
		//alert(str);
		//ajaxFileUpload();
	});*/
	var sessionid=$("#hiddenData").val();
	var uploaderStr='/EducationAssistantSystem/admin/uploadPhotoAction;jsessionid='+sessionid.substr(0,sessionid.length-1);
	//if($.browser.mozilla){
	//uploaderStr+=';jsession='+$("#hiddenData").val();
	//}
	
	 $("#uploadFile").uploadify({
	        height        : 30,
	        fileObjName:'uploadFile',
	        swf           : '/EducationAssistantSystem/linkRsc/uploadify/uploadify.swf',
	        uploader      : uploaderStr,
	        width         : 120,
	        buttonText:'更换照片',
	        fileSizeLimit:2048,
	        fileTypeExts:'*.jpg;*.png;*.gif',
	        multi:false,
	        onUploadSuccess:function(file, data, response){
	        	 var data=eval("("+data+")");
	        	 var url=data+"?timestamp="+new Date().getTime();
	        	$("#photo").attr("src",url);
	        }
	    });
	

});

//函数定义

function callSon() {
	alert("this is your son");
}

function photoFileClick(){
	return $("#photoFile").click();
}

function editUser(){
 	var td=$('#name');
 	var tdText=$('#name').text();
 	var nameInput='nameInput';
 	td.text("");
 	td.append('<input id="'+nameInput+'" type="text" style="width:auto"/>');
 	$('#'+nameInput).textbox({
 	    type:'text'
 	});
 	$('#'+nameInput).textbox('setText',tdText);
}

function textToEdit(tdId){
	
}

function saveUser(){
	
}
