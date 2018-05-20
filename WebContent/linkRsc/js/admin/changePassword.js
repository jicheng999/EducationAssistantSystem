$(function(){
    $('#oldPassword').textbox({
    	required:true,
        iconCls:'icon-lock',
        iconAlign:'left',
        type:'password',
        missingMessage:'请输入旧密码'
    });
    
    $('#newPassword').textbox({
    	required:true,
        iconCls:'icon-lock',
        iconAlign:'left',
        type:'password',
        missingMessage:'请输入新密码'
    });
    
    $('#repeatPassword').textbox({
    	required:true,
        iconCls:'icon-lock',
        iconAlign:'left',
        type:'password',
        missingMessage:'请重复新密码'
    });
    
    $('#linkBtn').linkbutton({
    	iconCls: 'icon-redo',
    	text:'提交'
    }).bind('click', function(){
    	var oldPassword=$('#oldPassword').val();
    	var newPassword=$('#newPassword').val();
    	var repeatPassword=$('#repeatPassword').val();
    	if (newPassword!=repeatPassword) {
    		$.messager.alert('提交失败','两次新密码输入不一致，请重新输入！');  
		} else if (newPassword==''||oldPassword==''||repeatPassword=='') {
			$.messager.alert('提交失败','未填写完整，请重新输入！');  
		} else{
			var param={
					 oldPassword:oldPassword,
	        		 newPassword:newPassword,
	        		 repeatPassword:repeatPassword
			};
			param=JSON.stringify(param);
			var data={
					param:param
	         };
			 $.ajax( {
			     url:"/EducationAssistantSystem/admin/changePasswordAction",
				 dataType: "json", 
				 async: true,
				 data:data,
				 type:"post",
				 success: function(data) {
					 var data=eval("("+data+")");
					 if (data.changeResult) {
						 $.messager.alert('成功','修改成功！');
						 $('#oldPassword').textbox('clear');
					     $('#newPassword').textbox('clear');
					      $('#repeatPassword').textbox('clear');
						
					}else{
						 $.messager.alert('错误',data.errorMessage);
					}

					}
					   /* var mes=eval("("+result+")");
				        error.html(mes.username); */
		  })
			
		}
         
    	
    });
    
	 
    
});