<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
		<table class="grid">		
			<tr>
				<td>创建人</td>
				<td>${thomeworktype.fcreateBy}</td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td>${thomeworktype.fcreateTime}</td>
			</tr>
		</table>
	</div>
</div>