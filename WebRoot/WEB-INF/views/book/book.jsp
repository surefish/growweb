<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<c:if test="${fn:contains(sessionInfo.resourceList, '/book/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/book/delete')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/book/view')}">
	<script type="text/javascript">
		$.canView = true;
	</script>
</c:if>
<title>DEMO管理</title>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${ctx}' + '/book/dataGrid',
			striped : true,
			
			rownumbers : true,
			pagination : true,
			singleSelect : true,
			idField : 'id',
			treeField: 'name',
			sortName : 'id',
			sortOrder : 'asc',
			pageSize : 50,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			fitColumns:true,
			
			
			fit:true,	
			
			frozenColumns : [ [  {
				width : '200',
				title : '书名',
				field : 'fname',
				sortable : true
			} ,{
				width : '200',
				title : '内容简介',
				field : 'fintroduced',
				sortable : true
			} ,{
				width : '80',
				title : '价格',
				field : 'fprice',
				sortable : true
			} , {
				width : '100',
				title : '封面地址',
				field : 'furl',
				sortable : true
			} , {
				width : '80',
				title : '创建人',
				field : 'fcreateBy',
				sortable : true
			} ,{
				width : '150',
				title : '创建时间',
				field : 'fcreateTime',
				sortable : true
			} ,  {
				width : '80',
				title : '修改人',
				field : 'fupdateBy',
				sortable : true
			} ,{
				width : '150',
				title : '修改时间',
				field : 'fupdateTime',
				sortable : true
			} ,  {
				field : 'action',
				title : '操作',
				width : 120,
				formatter : function(value, row, index) {
					var str = '&nbsp;';
						if ($.canView) {
							str += $.formatString('<a href="javascript:void(0)" onclick="viewFun(\'{0}\');" >查看</a>', row.fuID);
						}
					if(row.isdefault!=0){
						str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
						if ($.canEdit) {
							str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" >编辑</a>', row.fuID);
						}
						str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
						if ($.canDelete) {
							str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" >删除</a>', row.fuID);
						}
					}
					return str;
				}
			} ] ],
			toolbar : '#toolbar'
		});
		 $('#dataGrid').datagrid('enableFilter');
	});
	
	function addFun() {
		location.href = "${ctx}/book/addPage";
	}
	
	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].fuID;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前新闻？', function(b) {
			if (b) {
				progressLoad();
				$.post('${ctx}/book/delete', {
					uuid : id
				}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						dataGrid.datagrid('reload');
					}
					progressClose();
				}, 'JSON');
			}
		});
	}
	
	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].fuID;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		location.href='${ctx}/book/editPage?uuid=' + id
	}
	
	function viewFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].fuID;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			title : '詳情',
			width : 800,
			height : 600,
			href : '${ctx}/book/viewPage?uuid=' + id
		});
	}
	
	</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<table id="dataGrid" data-options="fit:true,border:false"></table>
	</div>
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/book/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
		</c:if>
	</div>
</body>
</html>