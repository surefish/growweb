<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib
	prefix="fn"
	uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx"
	value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include
	page="../inc.jsp"></jsp:include>
<meta
	http-equiv="X-UA-Compatible"
	content="edge" />
<c:if
	test="${fn:contains(sessionInfo.resourceList, '/messagesclass/edit')}">
	<script
		type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if
	test="${fn:contains(sessionInfo.resourceList, '/messagesclass/delete')}">
	<script
		type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<title>机构管理</title>
<script
	type="text/javascript">
	var treeGrid;
	$(function() {
		treeGrid = $(
				'#treeGrid')
				.treegrid(
						{
							url : '${ctx}/messagesclass/treeGrid',
							idField : 'id',//子菜单字段名
							treeField : 'name',//显示的字段名
							parentField : 'pid',//父菜单字段名
							rownumbers : true,
							fit : true,
							fitColumns : false,
							border : false,
							frozenColumns : [ [ {
								title : 'id',
								field : 'id',
								width : 40,
								hidden : true
							} ] ],
							columns : [ [
									{
										field : 'name',
										title : '分类名称',
										width : 250
									},
									{
										field : 'memo',
										title : '备注',
										width : 200
									},
									
									{
										field : 'icon',
										title : '图标',
										width : 150
									},
									
									
									{
										field : 'action',
										title : '操作',
										width : 80,
										formatter : function(
												value,
												row,
												index) {
											var str = '&nbsp;';
											if ($.canEdit) {
												str += $
														.formatString(
	'<a href="javascript:void(0)" onclick="editFun(\'{0}\');" >编辑</a>',
																row.id);
											}
											if ($.canDelete) {
									str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
									str += $
			.formatString(
	'<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" >删除</a>',
	row.id);
}
											return str;
										}
									} ] ],
							toolbar : '#toolbar'
						});
	});

	function editFun(id) {
		if (id != undefined) {
			treeGrid
					.treegrid(
							'select',
							id);
		}
	
		var node = treeGrid
				.treegrid('getSelected');
		alert(node.id);
		if (node) {
			parent.$
					.modalDialog({
						title : '编辑',
						width : 500,
						height : 300,
						href : '${ctx}/messagesclass/editPage?uuid='
								+ node.id,
						buttons : [ {
							text : '保存',
							handler : function() {
						parent.$.modalDialog.openner_treeGrid = treeGrid;
						//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
							var f = parent.$.modalDialog.handler
										.find('#messagesclassEditForm');
								f
										.submit();
							}
						} ]
					});
		}
	}

	function deleteFun(id) {
		if (id != undefined) {
			treeGrid
					.treegrid(
							'select',
							id);
		}
		var node = treeGrid
				.treegrid('getSelected');
		if (node) {
			parent.$.messager
					.confirm(
							'询问',
							'您是否要删除当前分类？删除当前资源会连同子分类一起删除!',
							function(
									b) {
								if (b) {
									progressLoad();
									$
											.post(
													'${ctx}/messagesclass/delete',
													{
														uuid : node.id
													},
													function(
															result) {
														if (result.success) {
															parent.$.messager
																	.alert(
																			'提示',
																			result.msg,
																			'info');
															treeGrid
																	.treegrid('reload');
														} else {
															parent.$.messager
																	.alert(
																			'提示',
																			result.msg,
																			'info');
														}
														progressClose();
													},
													'JSON');
								}
							});
		}
	}

	function addFun() {
		parent.$
				.modalDialog({
					title : '添加',
					width : 500,
					height : 300,
					href : '${ctx}/messagesclass/addPage',
					buttons : [ {
						text : '添加',
						handler : function() {
							parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
							var f = parent.$.modalDialog.handler
									.find('#messagesclassAddForm');
							f
									.submit();
						}
					} ]
				});
	}
</script>
</head>
<body>
	<div
		class="easyui-layout"
		data-options="fit:true,border:false">
		<div
			data-options="region:'center',border:false"
			style="overflow: hidden;">
			<table
				id="treeGrid"></table>
		</div>

		<div id="toolbar"
			style="display: none;">
			<c:if
				test="${fn:contains(sessionInfo.resourceList, '/messagesclass/add')}">
				<a
					onclick="addFun();"
					href="javascript:void(0);"
					class="easyui-linkbutton"
					data-options="plain:true,iconCls:'icon-add'">添加</a>
			</c:if>
		</div>
	</div>
</body>
</html>