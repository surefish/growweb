<%@ page language="java" pageEncoding="UTF-8"%>  
<%@ include file="/WEB-INF/jsp/common/meta.jsp"%>  
<script type="text/javascript" src="${ctx}/static/js/ajaxfileupload.js"></script>  


  
<script type="text/javascript">  
function ajaxFileUpload(){  
    //开始上传文件时显示一个图片,文件上传完成将图片隐藏  
    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});  
    //执行上传文件操作的函数  
    $.ajaxFileUpload({  
        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)  
        url:'${ctx}/tb/report/editImage?reportId=${reportId}',  
        secureuri:false,                           //是否启用安全提交,默认为false   
        fileElementId:'reportFile',               //文件选择框的id属性  
        dataType:'text',                           //服务器返回的格式,可以是json或xml等  
        success:function(data, status){            //服务器响应成功时的处理函数  
            data = data.replace(/<pre.*?>/g, '');  //ajaxFileUpload会对服务器响应回来的text内容加上<pre style="....">text</pre>前后缀  
            data = data.replace(/<PRE.*?>/g, '');  
            data = data.replace("<PRE>", '');  
            data = data.replace("</PRE>", '');  
            data = data.replace("<pre>", '');  
            data = data.replace("</pre>", '');     //本例中设定上传文件完毕后,服务端会返回给前台[0`filepath]  
            if(data.substring(0, 1) == 0){         //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)  
                $("img[id='uploadImage']").attr("src", data.substring(2));  
                $('#result').html("<font color=\"red\"> 图片上传成功</font><br/>");  
            }else{  
                $('#result').html("<font color=\"red\"> 图片上传失败，请重试！！</font><br/>");  
            }  
        },  
        error:function(data, status, e){ //服务器响应失败时的处理函数  
            $('#result').html("<font color=\"red\"> 图片上传失败，请重试！！</font><br/>");  
        }  
    });  
}  
</script>  
  
<div class="easyui-layout" data-options="fit:true"  
    id="tbReportDetail_layout">  
    <div data-options="region:'center'" style="padding: 10 10 10 20px;">  
        <form id="tbReport_form" class="hgform">  
            <table class="hgtable">  
                <div id="result"></div>  
                <tr>  
                    <td width="120px;">商品名称<font>*</font>:</td>  
                    <td><input disabled="disabled" class="required" type="text"  
                        value="${reportTitle}" style="width:120px;"></input>  
                    </td>  
                </tr>  
                <tr>  
                    <td width="160px;">商品图片<font>*</font>:</td>  
                    <td><input class="easyui-validatebox" type="file"  
                        id="reportFile" name="reportFile" style="width:160px;"></input>  
                    </td>  
                </tr>  
                <tr>  
                    <td width="160px;">图片预览<font>*</font>:</td>  
                    <td><img id="uploadImage" src="">  
                    </td>  
                </tr>  
                <tr>  
                    <td width="160px;">上传<font>*</font>:</td>  
                    <td><input type="button" value="上传图片"  
                        onclick="ajaxFileUpload()" /></td>  
                </tr>  
            </table>  
        </form>  
    </div>  
</div>  