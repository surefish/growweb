<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
		<table class="grid">
			<tr>
				<td>标题</td>
				<td>${tschool.ftitle}</td>
			</tr>
			<tr>
				<td>关键字</td>
				<td>${tnews.ftag}</td>
			</tr>
			<tr>
				<td>文章分类</td>
				<td>${tnews.fcatalog}</td>
			</tr>
			<tr>
				<td>文章图片</td>
				<td><img src="${tnews.fimagesurl}" /></td>
			</tr>
			<tr>
				<td>创建人</td>
				<td>${tnews.fcreateBy}</td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td>${tnews.fcreateTime}</td>
			</tr>
		</table>
	</div>
</div>