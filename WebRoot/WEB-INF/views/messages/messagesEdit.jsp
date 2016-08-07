<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>消息修改</title>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor= K.create('textarea[name="fcontent"]', {
			resizeType : 1,
			allowPreviewEmoticons : true,
			allowImageUpload : true,
			uploadJson: '/file_upload',
			fileManagerJson: '/file_manager',
			allowFileManager: true,
			afterChange:function(){
				this.sync();
			}
		});
		
		K('#upimage').click(function() {
			editor.loadPlugin('image', function() {
				editor.plugin.imageDialog({
					imageUrl : K('#fimages').val(),
					clickFn : function(url, title, width, height, border, align) {
						K('#fimages').val(url);
						editor.hideDialog();
					}
				});
			});
		});
	});
	
	function submit(){
		$("#fcontent").val(editor.html());
		alert(editor.html());
		var myform=$("#messagesEditForm");
		myform.attr("action","${ctx}/messages/edit");
		myform.submit();
	}
	
	function back(){
		window.location.href="javascript:history.go(-1);";
	}
	
	$(function() {
		$('#fcatalog').combotree({
			url : '${ctx}/messagesclass/tree',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto',
			value :'${tmessages.fcatalog}'
		});
	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" 
	style="overflow: scroll;padding: 3px;">
		<form id="messagesEditForm" method="post">
			<table class="grid">
			<tr>
				<td>标题</td>
				<td>
				<input id="fuID" name="fuID" type="hidden"  value="${tmessages.fuID}" />		
				<input name="ftitle" type="text" value="${tmessages.ftitle}" placeholder="请输入消息标题" class="easyui-validatebox" data-options="required:true" style="width:400px;height: 25px;"></td>
			</tr>
			<tr>
				<td>关键字</td>
				<td>
				<textarea name="ftag" rows="3" cols="80" class="easyui-validatebox" placeholder="请输入关键字" data-options="required:true" >${tmessages.ftag}</textarea>
				</td>
			</tr>
			<tr>
				<td>消息分类</td>
				<td><select id="fcatalog" name="fcatalog" style="width:200px;height: 29px;"></select>
				<a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#fcatalog').combotree('clear');" >清空</a>
				</td>
			</tr>
			
			<tr>
				<td>消息图片</td>
				<td>
				<input type="text" id="fimages" name="fimages" value="${tmessages.fimages}" style="width:450px;height: 25px;" />
				<a href="javascript:void(0)" id="upimage" class="easyui-linkbutton">上传图片</a></td>
			</tr>
			<tr>
				<td>消息内容</td>
				<td>
					<textarea id="fcontent" name="fcontent" cols="110" rows="20">${tmessages.fcontent}</textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submit()" style="width:90px">保存</a>
	           		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="back()" style="width:90px">返回</a>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>