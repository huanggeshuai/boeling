<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/9
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<div class="easyui-layout" data-options="fit:true"  style="width:400px; height:300px;padding:10px;">
    <form id="finish" method="post">
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >用户邮箱状态</td>
                <input class="easyui-validatebox" type="text" id="username" name="username"
                       data-options="required:true"
                       style="width: 150px "  value='${participateVenuesActivitiey.user.userEmail}'  disabled="disabled" />
            </tr>
        </div>

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >使用状态</td>
                <select name="userState" class="easyui-combobox" id="userState" type="text"  style="width: 120px " data-options="panelHeight:'auto'" >
                    <option value="1">已参加</option>
                    <option value="0">未参加</option>
                </select>
            </tr>
        </div>
    </form>
</div>
<script type="text/javascript">
    $('#userState').combobox({
        value:'${participateVenuesActivitiey.userState}'
    })
    $('#finish').form({
        url:"editFinishtime.action?participateVenuesActivieyId="+${participateVenuesActivitiey.participateVenuesActivieyId},
        onSubmit: function(){
            if(!$("#finish").form("validate")){
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
                $('#venuesactdialog').dialog('close')
                //  parent.document.getElecmentById("#win").dialog('close');
//                        var v=$('#edit').find('#win');
//                        v.dialog('close')
                // $('#menu').dialog.openner_dataGrid = $('#goods_date').datagrid();//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                $("#venueact").datagrid('reload');
                //$("#RightAccordion").iAccordion('panels');
                // location.reload(force)
            }else {
                parent.$.messager.alert('错误', result.msg, 'error');
            }
        }
    });

</script>

