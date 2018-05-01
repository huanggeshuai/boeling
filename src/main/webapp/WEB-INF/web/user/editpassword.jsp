<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/1
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<div class="easyui-layout" data-options="fit:true"  style="width:400px; padding:10px;">
    <form id="edituserpwd" method="post">

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >旧密码</td>
                <input class="easyui-validatebox" type="password" id="oldPassword" name="olduserPassword" data-options="required:true,validType:['password']"   />
            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >新密码</td>
                <input class="easyui-validatebox" type="password" id="newuserPassword" name="newuserPassword" data-options="required:true"   />
            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >在确认</td>
                <input class="easyui-validatebox" type="password" id="userPassword" name="userPassword" data-options="required:true,validType:['equalTo']"   />
            </tr>
        </div>
    </form>
</div>
<script type="text/javascript">
    $('#edituserpwd').form({
        url:"edituser.action?userid="+${user.userid},
        onSubmit: function(){
            if(!$("#edituserpwd").form("validate")){
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
            message: 'Please enter your mobile phone number correct.'
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
        password:{
            validator: function (value) {
                var id = $("#oldPassword").val().trim();
                var flag

                var haha = " ";
                $.ajax({
                    type : 'post',
                    async : false,
                    url : 'verifypassword.action?userid='+${user.userid},
                    data : {
                        "userPassword" : id
                    },
                    success : function(data) {
                        var result=$.parseJSON(data);
                        flag= result.success;
                    }
                });
                return flag;
            },
            message : '与旧密码不匹配'
        },
        equalTo: {
            validator:
                function (value, param) {
                return $("#newuserPassword").val() == value;
                },
            message: '前后密码不匹配' }
    })
</script>
