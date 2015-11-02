<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>

<head>
    <meta charset="utf-8">
    <title>已拥有礼包列表</title>

</head>

<body>

<table cellpadding="1" cellspacing="1" border="1" align="center" style=" width: 60%;">
    <tr>
        <th>礼包名称</th>
        <th>兑换码</th>
    </tr>

    <c:forEach var="gift" items="${userGifts}">
        <tr>
            <td>${gift.giftName}</td>
            <td>${gift.giftKey}</td>
        </tr>
    </c:forEach>
</table>

<div align="center"><font color="red">${msg.content}</font></div>
</body>

</html>
