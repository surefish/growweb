<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
		$(function() {
		$('#upimage').click(function () {
		    var imgdialog = _editor.getDialog("insertimage");
		    imgdialog.render();
		    imgdialog.open();
		    _editor.addListener("beforeInsertImage", function (t, arg) {
		        $("#fimagesurl").attr("value", arg[0].src);
		    });
		});		
	
		$('#bookstoreAddForm').form({
			url : '${ctx}/bookstore/add',
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
					parent.$.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为organization.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});
		
	});
</script>
<div style="padding: 3px;">
	<form id="bookstoreAddForm" method="post">
		<table class="grid">
			<tr>
				<td>分类名称</td>
				<td><input name="fname" type="text" placeholder="请输入书店" class="easyui-validatebox" data-options="required:true" ></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input name="fremark" type="text" placeholder="请输入备注" class="easyui-validatebox" data-options="required:true" ></td>
			</tr>

						<tr>
					<td>书店照片</td>
					<td><input type="text" id="furl" name="furl"
						value="" style="width:450px;height: 25px;" /> <a id="upimage"
						href="javascript:void(0);" class="easyui-linkbutton">上传图片</a></td>
				</tr>
			
		</table>
	</form>
</div>