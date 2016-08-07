<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>学生修改</title>
<script type="text/javascript">
	function submit() {
		var myform = $("#studentEditForm");
		myform.attr("action", "${ctx}/student/edit");
		myform.submit();
	}

	function back() {
		window.location.href = "javascript:history.back();";
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: scroll;padding: 3px;">
		<form id="studentEditForm" method="post">
			<table class="grid">
				<tr>
					<td>学籍号</td>
					<td><input name="fuID" type="hidden"  value="${tstudent.fuID}">
					<input name="fno" type="text" style="width:180px;" placeholder="请输入学籍号" class="easyui-validatebox" data-options="required:true" value="${tstudent.fno}"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
					<input name="fpw" type="text" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true" value="${tstudent.fpw}"></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>
					<input name="fname" type="text" placeholder="请输入姓名" class="easyui-validatebox" data-options="required:true" value="${tstudent.fname}"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<select name="fgender">
							<option value="男" <c:if test="${tstudent.fgender=='男'}">selected="true"</c:if> >男</option>
							<option value="女" <c:if test="${tstudent.fgender=='女'}">selected="true"</c:if>>女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>出生年月</td>
					<td>
					<input name="fbirth" type="text" placeholder="请输入出生年月" onClick="WdatePicker()" class="easyui-validatebox" data-options="required:true" value="<fmt:formatDate value="${tstudent.fbirth}" pattern="yyyy-MM-dd" />"></td>
				</tr>
				<tr>
					<td>家长姓名</td>
					<td>
					<input name="fparentname" type="text" placeholder="请输入家长姓名" class="easyui-validatebox" value="${tstudent.fparentname}"></td>
				</tr>
				<tr>
					<td>家长手机</td>
					<td>
					<input name="fparentphone" type="text" placeholder="请输入家长手机" class="easyui-validatebox" value="${tstudent.fparentphone}"></td>
				</tr>
				
				<!-- 
				<tr>
					<td>所在学校班级</td>
					<td>
						<select name="fclassno">
						</select>
					</td>
				</tr>
				 -->
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