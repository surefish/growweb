<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" 
	style="overflow: scroll;padding: 3px;">
		<table class="grid">
			<tr>
				<td>标题</td>
				<td>${tmessages.ftitle}</td>
			</tr>
			<tr>
				<td>关键字</td>
				<td>${tmessages.ftag}</td>
			</tr>
			<tr>
				<td>消息分类</td>
				<td>${tmessages.fcatalog}</td>
			</tr>
			<tr>
				<td>消息图片</td>
				<td><img src="${tmessages.fimages}" /></td>
			</tr>
			<tr>
				<td>创建人</td>
				<td>${tmessages.fcreateBy}</td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td>${tmessages.fcreateTime}</td>
			</tr>
		</table>
	</div>
</div>