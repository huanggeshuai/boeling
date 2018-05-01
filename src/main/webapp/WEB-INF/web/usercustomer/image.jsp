<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/15
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<div>
    <form enctype="multipart/form-data" id="pfm" method="POST">
        <fieldset>
            <legend class="optional">用户活动图片:</legend>
            <div class="form-row">
                预　　览:
                <div id="localImag">
                    <%--<img src="/upload/20140566152/20140566152PersonalPicture.jpg">--%>
                    <%--预览，默认图片--%>
                    <img id="preview" alt="预览图片" onclick="over(preview,divImage,imgbig);" src='${userCustomActivity.imageurl}' style="width: 200px; height: 200px;"/>
                </div>
            </div>
        </fieldset>
        <input type="hidden" id="buttom" value="提交" onclick="uploadPic()" style="margin-top: 10px">
    </form>


</div>
<script type="text/javascript">
    <%--document.getElementById("preview").src="image";--%>
    <%--var image="http://localhost:8080"+${venuesupload.imageurl};--%>
    //检查图片的格式是否正确,同时实现预览
    function setImagePreview(obj, localImagId, imgObjPreview) {
        var array = new Array('gif', 'jpeg', 'png', 'jpg', 'bmp'); //可以上传的文件类型
        if (obj.value == '') {
            $.messager.alert('提示消息',"让选择要上传的图片!",'info');
            return false;
        }else {
            var fileContentType = obj.value.match(/^(.*)(\.)(.{1,8})$/)[3]; //这个文件类型正则很有用
            ////布尔型变量
            var isExists = false;
            //循环判断图片的格式是否正确
            for (var i in array) {
                if (fileContentType.toLowerCase() == array[i].toLowerCase()) {
                    //图片格式正确之后，根据浏览器的不同设置图片的大小
                    if (obj.files && obj.files[0]) {
                        //火狐下，直接设img属性
                        imgObjPreview.style.display = 'block';
                        imgObjPreview.style.width = '200px';
                        imgObjPreview.style.height = '200px';
                        //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
                        imgObjPreview.src = window.URL.createObjectURL(obj.files[0]);
                    }else {
                        //IE下，使用滤镜
                        obj.select();
                        var imgSrc = document.selection.createRange().text;
                        //必须设置初始大小
                        localImagId.style.width = "200px";
                        localImagId.style.height = "200px";
                        //图片异常的捕捉，防止用户修改后缀来伪造图片
                        try {
                            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader=").src = imgSrc;
                        }catch (e) {
                            $.messager.alert('提示消息',"您上传的图片格式不正确，请重新选择!",'info');
                            return false;
                        }
                        imgObjPreview.style.display = 'none';
                        document.selection.empty();
                    }
                    isExists = true;
                    return true;
                }
            }
            if (isExists == false) {
                $.messager.alert('提示消息',"上传图片类型不正确!",'info');
                return false;
            }
            return false;
        }
    }

    function uploadPic(){
        $('#pfm').form('submit', {
         //   url: 'filesUpload.action?venuesid='+'${venuesupload.venuesid}',
            onSubmit: function () {
                if($("#file").val()==""){
                    $.messager.alert('提示消息',"请选择要上传的图片!",'info');
                    return false;
                }
            },
            success: function (data) {
                var obj = JSON.parse(data) ;
                $.messager.alert('提示消息',obj.msg,'info');
                $('#venuesdialog').dialog('close');
//                $.ajax({
//                    url:"personalInfoStu.action",
//                    type:"post"
//                });
            }
        });
    }
</script>

