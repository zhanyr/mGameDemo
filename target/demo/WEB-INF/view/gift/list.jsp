<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<head>
    <meta charset="utf-8">
    <title>礼包列表</title>
    <script type="text/javascript" src="${ctx}/front/js/jquery-1.7.1.js"></script>

    <script type="text/javascript">
        function buy(giftId){
            $.post("${ctx}/gift/buy/" + giftId, function (result) {
                alert(result.content);
                window.location.href = "${ctx}/gift/list/"
            });
        }

        function generalGift(){
            window.location.href = "${ctx}/gift/toAdd/"
        }
    </script>
</head>

<body>
    <c:if test="${user.role == 1}">
     <input type="button" value="添加礼包" onclick="generalGift()"/>
    </c:if>

<table cellpadding="1" cellspacing="1" border="1" align="center" style="width: 80%">
    <tr>
        <th>名称</th>
        <th>描述</th>
        <th>开始时间</th>
        <th>结束时间</th>
        <th>剩余数量</th>

        <c:if test="${user.role == 0}">
            <th>操作</th>
        </c:if>

    </tr>

    <c:forEach var="gift" items="${gifts}">
        <tr>
            <td>${gift.giftName}</td>
            <td>${gift.description}</td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${gift.startTime}" /></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${gift.endTime}" /></td>
            <td>${gift.giftCount}</td>
            <c:if test="${user.role == 0}">
            <td>
                <input type="button" value="抢礼包" onclick="buy(${gift.id})"
                       <c:if test="${gift.giftCount <=0}">disabled="disabled"</c:if> />
            </td>
            </c:if>
        </tr>
    </c:forEach>

</table>

</body>

</html>
