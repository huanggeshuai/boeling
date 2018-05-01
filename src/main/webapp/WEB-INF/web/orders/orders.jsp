<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/10
  Time: 16:15
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
    <script type="text/javascript" src='http://webapi.amap.com/maps?v=1.4.4&key=bee0abe32f405104e257d1b946fc699a&plugin=AMap.ToolBar'></script>

</head>
<body class="easyui-layout">
<div region="center" fit="true" title="交易记录查询">

    <table id="orderinfo" toolbar="#tb" ></table>
    <div id="tb">
        <table>

            <tr>
                <td>
                    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">增加</a>--%>
                    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="editvenueallocation()">修改</a>--%>
                    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="remove()">注销</a>--%>
                    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-recover" plain="true" onclick="recover()">恢复</a>--%>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-back" plain="true" onclick="back()">返回</a>
                    <%--<span style="font-size: small">是否注销:</span>--%>
                    <%--<select  class="easyui-combobox" id="deletestate" name="userAuthority" data-options="panelHeight:'auto'" style="width: 120px" >--%>
                    <%--<option value ="0">未删除</option>--%>
                    <%--<option value ="1">已删除</option>--%>
                    <%--</select>--%>
                    <%--</td>--%>
                    <%--<td>--%>
                    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchinfo()">搜索</a>--%>
                    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="cleartext()">清除文本框</a>--%>

                    <%--</td>--%>
            </tr>

        </table>


    </div>
    <div id="venuesallocationdialog" class="easyui-dialog"   data-options="closed:true,iconCls:'icon-save'" style="width:50%; height:80%;padding:10px;">
    </div>
</div>
</body>
<script>
    $('#orderinfo').datagrid({
        url : 'showallorderinfo.action',
        //queryParams:{"mdirid":0,"eid":0},//第一次加载时选择所有基地和所有材料
        idField:'venuesAllocationId',
        iconCls : 'icon-man',
        striped : true,
        fit:true,
//        queryParams:{
//            "deletestate":'',
//        },
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

                field : 'orderId',
                title : '订单编号',
                halign:'center',

            },
            {
                field:'userid',
                title:'用户',
                halign:'center',
                align:'center',
                width:100,
                formatter:function(value,row,index){
                    return row.user.userTruename

                }
            },
            {
                field:'incomeState',
                title:'支付/收入',
                halign:'center',
                width:100,
                sortable:true,
                formatter:function(value,row,index){
                    if(row.incomeState==1){
                        return  '<span style="color:red">'+'收入'+'</span>'
                    }else
                        return "支付"
                }
            },
            {
                field:'money',
                title:'金额',
                halign:'center',
                width:80,
                sortable:true
//                formatter:function(value,row,index){
//                    if(row.venuesAllocationState==1)
//                        return "租用"
//                    else if(row.venuesAllocationState==2)
//                        return "正在使用"
//                    else if(row.venuesAllocationState==3)
//                        return "闲置"
//                }
            },
           {
                field:"incomeUserId",
                title:"收款方/付款方",
                halign:'center',
                align:'center',
                width:100,

                formatter:function(value,row,index){
                    return row.incomeUser.userTruename

                }
            },
            {
                field:"medium",
                title:"支付手段",
                halign:'center',
                align:'center',
                width:100,
                sortable:true,
                formatter:function(value,row,index){
                    if(row.medium==1)
                    return '账户支付'
                    else if (row.medium==2)
                        return '银行卡支付'
                    else if (row.medium==3)
                        return '平台支付'
                }
            },
            {
                field:"time",
                title:"支付时间",
                halign:'center',
                align:'center',
                width:170,
                sortable:true
            },
            {
                field : 'cause',
                title : '订单详情',
                halign:'center',
                width : 200,
//                formatter:function(value,row,index){
//                    return row.feeScale+"元每小时"
//
//                }

            },

        ]]
    });
    function add() {
        $('#venuesallocationdialog').dialog({
            href: 'findaddvenuesallocationjsp.action',
            left: 300,
            top: 50,
            closed: false,
            title: "添加信息",
            resizable:true,
            collapsible:true,
            minimizable:true,
            maximizable:true,
            //  maximized:true,
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: function () {
                    //    $('#addStore').dialog('close');
                    var f = $('#venuesallocationdialog').find('#addvenuesallocation');
                    f.submit();
                }
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#venuesallocationdialog').dialog('close');
                },

            },

            ]
        });
    }
    function back() {
        window.location.href= "http://localhost:8080/user/showuserjsp.action"
    }
    function editvenueallocation() {
        //  alert("34")
        var row= $('#venuesallocation').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else {
            // alert(row[0].userid);
            $('#venuesallocationdialog').dialog({
                href: 'findeditvenuesallocationjsp.action?venuesAllocationId='+row[0].venuesAllocationId,
                left: 300,
                top: 50,
                closed: false,
                resizable:true,
                collapsible:true,
                minimizable:true,
                maximizable:true,
                //    maximized:true,
                title: "添加信息",
                buttons: [{
                    text: '确定',
                    iconCls: 'icon-ok',
                    handler: function () {
                        //    $('#addStore').dialog('close');
                        var f = $('#venuesallocationdialog').find('#editvenuesallocation');
                        f.submit();
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#venuesallocationdialog').dialog('close');
                    }
                }]
            });

        }
    }

    function recover() {
        //  alert("34")
        var row= $('#venues').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要注销的场馆','info');
        }else if(row[0].deletestate==0){
            $.messager.alert('提示','无需恢复','info');
        }
        else  {
            $.messager.confirm('信息提示','确定要恢复该场馆？', function(result){
                if(result){

                    var id=row[0].venuesid
                    $.ajax({
                        url:'recover.action',
                        traditional: true,                          //ajax 传送数组
                        data:{
                            venuesid:id,
                        },
                        success:function(data){
                            var data=$.parseJSON(data);
                            if(data.success){
                                $.messager.alert('信息提示',data.msg,'info');
                                $("#venues").datagrid('reload');
                            }
                            else
                            {
                                $.messager.alert('信息提示',data.msg,'info');
                            }
                        }
                    });
                }
            });

        }
    }
    function remove() {
        //  alert("34")
        var row= $('#venues').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要注销的场馆','info');
        }else if(row[0].deletestate==1){
            $.messager.alert('提示','已被注销','info');
        }else  {
            $.messager.confirm('信息提示','确定要注销该场馆？', function(result){
                if(result){

                    var id=row[0].venuesid
                    $.ajax({
                        url:'cancel.action',
                        traditional: true,                          //ajax 传送数组
                        data:{
                            venuesid:id,
                        },
                        success:function(data){
                            var data=$.parseJSON(data);
                            if(data.success){
                                $.messager.alert('信息提示',data.msg,'info');
                                $("#venues").datagrid('reload');
                            }
                            else
                            {
                                $.messager.alert('信息提示',data.msg,'info');
                            }
                        }
                    });
                }
            });

        }
    }
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
//        var userState= $("#userState").combobox('getValue');
//        var userAuthority= $("#userAuthority").combobox('getValue');
//        var userEmail= $("#userEmail").textbox('getValue');
        $('#venues').datagrid("load",
            {   "deletestate": deletestate,
//                "userState": userState,
//                "userAuthority": userAuthority,
//                "userEmail": userEmail
            });


    }

</script>
</html>



