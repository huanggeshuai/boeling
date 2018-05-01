<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/9
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<div class="easyui-layout" data-options="fit:true"  style="width:400px; height:300px;padding:10px;">
    <form id="auditinguser" method="post">
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >用户邮箱状态</td>
                <input class="easyui-validatebox" type="text" id="username" name="username"
                       data-options="required:true"
                       style="width: 150px "  value='${userCustomActivityauditing.user.userEmail}'  disabled="disabled" />
            </tr>
        </div>

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >审核状态</td>
                <select name="auditing" class="easyui-combobox" id="user_State" type="text"  style="width: 120px " data-options="panelHeight:'auto'" >
                    <option value="1">已审核</option>
                    <option value="0">未审核</option>
                </select>
            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >审核状态</td>
                <input  type="text" id="cause" name="cause" class="easyui-textbox" data-options="required:true,multiline:true"  />
            </tr>
        </div>
    </form>
</div>
<script type="text/javascript">
    $('#user_State').combobox({
        value:'${userCustomActivityauditing.auditing}'
    })
    $('#auditinguser').form({
        url:"auditact.action?userCustomActivityId="+${userCustomActivityauditing.userCustomActivityId},
        onSubmit: function(){
            if(!$("#auditinguser").form("validate")){
                $.messager.show({
                    title:'提示信息' ,
                    msg:'内容不能为空!'
                });
                return false;
            }
            return true;
        },
        success:function(data){
            var result=$.parseJSON(data);
            if(result.success){
                parent.$.messager.alert('提示', result.msg, 'info');
                //   parent.$.dialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为student.jsp页面预定义好了
                // parent.$.dialog.handler.dialog('close');
                $('#useractcustomerdialog').dialog('close')
                //  parent.document.getElecmentById("#win").dialog('close');
//                        var v=$('#edit').find('#win');
//                        v.dialog('close')
                // $('#menu').dialog.openner_dataGrid = $('#goods_date').datagrid();//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                $("#usercustomeract").datagrid('reload');
                //$("#RightAccordion").iAccordion('panels');
                // location.reload(force)
            }else {
                parent.$.messager.alert('错误', result.msg, 'error');
            }
        }
    });

</script>

