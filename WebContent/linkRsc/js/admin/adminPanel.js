$(function() {
	$("#tabs").tabs({
		fit : true,
		border : false,
	});

	$("#nav")
			.tree(
					{
						url : "/EducationAssistantSystem/linkRsc/easyui/json/adminMenu.json",
						onDblClick : function(node) {
							$(this).tree(
									node.state == 'closed' ? 'expand'
											: 'collapse', node.target);
						},
						onClick : function(node) {
							if ($("#nav").tree("isLeaf", node.target)) {
								if ($("#tabs").tabs("exists", node.text)) {
									$("#tabs").tabs("select", node.text)
								}else{
									$("#tabs").tabs("add", {
										title : node.text,
										selected : true,
										content:'<iframe id="tabFrame" name="tabFrame" frameBorder=0 scrolling="auto" height="99%" width="100%" src="'+
										node.attributes.href+'" onload="callMySon()"></iframe>',
										iconCls : "icon-house",
										closable : "true",
									});
								}
							}
						}
					});
});

function callFather(){
	return $("#tabFrame").width();
}

function callMySon(){
	//tabFrame.window.callSon();
}