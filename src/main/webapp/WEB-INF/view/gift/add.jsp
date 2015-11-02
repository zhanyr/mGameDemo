<%--
  礼包新增页面
  User: 陈致远
  Date: 2015/11/2 0001
  Time: 上午 10:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>新增礼包</title>
    <script type="text/javascript" src="${ctx}/front/js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/Util.js"></script>

    <script type="text/javascript">
        $(function () {
            /*************  注册表单验证 ************************/
            $("#signupForm").validate({
                rules: {
                    giftName : "required",
                    startTime : "required",
                    endTime : "required",
                    giftCount : {
                        digits:true
                    }
                },
                messages : {
                    giftName : "礼包名称必填",
                    startTime : "开始时间必填",
                    endTime : "结束时间必填",
                    giftCount : {
                        digits: "只能输入数字！"
                    }
                }
            });

            /*************  验证通过提交表单 ************************/
            $("#btnAdd").click(function(){
                var r = $("#signupForm").valid();
                if(r){
                    $("#signupForm").submit();
                }
            });
        });
    </script>
</head>
<body>

<form id="signupForm" method="post" action="${ctx}/gift/add">
    <table cellpadding="1" cellspacing="1" border="1" align="center" style=" width: 500px;">
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
                <input type="button" id="btnAdd" value="生成"/>
            </td>
        </tr>
    </table>

    <div align="center"><font color="red">${msg.content}</font></div>
</form>
</body>
</html>
