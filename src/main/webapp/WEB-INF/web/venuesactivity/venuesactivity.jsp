<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/7
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
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
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="场馆活动管理">

    <table id="venueact" toolbar="#acttb" ></table>
    <div id="acttb">
        <table>
            <tr>

                <td>
                    <span style="font-size: small">用户邮箱:</span>
                    <input  class="easyui-textbox" id="userEmail" name="userEmail" data-options="prompt:'用户邮箱'" style="width: 120px" >
                </td>
                <td>
                    <span style="font-size: small">用户手机号:</span>
                    <input  class="easyui-textbox" id="userphone" name="userphone" data-options="prompt:'用户手机号'" style="width: 120px" >
                </td>
                <td>
                    <span style="font-size: small">场馆名:</span>
                    <input  class="easyui-textbox" id="venues" name="venues" data-options="prompt:'保龄球场馆'" style="width: 120px" >
                </td>
                <td>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchinfo()">查询</a>
                </td>
                <td>
                <a href="#" class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="cleartext()">清除文本框</a>
                </td>
                <td>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="finishact()">修改活动状态</a>
                </td>
            </tr>
            <tr>
                <td>
                    <span style="font-size: small">活动状态:</span>
                    <select  class="easyui-combobox" id="userState" name="userState" data-options="panelHeight:'auto'" style="width: 120px" >
                        <option value ="-1">取消</option>
                        <option value ="0">未参加</option>
                        <option value ="1">已参加</option>
                    </select>
                </td>
                <td>
                    <span style="font-size: small">支付状态:</span>
                    <select  class="easyui-combobox" id="paymentState" name="paymentState" data-options="panelHeight:'auto'" style="width: 120px" >
                        <option value ="0">未支付</option>
                        <option value ="1">已支付</option>
                    </select>
                </td>

            </tr>
        </table>


    </div>
    <div id="venuesactdialog" class="easyui-dialog"   data-options="closed:true,iconCls:'icon-save'" style="width:50%; height:80%;padding:10px;">
    </div>
</div>
</body>
<script>
    $('#venues').combogrid({
        panelWidth:450,
        idField:'venuesid',
        textField:'venuesName',
        url:'http://localhost:8080/venues/venuesinfo.action',
        columns:[[
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
        ]]
    });
    $('#venueact').datagrid({
        url : 'allinfoVenuesActivity.action',
        //queryParams:{"mdirid":0,"eid":0},//第一次加载时选择所有基地和所有材料
        idField:'participateVenuesActivieyId',
        iconCls : 'icon-man',
        striped : true,
        fit:true,
        queryParams:{
     //       "deletestate":'',
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
            {field : 'useremail',
                title : '用户邮箱',
                halign:'center',
                formatter:function(value,row,index){
                    return row.user.userEmail
                }

            },
            {field : 'userphone',
                title : '用户手机号',
                halign:'center',
                formatter:function(value,row,index){
                    return row.user.phone
                }

            },
            {field : 'usernamename',
                title : '用户姓名',
                halign:'center',
                formatter:function(value,row,index){
                    return row.user.userTruename
                }

            },
            {
                field:"venuesid",
                title:"场馆名称",
                halign:'center',
                align:'center',
                width:100,
             //   sortable:true,
                formatter:function(value,row,index){
              return row.venues.venuesName
                }
            },
            {
                field:"venuesincharge",
                title:"场馆负责人",
                halign:'center',
                align:'center',
                width:100,
                //   sortable:true,
                formatter:function(value,row,index){
                    return row.venues.userCharge.userTruename
                }
            },
            {
                field:'venuesConfiguration',
                title:'场馆配置',
                halign:'center',
                width:100,
                formatter:function(value,row,index){
                    if(row.venuesAllocation.venuesConfiguration==1){
                        return "豪华厅"
                    }else
                        return "普通厅"
                }
            },
            {
                field : 'createtime',
                title : '订单创建时间',
                align:'center',
                sortable:true,
                width :180,
                formatter:function(value,row,index){
                    if(value==null)
                        return ''
                    else {
                        var unixTimestamp = new Date(value);
                        return unixTimestamp.toLocaleString();
                    }
                }
            },

            {
                field : 'ordertime',
                title : '用户支付时间',
                align:'center',
                width : 180,
                sortable:true,
                formatter:function(value,row,index){
                    if(value==null)
                        return ''
                    else {
                        var unixTimestamp = new Date(value);
                        return unixTimestamp.toLocaleString();
                    }
                }

            }, {
                field : 'finishtime',
                title : '订单完成时间',
                align:'center',
                width : 180,
                sortable:true,
                formatter:function(value,row,index){
                    if(value==null)
                        return ''
                    else {
                        var unixTimestamp = new Date(value);
                        return unixTimestamp.toLocaleString();
                    }

                }

            },
            {
                field:"paymentMoney",
                title:"支付金额",

                align:'center',
                width:100,
            },
            {
                field:"paymentState",
                title:"支付状态",
                align:'center',
                width:100,
                formatter:function(value,row,index){
                    if(value==1)
                        return '已支付'
                    else return '未支付'
                }
            },
            {
                field:"userState",
                title:"用户活动状态",
                align:'center',
                width:100,
                formatter:function(value,row,index){
                    if(value==0)
                        return '未参加'
                    else  if(value==1)
                        return '已参加'
                    else return '取消'
                }
            },

        ]]
    });
    function finishact() {
        //  alert("34")
        var row= $('#venueact').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else if(row[0].userState==1||row[0].userState==-1){
            $.messager.alert('提示','用户已参加或去取消活动','info');
        }else if(row[0].paymentState==0) {
            $.messager.alert('提示','用户还没有付款','info');
        }else {
            // alert(row[0].userid);
            $('#venuesactdialog').dialog({
                href: 'findfinishjsp.action?participateVenuesActivieyId='+row[0].participateVenuesActivieyId,
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
                        var f = $('#venuesactdialog').find('#finish');
                        f.submit();
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#venuesactdialog').dialog('close');
                    }
                }]
            });

        }
    }

//    function recover() {
//        //  alert("34")
//        var row= $('#venues').datagrid('getSelections');
//        if(row==null||row.length!=1){
//            $.messager.alert('提示','请选择要注销的场馆','info');
//        }else if(row[0].deletestate==0){
//            $.messager.alert('提示','无需恢复','info');
//        }
//        else  {
//            $.messager.confirm('信息提示','确定要恢复该场馆？', function(result){
//                if(result){
//
//                    var id=row[0].venuesid
//                    $.ajax({
//                        url:'recover.action',
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
//    function recharge() {
//        //  alert("34")
//        var row= $('#user').datagrid('getSelections');
//        if(row==null||row.length!=1){
//            $.messager.alert('提示','请选择要充值的账户','info');
//        }else if(row[0].deletestate==1){
//            $.messager.alert('提示','该账户被注销，不能充值','info');
//        }
//        else {
//            // alert(row[0].userid);
//            $('#userdialog').dialog({
//                href: 'findcharge.action?userid='+row[0].userid,
//                left: 300,
//                top: 50,
//                closed: false,
//                modal: true,
//                title: "添加信息",
//                buttons: [{
//                    text: '确定',
//                    iconCls: 'icon-ok',
//                    handler: function () {
//                        //    $('#addStore').dialog('close');
//                        var f = $('#userdialog').find('#chargeuser');
//                        f.submit();
//                    }
//                }, {
//                    text: '取消',
//                    iconCls: 'icon-cancel',
//                    handler: function () {
//                        $('#userdialog').dialog('close');
//                    }
//                }]
//            });
//
//        }
//    }
    function cleartext() {
       $("#venues").combogrid('clear');
         $("#userEmail").textbox('clear');
        $("#userphone").textbox('clear');
      $("#paymentState").combobox('clear');
     $("#userState").combobox('clear');
    }
    function searchinfo() {
        var venues= $("#venues").combogrid('getValue');
        var userEmail= $("#userEmail").textbox('getValue');
        var userphone= $("#userphone").textbox('getValue');
        var paymentState= $("#paymentState").combobox('getValue');
        var userState= $("#userState").combobox('getValue');
        $('#venueact').datagrid("load",
            {   "venuesid": venues,
                "userEmail": userEmail,
                "phone": userphone,
                 "userState":userState,
                "paymentState":paymentState
//                "userState": userState,
//                "userAuthority": userAuthority,
//                "userEmail": userEmail
            });


    }

</script>
</html>


