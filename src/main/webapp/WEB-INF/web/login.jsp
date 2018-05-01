<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/3/31
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content='easyui,jui,jquery easyui,easyui demo,easyui中文'/>
    <meta name="description" content='TopJUI前端框架，基于最新版EasyUI前端框架构建，纯HTML调用功能组件，不用写JS代码的EasyUI，专注你的后端业务开发！'/>
    <title>掌上保龄球 - 用户登录</title>
    <!-- 浏览器标签图片 -->
    <link rel="shortcut icon" href="../../topjui/image/favicon.ico"/>
    <link rel="stylesheet" href="../../static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../static/plugins/font-awesome/css/font-awesome.min.css">
    <style type="text/css">
        html, body {
            height: 100%;
        }

        .box {
            background: url("/topjui/image/loginBg.jpg") no-repeat center center;
            background-size: cover;

            margin: 0 auto;
            position: relative;
            width: 100%;
            height: 100%;
        }

        .login-box {
            width: 100%;
            max-width: 500px;
            height: 400px;
            position: absolute;
            top: 50%;

            margin-top: -200px;
            /*设置负值，为要定位子盒子的一半高度*/

        }

        @media screen and (min-width: 500px) {
            .login-box {
                left: 50%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -250px;
            }
        }

        .form {
            width: 100%;
            max-width: 500px;
            height: 275px;
            margin: 2px auto 0px auto;
        }

        .login-content {
            border-bottom-left-radius: 8px;
            border-bottom-right-radius: 8px;
            height: 250px;
            width: 100%;
            max-width: 500px;
            background-color: rgba(255, 250, 2550, .6);
            float: left;
        }

        .input-group {
            margin: 30px 0px 0px 0px !important;
        }

        .form-control,
        .input-group {
            height: 40px;
        }

        .form-actions {
            margin-top: 30px;
        }

        .form-group {
            margin-bottom: 0px !important;
        }

        .login-title {
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            padding: 20px 10px;
            background-color: rgba(0, 0, 0, .6);
        }

        .login-title h1 {
            margin-top: 10px !important;
        }

        .login-title small {
            color: #fff;
        }

        .link p {
            line-height: 20px;
            margin-top: 30px;
        }

        .btn-sm {
            padding: 8px 24px !important;
            font-size: 16px !important;
        }

        .flag {
            position: absolute;
            top: 10px;
            right: 10px;
            color: #fff;
            font-weight: bold;
            font: 14px/normal "microsoft yahei", "Times New Roman", "宋体", Times, serif;
        }
    </style>
    <title>${config_siteConfig.cfgCompanyName}</title>
</head>
<body>
<div class="box">
    <div class="login-box">
        <div class="login-title text-center">
            <span class="flag"><i class="fa fa-user"></i> 用户登陆</span>
        </div>
        <div class="login-content ">
            <div class="form">
                <form id="modifyPassword" class="form-horizontal" action="#" method="post">
                    <input type="hidden" id="referer" name="referer" value="${param.referer}">
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" id="userEmail" name="userEmail" class="form-control" placeholder="用户名"
                                      >
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" id="userPassword" name="userPassword" class="form-control"
                                       placeholder="密码" >
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-actions">
                        <div class="col-xs-12 text-center">
                            <button type="button" id="login" class="btn btn-sm btn-success">
                                <span class="fa fa-check-circle"></span> 登录
                            </button>
                            <button type="button" id="reset" class="btn btn-sm btn-danger">
                                <span class="fa fa-close"></span> 重置
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <span class="text-danger"><i class="fa fa-warning"></i> 用户名或密码错误，请重试！</span>
            </div>
        </div>
    </div>
</div>

<!-- 引入jQuery -->
<script src="/static/plugins/jquery/jquery.min.js"></script>
<script src="/static/plugins/jquery/jquery.cookie.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>

<!-- 浏览器标签图片 -->
<link rel="shortcut icon" href="../topjui/image/favicon.ico"/>
<!-- TopJUI框架样式 -->
<link type="text/css" href="../topjui/css/topjui.core.min.css" rel="stylesheet">
<link type="text/css" href="../topjui/themes/default/topjui.red.css" rel="stylesheet" id="dynamicTheme"/>
<!-- FontAwesome字体图标 -->
<link type="text/css" href="../static/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
<!-- jQuery相关引用 -->
<script type="text/javascript" src="../static/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../static/plugins/jquery/jquery.cookie.js"></script>
<!-- TopJUI框架配置 -->
<script type="text/javascript" src="../static/public/js/topjui.config.js"></script>
<!-- TopJUI框架核心 -->
<script type="text/javascript" src="../topjui/js/topjui.core.min.js"></script>
<!-- TopJUI中文支持 -->
<script type="text/javascript" src="../topjui/js/locale/topjui.lang.zh_CN.js"></script>
<!-- 首页js -->

<script type="text/javascript" src="../static/public/js/topjui.index.js" charset="utf-8"></script>
<link type="text/css" href="../css/index.css" rel="stylesheet">




<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="/static/plugins/bootstrap/plugins/html5shiv.min.js"></script>
<script src="/static/plugins/bootstrap/plugins/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if (navigator.appName == "Microsoft Internet Explorer" &&
        (navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE6.0" ||
        navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE7.0" ||
        navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")
    ) {
        alert("您的浏览器版本过低，请使用360安全浏览器的极速模式或IE9.0以上版本的浏览器");
    }
</script>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?71559c3bdac3e45bebab67a5a841c70e";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script type="text/javascript">
    $(function () {

        $('#password').keyup(function (event) {
            if (event.keyCode == "13") {
                $("#login").trigger("click");
                return false;
            }
        });

        $("#login").on("click", function () {
            submitForm();
        });

        function submitForm() {
            if (navigator.appName == "Microsoft Internet Explorer" &&
                (navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE6.0" ||
                navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE7.0" ||
                navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")
            ) {
                alert("您的浏览器版本过低，请使用360安全浏览器的极速模式或IE9.0以上版本的浏览器");
            } else {
                var formData = {
                    "userEmail": $('#userEmail').val(),
                    "userPassword": $('#userPassword').val(),
                    //referer: $('#referer').val()
                };
                $.ajax({
                    type: 'POST',
                    url: 'login.action',
                    dataType: 'json',
                    //  contentType: "application/json; charset=utf-8",
                    data: {
                        "userEmail": $('#userEmail').val(),
                        "userPassword": $('#userPassword').val()
                    },
                    success: function (data) {
                        if (data.success == true) {
                            //location.href = '/system/index/index?portal=${portal}';
                            location.href = 'findmain.action';
                        } else {
                            //    $('#myModal').modal(data.msg);
//                            $("#myModal").modal({
//                                remote: data.msg
//                            });
                            // alert(data.msg)
//                            $('#myModal').modal().text(data.msg);
                            //alert("用户名或密码错误！");
                            $.messager.alert('提示', data.msg, 'info');
                        }
                    },
                    error: function () {

                    }
                });
            }
        }

        $("#reset").on("click", function () {
            $("#username").val("");
            $("#password").val("");
        });
    });
</script>
</body>
</html>
