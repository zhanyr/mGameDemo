<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
  li{
    list-style-type: none;
  }
</style>

<html>

<head>
  <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
</head>
<body>
  <ul>
    <li><a href="${ctx}/user/info" target="mainFrame">个人信息</a></li>
    <li><a href="${ctx}/gift/list" target="mainFrame">礼包列表</a></li>
    <li><a href="${ctx}/user/gifts" target="mainFrame">礼包查询</a></li>
  </ul>

</body>
</html>
