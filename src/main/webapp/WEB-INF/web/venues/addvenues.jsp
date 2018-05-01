<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/4/3
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<div >
    <form id="addvenues" method="post">

        <div style="padding-top: 10px">
            <tr>
                <td width="60px" align="right" >场馆负责人</td>
                <td>
                    <input class="easyui-combobox" type="text" id="venuesUserCharge" name="venuesUserCharge"  style="width: 120px "  />
                </td>

            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >手机号码</td>
                <td>
                <input class="easyui-validatebox" type="text" id="venues_phone" name="phone" data-options="required:true,validType:['Mobile']"  />
                </td>
            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >开馆时间</td>
                <td>
                <input id="openTime" type="text" name="openTime" data-options="required:true,validType:['time']" >
                </td>
            </tr>
        </div>

        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >开馆时间</td>
                <td>
                <input id="closeTime" type="text" name="closeTime"  data-options="required:true,validType:['time','equaldDate[\'#SignedStartDate\']']">
                </td>
            </tr>
        </div>
        <%--<div style="padding-top: 10px">--%>
            <%--<tr>--%>
                <%--<td width="60" align="right" >用户密码</td>--%>
                <%--<input class="easyui-validatebox" value="root" type="text" id="userPassword" name="userPassword" data-options="required:true" />--%>
            <%--</tr>--%>
        <%--</div>--%>


        <div style="padding-top: 10px">

            <tr>
                <td width="60" align="right" >省</td>
                <td>
                <select id="venuesProvice" class="easyui-combobox" name="venuesProvice"  style="width: 120px ">
                </select>
                </td>
            </tr>
           <tr>
        </div>
            <div style="padding-top: 10px">
           <td width="60" align="right" >市</td>
                <td>
                    <select id="venuesCity" class="easyui-combobox" name="venuesCity" style="width:120px;">
                    </select>
                </td>

           </tr>
            </div>
            <div style="padding-top: 10px">
              <tr>
                  <td width="60" align="right" >县</td>
                  <td>
                      <select id="venuesAreas" class="easyui-combobox" name="venuesAreas" style="width:120px;">
                      </select>
                  </td>

              </tr>
            </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >具体地址</td>
                <td>
                    <input class="easyui-validatebox" type="text" id="venuesAddress" name="venuesAddress" data-options="required:true"    />
                </td>

            </tr>
        </div>
        <%--<div>--%>
            <%--<a href="#" id="searchmap" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchmap()">查找经纬度</a>--%>

        <%--</div>--%>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >场馆名称</td>
                <td>
                    <input class="easyui-validatebox" type="text" id="venuesName" name="venuesName" data-options="required:true"    />
                </td>

            </tr>
        </div>
        <div style="padding-top: 10px">
            <tr>
                <td width="60" align="right" >场馆简介</td>
                <td>
                    <input  type="text" id="brief" name="brief" class="easyui-textbox" data-options="required:true,multiline:true"   />
                </td>

            </tr>
        </div>
    </form>
<%--<table style="width:auto;height: auto">--%>

        <%--<form id="addvenues" method="post">--%>

                <%--<tr>--%>
                    <%--<td>场馆负责人</td>--%>
                    <%--<td>--%>
                        <%--<input class="easyui-combobox" type="text" id="venuesUserCharge" name="venuesUserCharge"  style="width: 120px "  />--%>
                    <%--</td>--%>

                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>手机号码</td>--%>
                    <%--<td>--%>
                        <%--<input class="easyui-textbox" type="text" id="venues_phone" name="phone" data-options="required:true,validType:['Mobile']"  />--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>开馆时间</td>--%>
                    <%--<td>--%>
                        <%--<input id="openTime" type="text" name="openTime" data-options="required:true,validType:['time']" >--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>开馆时间</td>--%>
                    <%--<td>--%>
                        <%--<input id="closeTime" type="text" name="closeTime"  data-options="required:true,validType:['time','equaldDate[\'#SignedStartDate\']']">--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>省</td>--%>
                    <%--<td>--%>
                        <%--<select id="venuesProvice" class="easyui-combobox" name="venuesProvice"  style="width: 120px ">--%>
                        <%--</select>--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                <%--<td>市</td>--%>
                <%--<td>--%>
                    <%--<select id="venuesCity" class="easyui-combobox" name="venuesCity" style="width:120px;">--%>
                    <%--</select>--%>
                <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>县</td>--%>
                    <%--<td>--%>
                        <%--<select id="venuesAreas" class="easyui-combobox" name="venuesAreas" style="width:120px;">--%>
                        <%--</select>--%>
                    <%--</td>--%>

                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td>具体地址</td>--%>
                    <%--<td>--%>
                        <%--<input class="easyui-validatebox" type="text" id="venuesAddress" name="venuesAddress" data-options="required:true"    />--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td >场馆名称</td>--%>
                    <%--<td>--%>
                        <%--<input class="easyui-validatebox" type="text" id="venuesName" name="venuesName" data-options="required:true"    />--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <%--<tr>--%>
                    <%--<td >场馆简介</td>--%>
                    <%--<td>--%>
                        <%--<input  type="text" id="brief" name="brief" class="easyui-textbox" data-options="required:true,multiline:true"   />--%>
                    <%--</td>--%>

                <%--</tr>--%>
        <%--</form>--%>
<%--</table>--%>

</div>
<script type="text/javascript">

    $('#venuesUserCharge').combobox({
        url:"getcur.action",
        required:true,
        editable:false,
        valueField:'userid',
        textField:'userTruename',
    })


    $('#venuesProvice').combobox({
        url:"provinceQueryall.action",
        required:true,
        editable:false,
        valueField:'provinceid',
        textField:'province',
    })

    $('#venuesCity').combobox({
        required:true,
        editable:false,
        url:"querycityByprovince.action",
        valueField:'cityid',
        textField:'city',

    })
    $('#venuesAreas').combobox({
        required:true,
        editable:false,
        url:"queryareaBycities.action",
        valueField:'areaid',
        textField:'area'
    })


    $('#venuesProvice').combobox({
        onSelect: function (row) {
            if (row != null) {
                $('#venuesCity').combobox({
                    url: "querycityByprovince.action?provinceid=" + row.provinceid
                });
            }
        }
    });
    $('#venuesCity').combobox({
        onSelect: function (row) {
            if (row != null) {
                $('#venuesAreas').combobox({
                    url: "queryareaBycities.action?cityid=" + row.cityid
                });
            }
        }
    });

    $('#openTime').timespinner({
        min: '08:30',
        required: true,
        showSeconds: true
    });
    $('#closeTime').timespinner({
        min: '08:30',
        required: true,
        showSeconds: true
    });


    $('#addvenues').form({
        url:"addvenues.action",
        onSubmit: function(){
            if(!$("#addvenues").form("validate")){
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
                $('#venuesdialog').dialog('close')
                //  parent.document.getElecmentById("#win").dialog('close');
//                        var v=$('#edit').find('#win');
//                        v.dialog('close')
                // $('#menu').dialog.openner_dataGrid = $('#goods_date').datagrid();//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                $("#venues").datagrid('reload');
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
            message: '请输入正确的手机号'
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
        },


    })

</script>

