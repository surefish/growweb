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
<title>文章修改</title>
<script type="text/javascript">
	function submit() {
		var myform = $("#homeworktypeEditForm");
		myform.attr("action", "${ctx}/homeworktype/edit");
		myform.submit();
	}

	function back() {
		window.location.href = "javascript:history.go(-1);";
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title=""
		style="overflow: scroll;padding: 3px;">
		<form id="homeworktypeEditForm" method="post">
			<table class="grid">
				<tr>
					<td>标题</td>
					<td><input id="fuID" name="fuID" type="hidden"
						value="${homeworktype.fuID}" /> <input name="fname" type="text"
						value="${homeworktype.fname}" placeholder="请输入文章标题"
						class="easyui-validatebox" data-options="required:true"
						style="width:400px;height: 25px;"></td>
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
</html>