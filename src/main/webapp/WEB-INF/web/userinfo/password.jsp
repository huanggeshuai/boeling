<%--
  Created by IntelliJ IDEA.
  User: huang
  Date: 2018/5/7
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .editTable .label {
        min-width: 80px;
        width: 80px;
    }
</style>
  <div>
      <table class="editTable">
          <tr>
              <td class="label">旧密码</td>
              <td><input type="text" id="oldpassword" name="password">
              </td>
          </tr>
          <tr>
              <td class="label">新密码</td>
              <td><input type="text" id="password" name="password">
              </td>
          </tr>
          <tr>
              <td class="label">重复新密码</td>
              <td><input type="text" id="password2" name="password2"></td>
          </tr>
      </table>
  </div>




<script type="text/javascript">
    $(function () {
//        $('#userNameId').iTextbox({
//            width: 200,
//            readonly: true
//        });
//        $('#userName').iTextbox({
//            width: 200,
//            readonly: true
//        });
        $('#oldpassword').iPasswordbox({
            width: 200,
            required: true,
            validType: 'minLength[6]'
        });
        $('#password').iPasswordbox({
            width: 200,
            required: true,
            validType: 'minLength[6]'
        });
        $('#password2').iPasswordbox({
            width: 200,
            required: true,
            validType: "equals['#password']"
        });
    });
</script>
