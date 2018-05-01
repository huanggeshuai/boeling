<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/3
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>--%>
    <%--<!-- 避免IE使用兼容模式 -->--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">--%>
    <%--<meta name="renderer" content="webkit">--%>
    <%--<!-- TopJUI框架样式 -->--%>
    <%--<link type="text/css" href="../../topjui/css/topjui.core.min.css" rel="stylesheet">--%>
    <%--<link type="text/css" href="../../topjui/themes/default/topjui.red.css" rel="stylesheet" id="dynamicTheme"/>--%>
    <%--<!-- FontAwesome字体图标 -->--%>
    <%--<link type="text/css" href="../../static/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>--%>
    <%--<!-- layui框架样式 -->--%>
    <%--<link type="text/css" href="../../static/plugins/layui/css/layui.css" rel="stylesheet"/>--%>
    <%--<!-- jQuery相关引用 -->--%>
    <%--<script type="text/javascript" src="../../static/plugins/jquery/jquery.min.js"></script>--%>
    <%--<script type="text/javascript" src="../../static/plugins/jquery/jquery.cookie.js"></script>--%>
    <%--<!-- TopJUI框架配置 -->--%>
    <%--<script type="text/javascript" src="../../static/public/js/topjui.config.js"></script>--%>
    <%--<!-- TopJUI框架核心-->--%>
    <%--<script type="text/javascript" src="../../topjui/js/topjui.core.min.js"></script>--%>
    <%--<!-- TopJUI中文支持 -->--%>
    <%--<script type="text/javascript" src="../../topjui/js/locale/topjui.lang.zh_CN.js"></script>--%>
    <%--<!-- layui框架js -->--%>
    <%--<script type="text/javascript" src="../../static/plugins/layui/layui.js" charset="utf-8"></script>--%>
    <!--引入jQuery 核心库，这里采用的是2.0-->
    <script type="text/javascript" src="../../../jquery-easyui-1.5.3/jquery.min.js"></script>
    <!--引入jQuery EasyUI 核心库，这里采用的是1.5.3-->
    <script type="text/javascript" src="../../../jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <!--引入EasyUI 中文提示信息-->
    <script type="text/javascript" src="../../../jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js" ></script>
    <!--引入EasyUI 核心UI 文件CSS-->
    <link rel="stylesheet" type="text/css" href="../../../jquery-easyui-1.5.3/themes/default/easyui.css" />
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="../../../jquery-easyui-1.5.3/themes/icon.css" />
    <%--高德地图的服务--%>

</head>
<body class="easyui-layout">
<div region="center" fit="true" title="场馆管理">

    <table id="venues" toolbar="#tb" ></table>
    <div id="tb">
        <table>
            <tr>
                <td>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">增加</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="editvenue()">修改</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="audit()">审核</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-upload" plain="true" onclick="upload()">上传文件</a>
                    <span style="font-size: small">审核状态:</span>
                    <select  class="easyui-combobox" id="deletestate" name="userAuthority" data-options="panelHeight:'auto'" style="width: 120px" >
                        <option value ="0">已审核</option>
                        <option value ="1">未审核</option>
                        <option value ="2">审核不通过</option>
                    </select>
                    <select  class="easyui-combobox" id="imagecomfirm" name="imagecomfirm" data-options="panelHeight:'auto'" style="width: 120px" >
                        <option value ="0">未上传图片</option>
                        <option value ="1">已上传图片</option>
                    </select>
                </td>
                <td>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchinfo()">搜索</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="cleartext()">清除文本框</a>
                </td>
            </tr>
            <tr>
                <%--<form enctype="multipart/form-data" method="post">--%>
                    <%--<table>--%>
                        <%--<td>上传图片</td>--%>
                        <%--<td><input type="file"></td>--%>
                        <%--<td><input type="file"></td>--%>
                    <%--</table>--%>
                <%--</form>--%>

            </tr>
        </table>


    </div>
    <div id="venuesdialog"  data-options="closed:true,iconCls:'icon-save'" style="width:400px;height: 300px;">
    </div>
</div>
</body>
<script>
    $('#venues').datagrid({
        url : 'venuesinfo.action',
        //queryParams:{"mdirid":0,"eid":0},//第一次加载时选择所有基地和所有材料
        idField:'venuesid',
        iconCls : 'icon-man',
        striped : true,
        fit:true,
        queryParams:{
            "deletestate":'',
//            "userEmail":'',
//            "userState":'',
//            "userAuthority":''
        },
        // rownumbers : true,
        singleSelect : true,
        fitColumns : false,
        pagination: true,
        pageSize:20,
        //    singleSelect:false,
        pageList:[20,30,40],
        loadMsg:'正在加载资源文档信息...',
        emptyMsg:'没有所需的信息',
        columns : [[
            {

                checkbox:true,
                field : '12',
                title : '编号',
                halign:'center',
            },
            {

                field : 'venuesid',
                title : '场馆编号',
                halign:'center',
            },
            {
                field:"venuesName",
                title:"场馆名称",
                halign:'center',
                align:'center',
                width:100,
                sortable:true
            },
            {
                field:'venuesUserCharge',
                title:'场馆负责人',
                halign:'center',
                width:100,
                formatter:function(value,row,index){
                    return row.userCharge.userTruename

                }
            },
            {
                field:'venuesProvice',
                title:'省',
                halign:'center',
                width:80,
                formatter:function(value,row,index){
                    return row.provinces.province

                }
            },
            {
                field : 'venuesCity',
                title : '市',
                halign:'center',
                width : 80,
                formatter:function(value,row,index){
                    return row.cities.city

                }
            },

            {
                field:"venuesAreas",
                title:"县",
                halign:'center',
                align:'center',
                width:100,
                formatter:function(value,row,index){
                    return row.areas.area

                }
            },
            {
                field:"venuesAddress",
                title:"详细地址",
                halign:'center',
                align:'center',
                width:100,
            },
            {
                field:"venuesLongitude",
                title:"场馆所在经度",
                halign:'center',
                align:'center',
                width:100,

            },
            {
                field:"phone",
                title:"手机号码",
                halign:'center',
                align:'center',
                width:70,
            },
            {
                field:"venuesLatitude",
                title:"场馆所在纬度",
                halign:'center',
                align:'center',
                width:150,

            },  {
                field:"openTime",
                title:"营业时间",
                halign:'center',
                align:'center',
                width:150,

                sortable:true
            },  {
                field:"closeTime",
                title:"打样时间",
                halign:'center',
                align:'center',
                width:75,
                sortable:true
            },
            {
                field:"deletestate",
                title:"审核状态",
                halign:'center',
                align:'center',
                width:70,
                formatter:function(value,row,index){
                    if(value==0)
                        return '已审核'
                    else if(value==1)
                        return '未审核'
                    else return '审核不通过'

                },
                sortable:true
            },  {
                field:"cause",
                title:"审核情况",
                halign:'center',
                align:'center',
                width:70,

            },
            {
                field:"brief",
                title:"场馆简介",
                halign:'center',
                align:'center',
                width:70,

            },
               {field:'allocation',
                title:'场馆配置管理',
                width:120,
                align:'center',
                formatter:function(value,row,index){
                var html ="<a href='http://localhost:8080/venuesallcoation/findjspbyvenuesid.action?venuesid="+row.venuesid+"'>配置管理</a>";
                return html;
            }
               }

        ]]
    });

    function add() {
        $('#venuesdialog').dialog({
            href: 'findaddvenues.action',
            left: 300,
            top: 50,
            closed: false,
            modal: true,
            title: "添加信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: function () {
                    //    $('#addStore').dialog('close');
                    var f = $('#venuesdialog').find('#addvenues');
                    f.submit();
                }
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#venuesdialog').dialog('close');
                },

            },

            ]
        });
    }
    function editvenue() {
        //  alert("34")
        var row= $('#venues').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else {
            // alert(row[0].userid);
            $('#venuesdialog').dialog({
                href: 'findeditjsp.action?venuesid='+row[0].venuesid,
                left: 300,
                top: 50,
                closed: false,
                modal: true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function () {
                        //    $('#addStore').dialog('close');
                        var f = $('#venuesdialog').find('#editvenues');
                        f.submit();
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#venuesdialog').dialog('close');
                    }
                }]
            });

        }
    }
    function upload() {
        //  alert("34")
        var row= $('#venues').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else {
            // alert(row[0].userid);
            $('#venuesdialog').dialog({
                href: 'finduploadjsp.action?venuesid='+row[0].venuesid,
                left: 300,
                top: 50,
                closed: false,
                modal: true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function () {
                        //    $('#addStore').dialog('close');
                        var f = $('#venuesdialog').find('#buttom');
                        f.click();
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#venuesdialog').dialog('close');
                    }
                }]
            });

        }
    }
    function audit() {
        //  alert("34")
        var row= $('#venues').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else {
            // alert(row[0].userid);
            $('#venuesdialog').dialog({
                href: 'findauditjsp.action?venuesid='+row[0].venuesid,
                left: 300,
                top: 50,
                closed: false,
                modal: true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function () {
                        //    $('#addStore').dialog('close');
                        var f = $('#venuesdialog').find('#editvenues');
                        f.submit();
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#venuesdialog').dialog('close');
                    }
                }]
            });

        }
    }
//    function remove() {
//        //  alert("34")
//        var row= $('#venues').datagrid('getSelections');
//        if(row==null||row.length!=1){
//            $.messager.alert('提示','请选择要注销的场馆','info');
//        }else if(row[0].deletestate==1){
//            $.messager.alert('提示','已被注销','info');
//        }else  {
//            $.messager.confirm('信息提示','确定要注销该场馆？', function(result){
//                if(result){
//
//                    var id=row[0].venuesid
//                    $.ajax({
//                        url:'cancel.action',
//                        traditional: true,                          //ajax 传送数组
//                        data:{
//                            venuesid:id,
//                        },
//                        success:function(data){
//                            var data=$.parseJSON(data);
//                            if(data.success){
//                                $.messager.alert('信息提示',data.msg,'info');
//                                $("#venues").datagrid('reload');
//                            }
//                            else
//                            {
//                                $.messager.alert('信息提示',data.msg,'info');
//                            }
//                        }
//                    });
//                }
//            });
//
//        }
//    }
    function recharge() {
        //  alert("34")
        var row= $('#user').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要充值的账户','info');
        }else if(row[0].deletestate==1){
            $.messager.alert('提示','该账户被注销，不能充值','info');
        }
        else {
            // alert(row[0].userid);
            $('#userdialog').dialog({
                href: 'findcharge.action?userid='+row[0].userid,
                left: 300,
                top: 50,
                closed: false,
                modal: true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function () {
                        //    $('#addStore').dialog('close');
                        var f = $('#userdialog').find('#chargeuser');
                        f.submit();
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#userdialog').dialog('close');
                    }
                }]
            });

        }
    }
    function cleartext() {
        $('#deletestate').combobox('clear');
        $('#imagecomfirm').combobox('clear');
//        $('#userState').combobox('clear');
//        $('#userAuthority').combobox('clear');
//        $("#userEmail").textbox('setValue','')
    }
    function searchinfo() {
//    "deletestate":'',
//        "userEmail":'',
//        "userState":'',
//        "userAuthority":''
        var deletestate= $("#deletestate").combobox('getValue');
        imagecomfirm
        var image= $("#imagecomfirm").combobox('getValue');
//        var userState= $("#userState").combobox('getValue');
//        var userAuthority= $("#userAuthority").combobox('getValue');
//        var userEmail= $("#userEmail").textbox('getValue');
        $('#venues').datagrid("load",
            {   "deletestate": deletestate,
//                "userState": userState,
//                "userAuthority": userAuthority,
//                "userEmail": userEmail
                "image":image
            });


    }

</script>
</html>

