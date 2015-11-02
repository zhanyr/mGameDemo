<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
    <meta charset="utf-8">
    <title>用户信息</title>

    <script type="text/javascript">
        function modify(){
            window.location.href = "${ctx}/user/toModify";
        }

        function logout(){
            window.location.href = "${ctx}/user/logout";
        }
    </script>
</head>

<body>

<input type="button" value="修改个人信息" onclick="modify()"/>
<input type="button" value="退出" onclick="logout()"/>
<table cellpadding="1" cellspacing="1" border="1" align="center" style="height: 100px; width: 300px;">
    <tr>
        <td>用户名</td>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <td>手机号</td>
        <td>${user.phone}</td>
    </tr>
    <tr>
        <td>性别</td>
        <td>
           <c:choose>
               <c:when test="${user.sex == 0}">
                   男
               </c:when>
               <c:otherwise>
                   女
               </c:otherwise>
           </c:choose>
        </td>
    </tr>
    <tr>
        <td>积分</td>
        <td>
            <c:choose>
                <c:when test="${empty user.score}">
                    0
                </c:when>
                <c:otherwise>
                    ${user.score}
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>
</body>

</html>
