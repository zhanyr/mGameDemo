<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<frameset cols="10%,90%">
  <frame src="${pageContext.request.contextPath}/home/menu" />
  <frame src="${pageContext.request.contextPath}/user/info" name="mainFrame"/>
</frameset>
</html>
