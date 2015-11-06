<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>

    <title>修改个人信息</title>
    <script type="text/javascript" src="${ctx}/front/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/Util.js"></script>
</head>
<body>

<form method="post" action="${ctx}/user/modify">
    <input type="hidden" name="id" value="${user.id}"/>
    <table cellpadding="1" cellspacing="1" border="1" align="center" style="height: 100px; width: 300px;">
        <tr>
            <td>用户名</td>
            <td><input readonly="readonly" type="text" name="userName" value="${user.userName}"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>手机号码</td>
            <td><input type="text" name="phone" value="${user.phone}"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="sex" value="0" />男&nbsp;<input type="radio" name="sex" value="1"/>女</td>
            <script>setRadio("sex",${user.sex})</script>
        </tr>
        <tr>
            <td>角色</td>
            <td><input type="radio" disabled="disabled" name="role" value="0"/>用户&nbsp;<input type="radio" disabled="disabled" name="role" value="1"/>运营商</td>
            <script>setRadio("role",${user.role})</script>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="确定"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
