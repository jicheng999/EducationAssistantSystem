function datagridEditor(dg) {
	var obj = new Object();
	obj.dg = dg;
	obj.isEdit = false;
	obj.currentRow = -1;
	obj.isAdd = false;
	obj.pageNumber;
	obj.pageSize;
	obj.addUrl;
	obj.updateUrl;
	obj.removeUrl;
	obj.queryUrl
	
	obj.ini=function(){
		var pager=$(obj.dg).datagrid('getPager');
		$(pager).pagination({
		pageSize : obj.pageSize,
		pageList : [ 15, 20, 30 ],
		onSelectPage:function(pageNumber, pageSize){
			obj.pageNumber=pageNumber;
			obj.pageSize=pageSize;
			var data=obj.getQueryParam();
			$(dg).datagrid('reload',data);
	/*		$.ajax({
				url : obj.queryUrl,
				dataType : "json",
				async : true,
				data : data,
				type : "post",
				success : function(data) {
					data = JSON.parse(data);
					return data;
				}
			});*/
		}
	});
		
		obj.noSelectedStatus();
	}

	obj.add = function() {
		$(dg).datagrid('insertRow', {
			index : 0,
			row : {},
		});
		currentRow = 0;
		$(dg).datagrid('beginEdit', 0);
		obj.isAdd = true;
		obj.edit();
	};

	obj.edit = function() {
		/* console.log($(dg).datagrid('getSelected',currentRow).name); */
		if (!obj.isEdit) {
			$(dg).datagrid('beginEdit', currentRow);
			obj.editStatus();
			/* $(dg).datagrid('unselectRow', currentRow); */
			obj.isEdit = true;
		}
	};

	obj.remove = function() {
		var row = obj.getSelectedRow();
		$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
			if (r) {
				var data = {
					param : JSON.stringify(row)
				};
				$.ajax({
					url : obj.removeUrl,
					dataType : "json",
					async : true,
					data : data,
					type : "post",
					success : function(data) {
					}
				});
				$(dg).datagrid('deleteRow', currentRow);
				obj.noSelectedStatus();
			}
		});
	};

	obj.save = function() {
		$(dg).datagrid('endEdit', currentRow);
		obj.noSelectedStatus();
		obj.isEdit = false;
	};

	obj.redo = function() {
		$(dg).datagrid('cancelEdit', currentRow);
		obj.selectedStatus();
		obj.isEdit = false;
		if (obj.isAdd) {
			obj.remove();
		}
	};

	obj.afterEdit = function(rowIndex, rowData, changes) {
		console.log(rowIndex);
		console.log(rowData);
		console.log(changes);
		if (obj.isAdd) {
			/*var param = {
				id : rowData.id,
				name : rowData.name
			};*/
			var param = JSON.stringify(rowData);
			var data = {
				param : param
			};
			$.ajax({
				url : obj.addUrl,
				dataType : "json",
				async : true,
				data : data,
				type : "post",
				success : function(data) {
					var data = eval("(" + data + ")");
					// $('#dg').datagrid('reload');
				}
			});
			obj.isAdd = false;
		} else {
			if (obj.countObjectPrama(changes) != 0) {
				/*var param = {
					id : rowData.id,
					name : rowData.name
				};*/
				var param = JSON.stringify(rowData);
				var data = {
					param : param
				};
				$.ajax({
					url : obj.updateUrl,
					dataType : "json",
					async : true,
					data : data,
					type : "post",
					success : function(data) {
						var data = eval("(" + data + ")");
						// $('#dg').datagrid('reload');
					}
				});
			} else {
				//console.log('未更改');
			}
		}
	};

	obj.clickCell = function(index, field, value) {
		obj.selectedStatus();
		if (obj.isEdit) {
			obj.save();
			$(dg).datagrid
		}
		currentRow = index;
	};

	obj.dblClickCell = function(index, field, value) {
		obj.currentRow = index;
		obj.edit();
	};

	obj.getSelectedRow = function() {
		return $(dg).datagrid('getSelected');
	};

	obj.getSelectedRowIndex = function() {
		return $(dg).datagrid('getRowIndex', obj.getSelectedRow());
	};

	/*
	 * obj.rowToJson=function(row){ return JSON.stringify(row); };
	 */

	obj.noSelectedStatus = function() {
		$('#toolBar-save,#toolBar-redo').hide();
		$('#toolBar-edit,#toolBar-remove').linkbutton('disable');
		$('#toolBar-add').linkbutton('disable').linkbutton('enable');
	};

	obj.selectedStatus = function() {
		$('#toolBar-save,#toolBar-redo').hide();
		$('#toolBar-edit,#toolBar-remove,#toolBar-add').linkbutton('enable');
	};

	obj.editStatus = function() {
		$('#toolBar-edit,#toolBar-remove,#toolBar-add').linkbutton('disable');
		$('#toolBar-save,#toolBar-redo').show();
	};

	obj.getToolBar = function() {

		return toolBar;
	};

	obj.countObjectPrama = function(object) {
		var n = 0;
		for ( var ele in object) {
			n++;
		}
		return n;
	};
	
	obj.getQueryParam=function(){
		var param={
				pageNumber:obj.pageNumber,
				pageSize:obj.pageSize
		};
		var data={param:JSON.stringify(param)};
		return data;
	}
	
	var toolBar = [ {}, {
		id : 'toolBar-add',
		iconCls : 'icon-add',
		text : '添加',
		handler : obj.add
	}, {
		id : 'toolBar-edit',
		iconCls : 'icon-edit',
		text : '修改',
		handler : obj.edit
	}, {
		id : 'toolBar-remove',
		iconCls : 'icon-remove',
		text : '删除',
		handler : obj.remove
	}, {
		id : 'toolBar-save',
		iconCls : 'icon-save',
		text : '保存',
		handler : obj.save
	}, {
		id : 'toolBar-redo',
		iconCls : 'icon-redo',
		text : '取消编辑',
		handler : obj.redo
	} ];
	return obj;
};