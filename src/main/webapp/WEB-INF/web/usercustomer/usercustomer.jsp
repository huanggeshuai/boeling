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
<div region="center" fit="true" title="自定义活动管理">

    <table id="usercustomeract" toolbar="#acttb" ></table>
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
                    <input  class="easyui-textbox" id="venuesact" name="venues" data-options="prompt:'保龄球场馆'" style="width: 120px" >
                </td>
                <td>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchinfo()">查询</a>
                </td>
                <td>
                <a href="#" class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="cleartext()">清除文本框</a>
                </td>
                <td>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="auditingact()">审核活动</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-large-picture" plain="true" onclick="upload()">查看图片</a>
                </td>
            </tr>
            <tr>
                <td>
                    <span style="font-size: small">活动状态:</span>
                    <select  class="easyui-combobox" id="auditing" name="auditing" data-options="panelHeight:'auto'" style="width: 120px" >
                        <option value ="0">未审核</option>
                        <option value ="1">已审核</option>
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
    <div id="useractcustomerdialog" class="easyui-dialog"   data-options="closed:true,iconCls:'icon-save'" style="width:300px; height:400px;padding:10px;">
    </div>
</div>
</body>
<script>
    $('#venuesact').combogrid({
        panelWidth:450,
        idField:'venuesid',
        textField:'venuesName',
        pagination: true,
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

    $('#usercustomeract').datagrid({
        url : 'allinfoweb.action',
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
            {field : 'activityname',
                title : '活动名称',
                halign:'center',
            },
            {field : 'detailinfo',
                title : '活动详情',
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
                field : 'activitiesSettingTime',
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
                },
                sortable:true,
            },
            {
                field : 'createtime',
                title : '审核时间',
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
                },
                sortable:true,
            },
            {  sortable:true,
                field : 'enlistStartTime',
                title : '报名开始时间',
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
                field : 'enlistStopTime',
                title : '报名结束时间',
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
                field : 'activitiesStartTime',
                title : '活动开始时间',
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
                field : 'activitiesStopTime',
                title : '活动结束时间',
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
                field:"paymentmoney",
                title:"支付金额",
                align:'center',
                width:100,
                sortable:true,

            },
            {
                field:"userpay",
                title:"参加活动所需金额",
                align:'center',
                width:100,
                sortable:true,

            },
            {
                field:"total",
                title:"活动参加人数",
                align:'center',
                width:100,
                sortable:true,

            },
            {
                field:"enlistnum",
                title:"活动报名人数",
                align:'center',
                width:100,
                sortable:true,

            },
            {
                field:"payState",
                title:"支付状态",
                align:'center',
                sortable:true,

                width:100,
                formatter:function(value,row,index){
                    if(value==1)
                        return '已支付'
                    else return '未支付'
                }
            },
            {
                field:"auditing",
                title:"审核状态",
                align:'center',
                sortable:true,

                width:100,
                formatter:function(value,row,index){
                    if(value==0)
                        return '未审核'
                    else  if(value==1)
                        return '已审核'
                    else return '取消'
                }
            },
            {
                field:"cause",
                title:"审核说明",
                align:'center',
                width:100,
            },

        ]]
    });

function upload() {
    //  alert("34")
    var row= $('#usercustomeract').datagrid('getSelections');
    if(row==null||row.length!=1){
        $.messager.alert('提示','请选择要查看图片的活动','info');
    }else {
        // alert(row[0].userid);
        $('#useractcustomerdialog').dialog({
            href: 'http://localhost:8080/usercustomer/findimage.action?userCustomActivityId='+row[0].userCustomActivityId,
            left: 300,
            top: 50,
            closed: false,
            modal: true,
            title: "添加信息",
            buttons: [{
                text: '确定',
                iconCls: 'icon-ok',
                handler: function () {
                    $('#useractcustomerdialog').dialog('close');
                }
            }, {
                text: '取消',
                iconCls: 'icon-cancel',
                handler: function () {
                    $('#useractcustomerdialog').dialog('close');
                }
            }]
        });

    }
}
    function auditingact() {
        //  alert("34")
        var row= $('#usercustomeract').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else if(row[0].auditing ==1){
            $.messager.alert('提示','该活动已审核','info');
        } else if(row[0].payState ==0){
            $.messager.alert('提示','用户没有支付，不能审核','info');
        }
        else {
            // alert(row[0].userid);
            $('#useractcustomerdialog').dialog({
                href: 'findauditingjsp.action?userCustomActivityId='+row[0].userCustomActivityId,
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
                        var f = $('#useractcustomerdialog').find('#auditinguser');
                        f.submit();
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#useractcustomerdialog').dialog('close');
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
       $("#venuesact").combogrid('clear');
         $("#userEmail").textbox('clear');
        $("#userphone").textbox('clear');
      $("#paymentState").combobox('clear');
     $("#auditing").combobox('clear');
    }
    function searchinfo() {
        var venues= $("#venuesact").combogrid('getValue');
        var userEmail= $("#userEmail").textbox('getValue');
        var userphone= $("#userphone").textbox('getValue');
        var paymentState= $("#paymentState").combobox('getValue');
        var auditing= $("#auditing").combobox('getValue');
        $('#usercustomeract').datagrid("load",
            {   "venuesid": venues,
                "userEmail": userEmail,
                "phone": userphone,
                 "auditing":auditing,
                "payState":paymentState
//                "userState": userState,
//                "userAuthority": userAuthority,
//                "userEmail": userEmail
            });


    }

</script>
</html>


