<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>选择课程</title>
<script type="text/javascript">


	function submit() {
		var myform = $("#courseapplyAddForm");
		myform.attr("action", "${ctx}/courseapply/add");
		myform.submit();
	}

	function back() {
		window.location.href = "javascript:history.go(-1);";
	}
	$(function() {
		$('#fcourse').combotree({
			
			editable:true,
			url : '${ctx}/course/tree',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto',
			value : ''
		});
	});
</script>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow: scroll;padding: 3px;">
		<form id="courseapplyAddForm" method="post">
			<table class="grid">
				<tr>
					<td>学生名</td>
					<td> <input
						name="fstudent" type="text" value="" placeholder="请输入学生"
						class="easyui-validatebox" data-options="required:true"
						style="width:400px;height: 25px;"></td>
				</tr>
				
				<tr>
					<td>课程</td>
					<td><select id="fcourse" name="fcourse"
						style="width:200px;height: 29px;"></select> <a
						class="easyui-linkbutton" href="javascript:void(0)"
						onclick="$('#fcourse').combotree('clear');">清空</a></td>
				</tr>
				
				<tr>
					<td>备注</td>
					<td><textarea name="fnote" rows="3" cols="80"
							class="easyui-validatebox" placeholder="请输入备注"
							data-options="required:true"></textarea></td>
				</tr>
					<tr>
					<td></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-ok" onclick="submit()" style="width:90px">保存</a> <a
						href="javascript:void(0)" class="easyui-linkbutton"
						iconCls="icon-cancel" onclick="back()" style="width:90px">返回</a></td>
				</tr>
				
			</table>
		</form>
	</div>
</body>