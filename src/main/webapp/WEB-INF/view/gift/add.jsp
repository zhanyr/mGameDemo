<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>新增礼包</title>
    <script type="text/javascript" src="${ctx}/resources/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx}/resources/js/Util.js"></script>
</head>
<body>

<form method="post" action="${ctx}/gift/add">
    <table cellpadding="1" cellspacing="1" border="1" align="center" style="height: 100px; width: 300px;">
        <tr>
            <td>礼包名称</td>
            <td><input type="text" name="giftName"/></td>
        </tr>
        <tr>
            <td>礼包描述</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td>礼包数量</td>
            <td><input type="text" name="giftCount"/></td>
        </tr>
        <tr>
            <td>开始时间</td>
            <td><input type="text" name="startTime" /></td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td><input type="text" name="endTime"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="生成"/>
            </td>
        </tr>
    </table>

    <div align="center"><font color="red">${msg.content}</font></div>
</form>
</body>
</html>
