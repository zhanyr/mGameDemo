<%--
  主页
  User: 陈致远
  Date: 2015/11/1 0001
  Time: 下午 4:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<frameset cols="25%,75%">
  <frame src="${pageContext.request.contextPath}/home/menu" />
  <frame src="${pageContext.request.contextPath}/user/info" name="mainFrame"/>
</frameset>
</html>
