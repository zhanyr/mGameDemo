<%--
  登录页面
  User: 陈致远
  Date: 2015/11/1 0001
  Time: 下午 4:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript">
        // 在被嵌套时就刷新上级窗口
        if(window.parent != window){
            window.parent.location.reload(true);
        }
    </script>
</head>
<body>

<a href="${ctx}/user/toRegister">注册</a>
<form method="post" action="${ctx}/user/login">
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
            <td colspan="2" align="center">
                <input type="submit" value="登录"/>
            </td>
        </tr>
    </table>
</form>

<div align="center"><font color="red">${msg.content}</font></div>
</body>
</html>
