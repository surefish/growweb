<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
		<table class="grid">
			<tr>
				<td>书名</td>
				<td>${tbook.fname}</td>
			</tr>
			<tr>
				<td>价格</td>
				<td>${tbook.fprice}</td>
			</tr>
			<tr>
				<td>图书类型</td>
				<td>${tbook.gettBookType().getFname()}</td>
			</tr>
			<tr>
				<td>图书封面</td>
				<td><img src="${tbook.furl}" /></td>
			</tr>
			<tr>
				<td>创建人</td>
				<td>${tbook.fcreateBy}</td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td>${tbook.fcreateTime}</td>
			</tr>
		</table>
	</div>
</div>