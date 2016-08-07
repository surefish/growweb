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
<title>课程修改</title>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="fintro"]', {
			resizeType : 1,
			allowPreviewEmoticons : true,
			allowImageUpload : true,
			uploadJson : '/file_upload',
			fileManagerJson : '/file_manager',
			urlType : 'domain',
			allowFileManager : true,
			afterChange : function() {
				this.sync();
			}
		});

		K('#upimage').click(
			function() {
				editor.loadPlugin('image', function() {
					editor.plugin.imageDialog({
						imageUrl : K('#fimage').val(),
						clickFn : function(url, title, width, height,
								border, align) {
							K('#fimage').val(
									"http://img.growhappy.com.cn" + url);
							editor.hideDialog();
						}
					});
				});
			});
	});

	function submit() {
		$("#fintro").val(editor.html());
		alert(editor.html());
		var myform = $("#courseEditForm");
		myform.attr("action", "${ctx}/course/edit");
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
		<form id="courseEditForm" method="post">
			<table class="grid">
				<tr>
					<td>标题</td>
					<td><input id="fuID" name="fuID" type="hidden"
						value="${tcourse.fuID}" /> <input name="fname" type="text"
						value="${tcourse.fname}" placeholder="请输入课程名"
						class="easyui-validatebox" data-options="required:true"
						style="width:400px;height: 25px;"></td>
				</tr>
				<tr>
					<td>老师</td>
					<td><textarea name="fteacher" rows="3" cols="80"
							class="easyui-validatebox" placeholder="请输入老师"
							data-options="required:true">${tcourse.fteacher}</textarea></td>
				</tr>
		
					<tr>
					<td>课时</td>
					<td><textarea name="ftime" rows="3" cols="80"
							class="easyui-validatebox" placeholder="请输入课时"
							data-options="required:true">${tcourse.ftime}</textarea></td>
				</tr>
		
				<tr>
					<td>课程图片</td>
					<td><input type="text" id="fimage" name="fimage"
						value="${tcourse.fimage}" style="width:450px;height: 25px;" />
						<a href="javascript:void(0)" id="upimage"
						class="easyui-linkbutton">上传图片</a></td>
				</tr>
				<tr>
					<td>课程内容</td>
					<td><textarea id="fintro" name="fintro" cols="110"
							rows="20">${tcourse.fintro}</textarea></td>
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