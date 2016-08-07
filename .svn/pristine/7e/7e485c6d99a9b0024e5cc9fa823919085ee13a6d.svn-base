<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<c:if test="${fn:contains(sessionInfo.resourceList, '/homeworktype/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.resourceList, '/homeworktype/delete')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<title>机构管理</title>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${ctx}/homeworktype/treeGrid',
			idField: 'id',//子菜单字段名
			treeField: 'name',//显示的字段名
			rownumbers: true,
			fit : true,
			fitColumns : false,
			border : false,
			frozenColumns : [ [ {
				title : 'id',
				field : 'fuID',
				width : 40,
				hidden : true
			} ] ],
			columns : [ [
			{
				field : 'fuID',
				title : '分类ID',
				width : 100
			},{
				field : 'fname',
				title : '分类名称',
				width : 100
			},{
				field : 'fcreateBy',
				title : '创建人',
				width : 100
			},
			{
				field : 'fcreateTime',
				title : '创建时间',
				width : 100
			},
			{
				field : 'fupdateBy',
				title : '修改人',
				width : 100
			},
			{
				field : 'fupdateTime',
				title : '修改时间',
				width : 100
			},
			{
				field : 'fstatusCode',
				title : 'fstatusCode',
				width : 100
			},
			{
				field : 'fstatusDesc',
				title : 'fstatusDesc',
				width : 100
			},
			{
				field : 'fdesc',
				title : 'fdesc',
				width : 100
			}, {
				field : 'action',
				title : '操作',
				width : 80,
				formatter : function(value, row, index) {
					var str = '&nbsp;';					
					if ($.canEdit) {								
					str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" >编辑</a>', row.fuID);
					}
					if ($.canDelete) {
					str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
					str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" >删除</a>', row.fuID);
					}
					return str;
				}
			} ] ],
			toolbar : '#toolbar'
		});
	});	
	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].fuID;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}		
		location.href='${ctx}/homeworktype/editPage?uuid=' + id;
	}
	
	function deleteFun(id) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].fuID;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('询问', '您是否要删除当前作业分类？', function(b) {
			if (b) {
				progressLoad();
				$.post('${ctx}/homeworktype/delete', {
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
	
	function addFun() {
		location.href = "${ctx}/homeworktype/addPage";
	}
	</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'center',border:false"  style="overflow: hidden;">
			<table id="dataGrid"></table>
		</div>
		
		<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.resourceList, '/homeworktype/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
		</c:if>
	</div>
	</div>
</body>
</html>