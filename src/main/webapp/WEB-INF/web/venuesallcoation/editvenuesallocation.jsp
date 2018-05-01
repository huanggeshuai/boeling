<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/9
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<div class="easyui-layout" data-options="fit:true"  style="width:400px; height:300px;padding:10px;">
    <form id="editvenuesallocation" method="post">
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >场馆负责人</td>
                <input class="easyui-validatebox" type="text" id="venuesid" name="venuesid"
                       data-options="required:true"
                       style="width: 120px "  value='${venuesAllocation.venues.userCharge.userTruename}' disabled="disabled" />
            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >场馆配置</td>
                <select name="venuesConfiguration" class="easyui-combobox" id="venuesConfiguration" type="text"  style="width: 120px " data-options="panelHeight:'auto'" >
                    <option value="1">豪华厅</option>
                    <option value="2">普通厅</option>
                </select>
            </tr>
        </div>

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >使用状态</td>
                <select name="venuesAllocationState" class="easyui-combobox" id="venuesAllocationState" type="text"  style="width: 120px " data-options="panelHeight:'auto'" >
                    <option value="1">租用</option>
                    <option value="2">使用</option>
                    <option value="3">闲置</option>
                </select>
            </tr>
        </div>

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >收费标准</td>

                <input class="easyui-validatebox" type="text"  id="feeScale" name="feeScale"
                       data-options="required:true,validType:['money']" value='${venuesAllocation.feeScale}'
                       style="width: 120px "/>
                <td width="60" align="right" >每小时</td>
            </tr>
        </div>

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述</td>
                <input class="easyui-textbox" type="text" id="remark" name="remark"
                          data-options="required:true,multiline:true"
                          style="width: 120px ;height: 100px" value='${venuesAllocation.remark}'>
                </input>
            </tr>
        </div>

    </form>
</div>
<script type="text/javascript">
    $('#venuesAllocationState').combobox({
        value:'${venuesAllocation.venuesAllocationState}'
    })
    $('#venuesConfiguration').combobox({
        value:'${venuesAllocation.venuesConfiguration}'
    })



    $('#editvenuesallocation').form({
        url:"editvenuesallocation.action?venuesAllocationId="+${venuesAllocation.venuesAllocationId},
        onSubmit: function(){
            if(!$("#editvenuesallocation").form("validate")){
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
                $('#venuesallocationdialog').dialog('close')
                //  parent.document.getElecmentById("#win").dialog('close');
//                        var v=$('#edit').find('#win');
//                        v.dialog('close')
                // $('#menu').dialog.openner_dataGrid = $('#goods_date').datagrid();//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                $("#venuesallocation").datagrid('reload');
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
        time: {
            validator: function (value) {
                var reg =/^(?:[01]\d|2[0-3])(?::[0-5]\d){2}$/;
                return reg.test(value);
            },
            message: '时间格式错误'
        },
        money: {
            validator: function (value) {
                var reg =/(^[1-9](\d+)?(\.\d{1,2})?$)|(^(0){1}$)|(^\d\.\d{1,2}?$)/;
                return reg.test(value);
            },
            message: '请输入正确的金钱格式'
        },

        emailisOnly:{
            validator: function (value) {
                var id = $("#userEmail").val().trim();
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
        equaldDate: {
            validator: function (value, param) {
                var start = $('#openTime').timespinner('getValue');  //获取开始时间
                return value > start;                             //有效范围为当前时间大于开始时间
            },
            message: '闭馆时间应大于开馆时间!'                     //匹配失败消息
        }

    })

</script>

