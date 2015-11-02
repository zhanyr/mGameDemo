<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript" src="${ctx}/resources/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/Util.js"></script>
</head>
<body>

<form method="post" action="${ctx}/user/register">
    <table cellpadding="1" cellspacing="1" border="1" align="center" style="height: 100px; width: 300px;">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>手机号码</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="sex" value="0" checked="checked"/>男&nbsp;<input type="radio" name="sex" value="1"/>女</td>
        </tr>
        <tr>
            <td>角色</td>
            <td><input type="radio" name="role" value="0" checked="checked"/>用户&nbsp;<input type="radio" name="role" value="1"/>运营商</td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册"/>
            </td>
        </tr>
    </table>

    <div align="center"><font color="red">${msg.content}</font></div>
</form>
</body>
</html>
