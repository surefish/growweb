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
<title>图书编辑</title>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {

		editor = K.create('textarea[name="fintroduced"]', {
			resizeType : 1,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			uploadJson : '/file_upload',
			
			fileManagerJson : '/file_manager',
			urlType : 'domain',
			allowFileManager : false,
			afterChange : function() {
				this.sync();
			}
		});
		
		K('#upimage').click(
			
				
				function() {
				editor.loadPlugin('image', function() {
					
					
					editor.plugin.imageDialog({
						imageUrl : K('#furl').val(),
						clickFn : function(url, title, width, height,
								border, align) {
							K('#furl').val(
									"http://img.growhappy.com.cn" + url);
							editor.hideDialog();
						}
					});
				});
			});
	});

	function submit() {
		$("#fintroduced").val(editor.html());
		alert(editor.html());
		var myform = $("#bookEditForm");
		myform.attr("action", "${ctx}/book/edit");
		alert("click");
		myform.submit();
	}

	function back() {
		window.location.href = "javascript:history.go(-1);";
	}

	$(function() {
		$('#fuid').combotree({
			url : '${ctx}/booktype/tree',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto',
			value : '${tbook.gettBookType().getFname()}'
		});

	});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">

	<div data-options="region:'center',border:false" title=""
		style="overflow: scroll;padding: 3px;">

		<form id="bookEditForm" method="post">
			<table class="grid">
				<tr>
					<td>书名</td>
					<td><input id="fuID" name="fuID" type="hidden"
						value="${tbook.fuID}" /> <input name="fname" type="text"
						value="${tbook.fname}" placeholder="请输入书名"
						class="easyui-validatebox" data-options="required:true"
						style="width:400px;height: 25px;"></td>
				</tr>
				<tr>
					<td>价格</td>
					<td><textarea name="fprice" rows="3" cols="80"
							class="easyui-validatebox" placeholder="请输入价格"
							data-options="required:true">${tbook.fprice}</textarea></td>
				</tr>
				<tr>
					<td>书籍类型</td>
					<td><select id="fuid" name="fname"  
						value="${tbook.gettBookType().getFuID()}"
						style="width:200px;height: 29px;"></select> <a
						class="easyui-linkbutton" href="javascript:void(0)"
						onclick="$('#fuid').combotree('clear');">清空</a></td>
				</tr>

				<tr>
					<td>书籍封面</td>
					<td><input type="text" id="furl" name="furl"
						value="${tbook.furl}" style="width:450px;height: 25px;" />
						<a href="javascript:void(0)" id="upimage"
						class="easyui-linkbutton">上传图片</a></td>
				</tr>
				<tr>
					<td>书籍简介</td>
					<td><textarea id="fintroduced" name="fintroduced" cols="110"
							rows="20">${tbook.fintroduced}</textarea></td>
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