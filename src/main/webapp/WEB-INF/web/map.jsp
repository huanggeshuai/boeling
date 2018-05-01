<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/3/30
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">

    <title>高德地图展示</title>
    <script type="text/javascript" src="../../jquery-easyui-1.5.3/jquery.min.js"></script>
    <!--引入jQuery EasyUI 核心库，这里采用的是1.5.3-->
    <script type="text/javascript" src="../../jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <!--引入EasyUI 中文提示信息-->
    <script type="text/javascript" src="../../jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js" ></script>
    <!--引入EasyUI 核心UI 文件CSS-->
    <link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.5.3/themes/default/easyui.css" />
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.5.3/themes/icon.css" />
    <link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>

    <script src="http://cache.amap.com/lbs/static/es5.min.js"></script>
    <!-- 这里要配置参数key,将其值设置为高德官网开发者获取的key -->
    <script type="text/javascript" src='http://webapi.amap.com/maps?v=1.4.4&key=bee0abe32f405104e257d1b946fc699a&plugin=AMap.ToolBar'></script>
    <script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>

    <style type="text/css">
        #container{
            /*margin-left:500px;*/
            /*margin-top:50px;*/
            width:100%;
            height:100%;
        }
    </style>
</head>
<body>
<div><h2>欢迎进入高德地图</h2></div>
<div id="container"></div>

<script>
    //创建地图,设定地图的中心点和级别
    var map = new AMap.Map('container', {
        resizeEnable: true,
        zoom:5,
        center: [117.301672, 34.193316]

    });


//    //信息窗体的创建与设定
//    var infowindow = new AMap.InfoWindow({
//        content: '<h3>高德地图</h1><div>高德是中国领先的数字地图内容、导航和位置服务解决方案提供商。</div>',
//        offset: new AMap.Pixel(0, -30),
//        size:new AMap.Size(230,0)
//    });
//    //点标记的创建与添加
//    var marker = new AMap.Marker({
//        position:[117.301672, 34.193316],
//        map:map
//    });
    map.clearMap();
    var markers = [];
    var infoWindow;
    $.ajax({
        url : "venues/getvenues.action",
        type : "get",
        dataType : "json",

        success : function(e) {

            // var data=[{"fLong":'112.00003','fLati':'38.2345'},{"fLong":'115.00003','fLati':'38.2345'},{"fLong":'114.00003','fLati':'38.2345'},{"fLong":'116.00003','fLati':'38.2345'}];
            // e.data = data;
            var marker;
            for(var i=0 ; i< e.length;i++){
                var jfong=[ e[i].venuesLongitude,e[i].venuesLatitude];
                marker = new AMap.Marker({
                    position: jfong,
                  //  zIndex: 101,
                    map:map
                });
              //  console.log(e.data[3]);
                marker.setMap(map);
                marker.venuesName=e[i].venuesName;
                marker.openTime=e[i].openTime;
                marker.closeTime=e[i].closeTime;
                marker.userEmail=e[i].userCharge.userEmail;
                marker.username=e[i].userCharge.userTruename;
              //  marker.status=e[i].status;
                marker.on('click', function(e){

                    infoWindow.setContent("<ul class='main'>"
                        + "<li>  场馆名称: <span >"+e.target.venuesName+"  </span></li>"
                        + "<li>  开馆时间: <span >"+e.target.openTime+"  </span></li>"
                        + "<li>  闭馆时间: <span >"+e.target.closeTime+"  </span></li>"
                        + "<li>  联系人: <span >"+e.target.username+"  </span></li>"
                        + "<li>  联系方式 : <span >"+e.target.userEmail +"  </span></li></ul>");
                    infoWindow.open(map, e.lnglat);
                });


            }   // for-end

            infoWindow = new AMap.InfoWindow({
//                isCustom:   true,
//                draggable: true,  //是否可拖动
//                offset: new AMap.Pixel(0, -31),
//                content:""
            });

        }


    }); //   Ajax结束

    function markerClick(e){
        infoWindow.setContent(e.target.content);
        infoWindow.open(map, e.target.getPosition());
    }

</script>
</body>
</html>