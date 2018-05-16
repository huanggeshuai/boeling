<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/3/31
  Time: 13:43
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
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="用户管理">

    <table id="user" toolbar="#usertb" ></table>
    <div id="usertb">
         <table>

             <tr>
                 <td>
                     <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">增加</a>
                     <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="edituser()">修改</a>
                     <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="remove()">注销</a>
                     <a href="#" class="easyui-linkbutton" iconCls="icon-charge" plain="true" onclick="recharge()">充值</a>
                     <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editpwd()">修改密码</a>
                     <span style="font-size: small">用户权限:</span>
                     <select  class="easyui-combobox" id="userAuthority" name="userAuthority" data-options="panelHeight:'auto'" style="width: 120px" >
                         <option value ="3">用户</option>
                         <option value ="2">馆长</option>
                         <option value ="1">管理员</option>
                     </select>
                 </td>
                 <td>
                     <a href="exportuserinfo.action" class="easyui-linkbutton" iconCls="icon-export" plain="true">导出信息</a>


                     <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchinfo()">搜索</a>
                     <a href="#" class="easyui-linkbutton" iconCls="icon-clear" plain="true" onclick="cleartext()">清除文本框</a>

                 </td>
             </tr>
             <tr>
             <td>
                 <span style="font-size: small">用户状态:</span>
                 <select  class="easyui-combobox" id="userState" name="userState" data-options="panelHeight:'auto'" style="width: 120px" >
                     <option value ="0">可用</option>
                     <option value ="1">禁用</option>
                 </select>

                 <span style="font-size: small">是否注销:</span>
                 <select  class="easyui-combobox" id="deletestate" name="userAuthority" data-options="panelHeight:'auto'" style="width: 120px" >
                     <option value ="0">未删除</option>
                     <option value ="1">已删除</option>
                 </select>


                 <span style="font-size: small">用户邮箱:</span>
                 <input  class="easyui-textbox" id="userEmail" name="userEmail" data-options="prompt:'模糊查询'" style="width: 120px" >
                 </input>
             </td>
              </tr>
         </table>


    </div>
    <div id="userdialog"  data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
    </div>
</div>
</body>
<script>
    $('#user').datagrid({
        url : 'showalluser.action',
        //queryParams:{"mdirid":0,"eid":0},//第一次加载时选择所有基地和所有材料
        idField:'userid',
        iconCls : 'icon-man',
        striped : true,
        fit:true,
        queryParams:{
            "deletestate":'',
            "userEmail":'',
            "userState":'',
            "userAuthority":''
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

                field : 'userid',
                title : '编号',
                halign:'center',
            },
            {
                field:'userNickname',
                title:'用户昵称',
                halign:'center',
                width:100
            },
            {
                field:'userTruename',
                title:'用户真实姓名',
                halign:'center',
                width:80
            },
            {
                field : 'userEmail',
                title : '用户邮箱',
                halign:'center',
                width : 150,
            },
            {
                field:"phone",
                title:"手机号码",
                halign:'center',
                align:'center',
                width:70,
            },
            {
                field:"userPassword",
                title:"用户密码",
                halign:'center',
                align:'center',
                width:100,
            },
            {
                field:"userPaypassword",
                title:"用户支付密码",
                halign:'center',
                align:'center',
                width:100,
            },
            {
                field:"userBalance",
                title:"用户积分",
                halign:'center',
                align:'center',
                width:100,
                sortable:true
            },
            {
                field:"userResignDate",
                title:"用户注册日期",
                halign:'center',
                align:'center',
                width:150,
                formatter:function(value,row,index){
                    if(value==null)
                        return ''
                    else {
                        var unixTimestamp = new Date(value);
                        return unixTimestamp.toLocaleString();
                    }

                },
                sortable:true
            },  {
                field:"userLoginDate",
                title:"用户登入时间",
                halign:'center',
                align:'center',
                width:150,
                formatter:function(value,row,index){
                    if(value==null)
                        return ''
                    else {
                        var unixTimestamp = new Date(value);
                        return unixTimestamp.toLocaleString();
                    }

                },
                sortable:true
            },  {
                field:"userLoginCount",
                title:"用户登入次数",
                halign:'center',
                align:'center',
                width:75,
                sortable:true
            },  {
                field:"userAuthority",
                title:"用户权限",
                halign:'center',
                align:'center',
                width:70,
                formatter:function(value,row,index){
                    if(value==1)
                        return '管理员'
                    else if(value==2)
                        return '馆长'
                    else return '用户'

                }
            },
            {
                field:"userState",
                title:"用户状态",
                halign:'center',
                align:'center',
                width:70,
                formatter:function(value,row,index){
                    if(value==0)
                        return '可用'
                    else return '禁用'

                }
            },
            {
                field:"userDrive",
                title:"用户设备",
                halign:'center',
                align:'center',
                width:70,
            },
            {field:"deletestate",
                title:"是否注销",
                halign:'center',
                align:'center',
                width:70,
                formatter:function(value,row,index){
                if(value==0)
                    return '否'
                    else return '是'
                }
            },
            {field:'allocation',
                title:'消费记录管理',
                width:120,
                align:'center',
                formatter:function(value,row,index){
                    var html ="<a href='http://localhost:8080/orders/findorderjsp.action?userid="+row.userid+"'>交易管理</a>";
                    return html;
                }
            }
        ]]
    });
function add() {
    $('#userdialog').dialog({
        href: 'showadduserjsp.action',
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
                var f = $('#userdialog').find('#adduser');
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
    function edituser() {
      //  alert("34")
        var row= $('#user').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else {
           // alert(row[0].userid);
            $('#userdialog').dialog({
                href: 'findedituser.action?userid='+row[0].userid,
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
                        var f = $('#userdialog').find('#edituser');
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
    function editpwd() {
        //  alert("34")
        var row= $('#user').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else {
            // alert(row[0].userid);
            $('#userdialog').dialog({
                href: 'findpassworduser.action?userid='+row[0].userid,
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
                        var f = $('#userdialog').find('#edituserpwd');
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
    function remove() {
        //  alert("34")
        var row= $('#user').datagrid('getSelections');
        if(row==null||row.length!=1){
            $.messager.alert('提示','请选择要修改的行数','info');
        }else {
            $.messager.confirm('信息提示','确定要删除该记录？', function(result){
                if(result){

                    var id=row[0].userid
                    $.ajax({
                        url:'deluser.action',
                        traditional: true,                          //ajax 传送数组
                        data:{
                            userid:id,
                        },
                        success:function(data){
                            var data=$.parseJSON(data);
                            if(data.success){
                                $.messager.alert('信息提示',data.msg,'info');
                                $("#user").datagrid('reload');
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
        $('#userState').combobox('clear');
        $('#userAuthority').combobox('clear');
        $("#userEmail").textbox('setValue','')
    }
function searchinfo() {
//    "deletestate":'',
//        "userEmail":'',
//        "userState":'',
//        "userAuthority":''
    var deletestate= $("#deletestate").combobox('getValue');
    var userState= $("#userState").combobox('getValue');
    var userAuthority= $("#userAuthority").combobox('getValue');
    var userEmail= $("#userEmail").textbox('getValue');
    $('#user').datagrid("load",
        {   "deletestate": deletestate,
            "userState": userState,
            "userAuthority": userAuthority,
            "userEmail": userEmail
        });


}
    function exportexcel() {
href:""


    }
</script>
</html>
