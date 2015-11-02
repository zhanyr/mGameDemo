<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>

    <title>注册</title>
    <script type="text/javascript" src="${ctx}/front/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/Util.js"></script>

    <script type="text/javascript">
        $(function () {
            /*************  注册表单验证 ************************/
            $("#signupForm").validate({
                rules: {
                    userName : "required",
                    password : "required",
                    rePwd : {
                        equalTo: "#password"
                    }
                },
                messages : {
                    userName : "用户名必填",
                    password : "密码必填",
                    rePwd : {
                        equalTo: "密码输入不一致！"
                    }
                }
            });

            /*************  验证通过提交表单 ************************/
            $("#btnRegister").click(function(){
                var r = $("#signupForm").valid();
                if(r){
                    $("#signupForm").submit();
                }
            });
        });
    </script>
</head>
<body>
    <form id="signupForm" method="post" action="${ctx}/user/register">
        <table cellpadding="1" cellspacing="1" border="1" align="center" style="height: 100px; width: 400px;">
            <tr>
                <td>用户名</td>
                <td>
                    <input type="text" name="userName"/>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input id="password" type="password" name="password"/>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="password" name="rePwd"/>
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>手机号码</td>
                <td><input type="text" name="phone"/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="radio" name="sex" value="0" checked="checked"/>男&nbsp;
                    <input type="radio" name="sex" value="1"/>女
                    <font color="red">*</font></td>
            </tr>
            <tr>
                <td>角色</td>
                <td>
                    <input type="radio" name="role" value="0" checked="checked"/>用户&nbsp;
                    <input type="radio" name="role" value="1"/>运营商
                    <font color="red">*</font></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input id="btnRegister" type="button" value="注册"/>
                </td>
            </tr>
        </table>
    </form>

    <div align="center"><font color="red">${msg.content}</font></div>
</body>
</html>
