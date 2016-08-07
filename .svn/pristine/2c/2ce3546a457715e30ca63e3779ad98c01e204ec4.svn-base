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
<title>文章新增</title>
<script type="text/javascript">
	var ueditor = UE.getEditor('fcontent');
	var _ueditor = UE.getEditor('fupload');
    _ueditor.ready(function () {
        //设置编辑器不可用
        //_editor.setDisabled();
        //隐藏编辑器，因为不会用到这个编辑器实例，所以要隐藏
        _ueditor.hide();
    });
        
	function upimage(){
	    var imgdialog = _ueditor.getDialog("insertimage");
	    imgdialog.render();
	    imgdialog.open();
	    _ueditor.addListener("beforeInsertImage", function (t, arg) {
	       $("#fimagesurl").val(arg[0].src);
	    });
	}

	function submit() {
		var myform = $("#newsAddForm");
		myform.attr("action", "${ctx}/news/add");
		myform.submit();
	}

	function back() {
		window.location.href = "javascript:history.go(-1);";
	}
	$(function() {
		$('#fcatalog').combotree({
			url : '${ctx}/newsclass/tree',
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
		<form id="newsAddForm" method="post">
			<table class="grid">
				<tr>
					<td>标题</td>
					<td><input id="fuID" name="fuID" type="hidden" value="" /> <input
						name="ftitle" type="text" value="" placeholder="请输入文章标题"
						class="easyui-validatebox" data-options="required:true"
						style="width:400px;height: 25px;"></td>
				</tr>
				<tr>
					<td>关键字</td>
					<td><textarea name="ftag" rows="3" cols="80"
							class="easyui-validatebox" placeholder="请输入关键字"
							data-options="required:true"></textarea></td>
				</tr>
				<tr>
					<td>文章分类</td>
					<td><select id="fcatalog" name="fcatalog"
						style="width:200px;height: 29px;"></select> <a
						class="easyui-linkbutton" href="javascript:void(0)"
						onclick="$('#fcatalog').combotree('clear');">清空</a></td>
				</tr>

				<tr>
					<td>文章图片</td>
					<td>
						<script id="fupload" type="text/plain"></script>
						<input type="text" id="fimagesurl" name="fimagesurl"
						value="" style="width:450px;height: 25px;" /> <a id="upimage"
						href="javascript:void(0);" onclick="upimage()" class="easyui-linkbutton">上传图片</a></td>
				</tr>
				<tr>
					<td>文章内容</td>
					<td><script id="fcontent" name="fcontent" type="text/plain" style="width:650px;height:300px;"></script></td>
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