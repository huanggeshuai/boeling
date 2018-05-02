<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content='easyui,jui,jquery easyui,easyui demo,easyui中文'/>
    <meta name="description" content='TopJUI前端框架，基于最新版EasyUI前端框架构建，纯HTML调用功能组件，不用写JS代码的EasyUI，专注你的后端业务开发！'/>
    <title>掌上保龄球后台管理系统</title>
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
</head>

<body>
<div id="loading" class="loading-wrap">
    <div class="loading-content">
        <div class="loading-round"></div>
        <div class="loading-dot"></div>
    </div>
</div>

<div id="mm" class="submenubutton" style="width: 140px;">
    <div id="mm-tabclose" name="6" iconCls="fa fa-refresh">刷新</div>
    <div class="menu-sep"></div>
    <div id="Div1" name="1" iconCls="fa fa-close">关闭</div>
    <div id="mm-tabcloseother" name="3">关闭其他</div>
    <div id="mm-tabcloseall" name="2">关闭全部</div>
    <div class="menu-sep"></div>
    <div id="mm-tabcloseright" name="4">关闭右侧标签</div>
    <div id="mm-tabcloseleft" name="5">关闭左侧标签</div>
</div>

<script>
    $(function () {
        $('#ulMenu>li').hover(
            function () {
                var m = $(this).data('menu');
                if (!m) {
                    m = $(this).find('ul').clone();
                    m.appendTo(document.body);
                    $(this).data('menu', m);
                    var of = $(this).offset();
                    m.css({left: of.left, top: of.top + this.offsetHeight});
                    m.hover(function () {
                        clearTimeout(m.timer);
                    }, function () {
                        m.hide()
                    });
                }
                m.show();
            }, function () {
                var m = $(this).data('menu');
                if (m) {
                    m.timer = setTimeout(function () {
                        m.hide();
                    }, 100);//延时隐藏，时间自定义，100ms
                }
            }
        );
    });
    function startTime()
    {
        var today=new Date();//定义日期对象
        var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年
        var MM = today.getMonth()+1;//通过日期对象的getMonth()方法返回年
        var dd = today.getDate();//通过日期对象的getDate()方法返回年
        var hh=today.getHours();//通过日期对象的getHours方法返回小时
        var mm=today.getMinutes();//通过日期对象的getMinutes方法返回分钟
        var ss=today.getSeconds();//通过日期对象的getSeconds方法返回秒
        // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09
        MM=checkTime(MM);
        dd=checkTime(dd);
        mm=checkTime(mm);
        ss=checkTime(ss);
        var day; //用于保存星期（getDay()方法得到星期编号）
        if(today.getDay()==0)   day   =   "星期日 "
        if(today.getDay()==1)   day   =   "星期一 "
        if(today.getDay()==2)   day   =   "星期二 "
        if(today.getDay()==3)   day   =   "星期三 "
        if(today.getDay()==4)   day   =   "星期四 "
        if(today.getDay()==5)   day   =   "星期五 "
        if(today.getDay()==6)   day   =   "星期六 "
        document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"-"+MM +"-"+ dd +" " + hh+":"+mm+":"+ss+"   " + day;
        setTimeout('startTime()',1000);//每一秒中重新加载startTime()方法
    }

    function checkTime(i)
    {
        if (i<10){
            i="0" + i;
        }
        return i;
    }



</script>
<div data-toggle="topjui-layout" data-options="id:'index_layout',fit:true">
    <div id="north" class="banner" data-options="region:'north',border:false,split:false"
         style="height: 50px; padding:0;margin:0; overflow: hidden;">
        <table style="float:left;border-spacing:0px;">
            <tr>
                <td class="webname">
                    <span class="fa fa-envira" style="font-size:26px; padding-right:8px;"></span>后台管理系统
                </td>
                <td class="collapseMenu" style="text-align: center;cursor: pointer;">
                    <span class="fa fa-chevron-circle-left" style="font-size: 18px;"></span>
                </td>
                <td>
                    <table id="topmenucontent" cellpadding="0" cellspacing="0">
                        <td id="1325" title="这只是静态演示" class="topmenu selected systemName">
                            <a class="l-btn-text bannerMenu" href="javascript:void(0)">
                                <p>
                                    <lable class="fa fa-hand-pointer-o"></lable>
                                </p>
                                <p><span style="white-space:nowrap;">刷新菜单</span></p>
                            </a>
                        </td>

                        <td>

                        </td>
                        <body onload="startTime()">
                        <td>&nbsp;&nbsp;&nbsp;&nbsp;当前时间：<span id="nowDateTimeSpan"></span></td>
                        </body>
                    </table>
                </td>
            </tr>
        </table>
        <span style="float: right; padding-right: 10px; height: 50px; line-height: 50px;">
            <a href="javascript:void(0)" data-toggle="topjui-menubutton"
               data-options="iconCls:'fa fa-user',hasDownArrow:false"
               style="color:#fff;">${admin.userTruename}</a>|
            <a href="javascript:void(0)" id="mb3" data-toggle="topjui-menubutton"
               data-options="menu:'#mm3',iconCls:'fa fa-cog',hasDownArrow:true" style="color:#fff;">设置</a>
            <div id="mm3" style="width:74px;">
                <div data-options="iconCls:'fa fa-info-circle'" onclick="javascript:void(0)">个人信息</div>
                <div class="menu-sep"></div>
                <div data-options="iconCls:'fa fa-key'" onclick="javascript:modifyPwd(0)">修改密码</div>
            </div>|
            <a href="javascript:void(0)" id="mb2" data-toggle="topjui-menubutton"
               data-options="menu:'#mm2',iconCls:'fa fa-tree',hasDownArrow:true" style="color:#fff;">主题</a>|
            <div id="mm2" style="width:180px;">
                <div data-options="iconCls:'fa fa-tree blue'" onclick="changeTheme('blue')">默认主题</div>
                <div data-options="iconCls:'fa fa-tree'" onclick="changeTheme('black')">黑色主题</div>
                <div data-options="iconCls:'fa fa-tree'" onclick="changeTheme('blacklight')">黑色主题-亮</div>
                <div data-options="iconCls:'fa fa-tree red'" onclick="changeTheme('red')">红色主题</div>
                <div data-options="iconCls:'fa fa-tree red'" onclick="changeTheme('redlight')">红色主题-亮</div>
                <div data-options="iconCls:'fa fa-tree green'" onclick="changeTheme('green')">绿色主题</div>
                <div data-options="iconCls:'fa fa-tree green'" onclick="changeTheme('greenlight')">绿色主题-亮</div>
                <div data-options="iconCls:'fa fa-tree purple'" onclick="changeTheme('purple')">紫色主题</div>
                <div data-options="iconCls:'fa fa-tree purple'" onclick="changeTheme('purplelight')">紫色主题-亮</div>
                <div data-options="iconCls:'fa fa-tree blue'" onclick="changeTheme('blue')">蓝色主题</div>
                <div data-options="iconCls:'fa fa-tree blue'" onclick="changeTheme('bluelight')">蓝色主题-亮</div>
                <div data-options="iconCls:'fa fa-tree orange'" onclick="changeTheme('yellow')">橙色主题</div>
                <div data-options="iconCls:'fa fa-tree orange'" onclick="changeTheme('yellowlight')">橙色主题-亮</div>
            </div>
            <a href="javascript:void(0)" onclick="logout()" data-toggle="topjui-menubutton"
               data-options="iconCls:'fa fa-sign-out',hasDownArrow:false" style="color:#fff;">注销</a>
        </span>
    </div>

    <div id="west"
         data-options="region:'west',split:true,width:230,border:false,headerCls:'border_right',bodyCls:'border_right'"
         title="" iconCls="fa fa-dashboard">
        <div id="RightAccordion"></div>
        <!--<div id="menuTab" class="topjui-tabs" data-options="fit:true,border:false">
            <div title="导航菜单" data-options="iconCls:'fa fa-sitemap'" style="padding:0;">
                <div id="RightAccordion" class="topjui-accordion"></div>
            </div>
            <div title="常用链接" data-options="iconCls:'fa fa-star',closable:true">
                <ul id="channgyongLink"></ul>
            </div>
        </div>-->
    </div>

    <div id="center" data-options="region:'center',border:false" style="overflow:hidden;">
        <div id="index_tabs" style="width:100%;height:100%">
            <div title="保龄球地点分布图" iconCls="fa fa-home" data-options="border:true"
                 href="findmap.action"
            ></div>
        </div>
    </div>

    <div data-options="region:'south',border:true"
         style="text-align:center;height:30px;line-height:30px;border-bottom:0;overflow:hidden;">
        <span style="float:left;padding-left:5px;width:30%;text-align: left;">当前用户：${admin.userTruename}</span>
        <span style="padding-right:5px;width:40%">
            版权所有 © 2014-2017
            <td>&nbsp;&nbsp;掌上保龄球后台管理系统<td>
            <td>&nbsp;&nbsp;&nbsp;粤ICP备16028103号-1</td>
        </span>
        <span style="float:right;padding-right:5px;width:30%;text-align: right;">版本：<script>document.write(topJUI.version)</script></span>
    </div>
</div>

<!--[if lte IE 8]>
<div id="ie6-warning">
    <p>您正在使用低版本浏览器，在本页面可能会导致部分功能无法使用，建议您升级到
        <a href="http://www.microsoft.com/china/windows/internet-explorer/" target="_blank">IE9或以上版本的浏览器</a>
        或使用<a href="http://se.360.cn/" target="_blank">360安全浏览器</a>的极速模式浏览
    </p>
</div>
<![endif]-->

<div id="themeStyle" data-options="iconCls:'fa fa-tree'" style="display:none;width:600px;height:340px">
    <table style="width:100%; padding:20px; line-height:30px;text-align:center;">
        <tr>
            <td>
                <div class="skin-common skin-black"></div>
                <input type="radio" name="themes" value="black" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-red"></div>
                <input type="radio" name="themes" value="red" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-green"></div>
                <input type="radio" name="themes" value="green" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-purple"></div>
                <input type="radio" name="themes" value="purple" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-blue"></div>
                <input type="radio" name="themes" value="blue" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-yellow"></div>
                <input type="radio" name="themes" value="yellow" class="topjuiTheme"/>
            </td>
        </tr>
        <tr>
            <td>
                <div class="skin-common skin-blacklight"></div>
                <input type="radio" name="themes" value="blacklight" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-redlight"></div>
                <input type="radio" name="themes" value="redlight" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-greenlight"></div>
                <input type="radio" name="themes" value="greenlight" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-purplelight"></div>
                <input type="radio" name="themes" value="purplelight" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-bluelight"></div>
                <input type="radio" name="themes" value="bluelight" class="topjuiTheme"/>
            </td>
            <td>
                <div class="skin-common skin-yellowlight"></div>
                <input type="radio" name="themes" value="yellowlight" class="topjuiTheme"/>
            </td>
        </tr>
    </table>
    <table style="width: 100%; padding: 20px; line-height: 30px; text-align: center;">
        <tr>
            <td>
                <input type="radio" name="menustyle" value="accordion" checked="checked"/>手风琴
            <td>
                <input type="radio" name="menustyle" value="tree"/>树形
            </td>
            <td>
                <input type="checkbox" checked="checked" name="topmenu" value="topmenu"/>开启顶部菜单
            </td>
        </tr>
    </table>
</div>

<form id="pwdDialog"
      data-options="title: '修改密码',
      iconCls:'fa fa-key',
      width: 400,
      height: 300,
      href: '/html/user/modifyPassword.html'"></form>
</body>
</html>