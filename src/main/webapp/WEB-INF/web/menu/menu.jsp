<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/3/29
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
<div region="center" fit="true" title="目录管理">

    <table id="dirlist" toolbar="#tb"></table>
    <div id="tb">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">增加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="edit()">修改</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="remove()">删除</a>

    </div>
    <div id="menu"  data-options="closed:true,iconCls:'icon-save'" style="width:400px; padding:10px;">
    </div>
</div>

<%--<table data-toggle="topjui-treegrid"--%>
       <%--data-options="id:'menuTg',--%>
        <%--idField:'id',--%>
        <%--treeField:'text',--%>
        <%--url:'menu/rootmenu.action',--%>
        <%--expandUrl:'menu/lookmenu.action?pid={id}',--%>
        <%--fitColumns:true,--%>
        <%--contextMenu:{id:'tgcm'}">--%>
    <%--<thead>--%>
    <%--<tr>--%>
        <%--<!--<th data-options="field:'miad',title:'bianhao',checkbox:true"></th>-->--%>
        <%--<th data-options="field:'mid',title:'编号',checkbox:true"></th>--%>
        <%--<th data-options="field:'text',title:'名称',width:50"></th>--%>
        <%--<th data-options="field:'pid',title:'父级编号',width:50"></th>--%>
        <%--<th data-options="field:'id',title:'子编号'"></th>--%>
        <%--<th data-options="field:'url',title:'资源所在地址',width:50"></th>--%>
    <%--</tr>--%>
    <%--</thead>--%>
<%--</table>--%>

<!-- 表格工具栏开始 -->
<%--<div id="menuTg-toolbar" class="topjui-toolbar"--%>
     <%--data-options="grid:{--%>
           <%--type:'treegrid',--%>
           <%--id:'menuTg',--%>
           <%--parentIdField:'pid'--%>
       <%--}">--%>
    <%--<a id="addmenu" href="javascript:void(0)">新增</a>--%>
    <%--<a id="editmenu" href="javascript:void(0)">编辑</a>--%>
    <%--<a id="deletemenu" href="#" onclick="remove()">删除</a>--%>

    <%--<!--<a id="delete" hrefu="javascript:void(0)">删除</a>-->--%>
<%--</div>--%>
<!-- 表格工具栏结束 -->
</body>
<script>

    $("#dirlist").treegrid({
        url : 'allmenu.action',
        method:'post',
        idField : 'id',
        treeField : 'text',
        fit:true,
        animate: true,
        collapsible: false,
        fitColumns: true,
        lines:true,
        columns : [[
            {
                field : 'text',
                title : '目录标题',
                width : 150,
            },
            {
                //
                field : 'id',
                title : 'id',
                width : 80,


            },
            {
                field : 'state',
                title : '是否存在下一级目录',
                width : 80,
                formatter: function(value,row){
                    if (value=='closed'){
                        return '是';
                    } else if(value=='open') {
                        return '否';
                    }
                }
            },

            {
                field : 'url',
                title : '目录所在资源',
                width : 200,
            },
            {
                field : 'parentid',
                title : '上级父菜单',
                width : 80,
            },
            {
                field : 'createtime',
                title : '创建时间',
                width : 200,
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
                field : 'edittime',
                title : '修改时间',
                width : 200,
                formatter:function(value,row,index){
                    if(value==null)
                        return ''
                    else {
                        var unixTimestamp = new Date(value);
                        return unixTimestamp.toLocaleString();
                    }

                }

            },
        ]]

    });
 // var  row =   $("#dirlist").treegrid('getParent') ;
   function add() {
       var row = $("#dirlist").treegrid('getSelected');
       if (row == null) {
           $.messager.alert('提示', '请选中数据', 'warning');
       }
       if (row.state == 'open') {
           $.messager.alert('提示', '请选中父级目录', 'warning');
       } else if (row.state == 'closed') {
           // $.messager.alert('提示','正确','info');

           $('#menu').dialog({
               href: 'findaddmenu.action?mid='+row.mid,
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
                       var f = $('#menu').find('#addmenu');
                       f.submit();
                   }
               }, {
                   text: '取消',
                   iconCls: 'icon-cancel',
                   handler: function () {
                       $('#menu').dialog('close');
                   }
               }]
           });
       }



   }

    function edit() {
        var row = $("#dirlist").treegrid('getSelected');
        if (row == null) {
            $.messager.alert('提示', '请选择要修改的数据', 'warning');
        }
         else  {
            // $.messager.alert('提示','正确','info');

            $('#menu').dialog({
                href: 'findeditmenu.action?mid='+row.mid,
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
                        var f = $('#menu').find('#editmenu');
                        f.submit();
                    }
                }, {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        $('#menu').dialog('close');
                    }
                }]
            });
        }



    }

    function remove(){
        var row = $("#dirlist").treegrid('getSelected');
        //var id=row.id
        if (row == null) {
            $.messager.alert('提示', '请选择要删除的目录', 'warning');
        }else if(row.id==1325){
            $.messager.alert('提示', '这是根目录，不能删除', 'warning');
        } else{
            $.messager.confirm('信息提示','确定要删除该记录？', function(result){
                if(result){

                    var id=row.id
                    $.ajax({
                        url:'delnode.action',
                        traditional: true,                          //ajax 传送数组
                        data:{
                            id:id,
                        },
                        success:function(data){
                            var data=$.parseJSON(data);
                            if(data.success){
                                $.messager.alert('信息提示',data.msg,'info');
                                $("#dirlist").treegrid('reload');
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

























  //    alert($('#dirlist').treegrid('isLeaf',node.target))

  //  dirlist.treegrid("expandAll");
//    var menuTg = {
//        type: 'treegrid',
//        id: 'menuTg'
//    };
//    $("#addmenu").iMenubutton({
//        event: 'openDialog',
//        iconCls: 'fa fa-plus',
//        dialog: {
//            id: 'userAddDialog',
//            height: 350,
//            href: _ctx + '/html/complex/dialog_add.html',
//            buttonsGroup: [
//                {
//                    text: '保存',
//                    url: _ctx + '/json/response/success.json',
//                    iconCls: 'fa fa-plus',
//                    handler: 'ajaxForm',
//                    btnCls: 'topjui-btn-normal'
//                }
//            ]
//        }
//    });
//
//    $("#editmenu").iMenubutton({
//        event: 'openDialog',
//        iconCls: 'fa fa-pencil',
//        btnCls: 'topjui-btn',
//        grid: menuTg,
//        dialog: {
//            width: 950,
//            height: 500,
//            href: _ctx + '/html/complex/dialog_edit.html?uuid={uuid}',
//            url: _ctx + '/json/product/detail.json?uuid={uuid}',
//            buttonsGroup: [
//                {
//                    text: '更新',
//                    url: _ctx + '/json/response/success.json',
//                    iconCls: 'fa fa-save',
//                    handler: 'ajaxForm',
//                    btnCls: 'topjui-btn'
//                }
//            ]
//        }
//    });
//
//    $("#deletemenu").iMenubutton({
//
//        event: 'doAjax',
//        iconCls: 'fa fa-trash',
//        btnCls: 'topjui-btn-normal',
//        // confirmMsg: '这个是勾选复选框实现多条数据的Ajax删除提交操作，提交grid.param中指定的参数值',
//        grid: {
//            type: 'treegrid',
//            id: 'menuTg',
//            uncheckedMsg: '请先勾选要删除的数据',
//            param: 'mid:mid'
//        },
//
//        //   url: _ctx + '/json/response/success.json'
//    });
//    function remove() {
//
//        var $checkElems = $("input[name='mid']:checked");
//        if($checkElems.size()==0){
//            $.messager.alert('信息提示','请选择要删除的行数','info');
//            return;
//        }
//        var Ids = new Array();
//        $checkElems.each(function(){
//            Ids.push($(this).val());
//        });
////        for(var i=0;i<Ids.length;i++){
////            alert(Ids[i]);
////        }
//        //  var node = $('#menuTg').treegrid('getSelections');
//        $.ajax({
//            url:'menu/delmenu.action',
//            traditional: true,                          //ajax 传送数组
//            data:{
//                mids:Ids,
//            },
//            success:function(data){
//                var data=$.parseJSON(data);
//                if(data.success){
//                    $.messager.alert('信息提示',data.msg,'info');
//                    //    $('#addStore').dialog.openner_dataGrid = $('#store_data').datagrid();//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
//                }
//                else
//                {
//                    $.messager.alert('信息提示',data.msg,'info');
//                }
//            }
//        });
//        /*
//         alert(node.length)*/
////        if(node.length==0){
////            $.messager.alert('信息提示','请选择要删除的行数','info');
////        }else{
////            $.messager.confirm('信息提示','确定要删除该记录？', function(result){
////                if(result){
////
////                    var stores = [];
////                    for (var i=0;i<items.length;i++){
////                        stores[i]=items[i].storeid;
////                    }
////                    //alert(ids);return;
////                    $.ajax({
////                        url:'store/deleteBystoreid.action',
////                        traditional: true,                          //ajax 传送数组
////                        data:{
////                            stores:stores,
////                        },
////                        success:function(data){
////                            var data=$.parseJSON(data);
////                            if(data.success){
////                                $.messager.alert('信息提示',data.msg,'info');
////                                $('#addStore').dialog.openner_dataGrid = $('#store_data').datagrid();//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
////                            }
////                            else
////                            {
////                                $.messager.alert('信息提示',data.msg,'info');
////                            }
////                        }
////                    });
////                }
////            });
//        //       }
//
//    }
//    //

</script>
</html>
