<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="inc.jsp"></jsp:include>
<meta charset="utf-8">
<title>用户登录</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link href="${ctx}/style/css/login.css" rel="stylesheet" type="text/css">
<link href="${ctx}/style/css/logind.css" rel="stylesheet" type="text/css">

<script>

	var sessionInfo_userId = '${sessionInfo.id}';
	if (sessionInfo_userId) {//如果登录,直接跳转到index页面
		window.location.href='${ctx}/admin/index';
	}
	
	$(function() {
		
		$('#loginform').form({
		    url:'${ctx}/admin/login',
		    onSubmit : function() {
		    	progressLoad();
				var isValid = $(this).form('validate');
				if(!isValid){
					progressClose();
				} 
				return isValid;
			},
		    success:function(result){
		    	result = $.parseJSON(result);
		    	progressClose();
		    	if (result.success) {
		    		window.location.href='${ctx}/admin/index';
		    	}else{
		    		$.messager.show({
		    			title:'提示',
		    			msg:'<div class="light-info"><div class="light-tip icon-tip"></div><div>'+result.msg+'</div></div>',
		    			showType:'show'
		    		});
		    	}
		    }
		});
	});
	
	function submitForm(){
		$('#loginform').submit();
	}
	
	function clearForm(){
		$('#loginform').form('clear');
	}
	
	//回车登录
	function enterlogin(){
		if (event.keyCode == 13){
        	event.returnValue=false;
        	event.cancel = true;
        	$('#loginform').submit();
    	}
	}
	
</script>
</head>
<body onkeydown="enterlogin();">
	<form class="box login" id="loginform">
		<fieldset class="boxBody">
			<label>用户名</label> <input type="text" id="loginname" name="loginname"
				tabindex="1" placeholder="请输入用户名" required> <label><a
				href="#" class="rLink" tabindex="5">忘记密码</a>密码</label> <input
				type="password" id="password" name="password" tabindex="2"
				placeholder="请输入密码" required>
		</fieldset>
		<footer>
			<label><input type="checkbox" tabindex="3">下次自动登录</label> <input
				type="button" class="btnLogin" value="登录" tabindex="4"
				onclick="submitForm()">
		</footer>
		<div id="tip"></div>
	</form>
</body>
</html>