<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/3/31
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<div class="easyui-layout" data-options="fit:true"  style="width:400px; padding:10px;">
    <form id="adduser" method="post">

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >用户邮箱</td>
                <input class="easyui-validatebox" type="text" id="user_Email" name="userEmail" data-options="required:true,validType:['email','emailisOnly']"  />
            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >手机号码</td>
                <input class="easyui-validatebox" type="text" id="user_phone" name="phone" data-options="required:true,validType:['Mobile','phoneisOnly']"  />
            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >用户密码</td>
                <input class="easyui-validatebox" value="root" type="text" id="userPassword" name="userPassword" data-options="required:true" />
            </tr>
        </div>

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right"  >用户权限</td>
                <select  class="easyui-combobox" id="userAuthority" name="userAuthority" data-options="panelHeight:'auto'" >
                    <option value ="3">用户</option>
                    <option value ="2">馆长</option>
                    <option value ="1">管理员</option>


                </select>
            </tr>
        </div>

    </form>
</div>
<script type="text/javascript">
    $('#adduser').form({
        url:"adduser.action",
        onSubmit: function(){
            if(!$("#adduser").form("validate")){
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
                $('#userdialog').dialog('close')
                //  parent.document.getElecmentById("#win").dialog('close');
//                        var v=$('#edit').find('#win');
//                        v.dialog('close')
                // $('#menu').dialog.openner_dataGrid = $('#goods_date').datagrid();//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                $("#user").datagrid('reload');
                //$("#RightAccordion").iAccordion('panels');
                // location.reload(force)
            }else {
                parent.$.messager.alert('错误', result.msg, 'error');
            }
        }
    });
    $.extend($.fn.validatebox.defaults.rules, {
        //验证汉字
        CHS: {
            validator: function (value) {
                return /^[\u0391-\uFFE5]+$/.test(value);
            },
            message: 'The input Chinese characters only.'
        },
        //移动手机号码验证
        Mobile: {//value值为文本框中的值
            validator: function (value) {
                var reg = /^1[3|4|5|8|9]\d{9}$/;
                return reg.test(value);
            },
            message: '请输入正确的手机号码'
        },
        //国内邮编验证
        ZipCode: {
            validator: function (value) {
                var reg = /^[0-9]\d{5}$/;
                return reg.test(value);
            },
            message: 'The zip code must be 6 digits and 0 began.'
        },
        //数字
        Number: {
            validator: function (value) {
                var reg =/^[0-9]*$/;
                return reg.test(value);
            },
            message: '请输入数字'
        },

        emailisOnly:{
            validator: function (value) {
                var id = $("#user_Email").val().trim();
                var flag

                var haha = " ";
                $.ajax({
                    type : 'post',
                    async : false,
                    url : 'emailisonly.action',
                    data : {
                        "userEmail" : id
                    },
                    success : function(data) {
                        var result=$.parseJSON(data);
                        flag= result.success;
                    }
                });
                return flag;
            },
            message : '该email存在'
        },
        phoneisOnly:{
        validator: function (value) {
            var id = $("#user_phone").val().trim();
            var flag

            var haha = " ";
            $.ajax({
                type : 'post',
                async : false,
                url : 'phoneisonly.action',
                data : {
                    "phone" : id
                },
                success : function(data) {
                    var result=$.parseJSON(data);
                    flag= result.success;
                }
            });
            return flag;
        },
        message : '该手机号码存在'
    }
    })
</script>
