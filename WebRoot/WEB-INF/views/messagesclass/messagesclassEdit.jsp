<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx"
	value="${pageContext.request.contextPath}" />
<script
	type="text/javascript">
$(function() {

	
	$('#fparentID').combotree({
		url : '${ctx}/messagesclass/tree',
		parentField : 'pid',
		lines : true,
		panelHeight : 'auto',
		value :'${tmessagesclass.fparentID}'
	});
		$('#messagesclassEditForm').form({
			url : '${ctx}/messagesclass/edit',
			onSubmit : function() {
				progressLoad();
				var isValid = $(this).form('validate');
				if (!isValid) {
					progressClose();
				}
				return isValid;
			},
			success : function(result) {
				progressClose();
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.modalDialog.openner_treeGrid.treegrid('reload');
					//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid
					//这个对象，是因为organization.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});

	});
</script>
<div
	style="padding: 3px;">
	<form
		id="messagesclassEditForm"
		method="post">
		<table
			class="grid">
			<tr>
				<td>分类名称</td>
				<td><input
					name="fuID"
					type="hidden"
					value="${tmessagesclass.fuID}">
					<input
					name="fName"
					type="text"
					value="${tmessagesclass.fName}"
					placeholder="请输入分类名称"
					class="easyui-validatebox"
					data-options="required:true"></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input
					name="fMemo"
					type="text"
					value="${tmessagesclass.fMemo}"
					placeholder="请输入备注"
					class="easyui-validatebox"
					data-options="required:true"></td>
			</tr>
			<tr>
				<td>图标</td>
				<td><input name="ficon" type="text" value="${tnewsclass.ficon}" placeholder="请输入图标" class="easyui-validatebox" data-options="required:true" ></td>
			</tr>
			<tr>
				<td>上级分类</td>
				<td colspan="3"><select id="fparentID" name="fparentID" style="width:200px;height: 29px;"></select>
				<a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#fparentID').combotree('clear');" >清空</a></td>
				
			</tr>
		</table>
	</form>
</div>
