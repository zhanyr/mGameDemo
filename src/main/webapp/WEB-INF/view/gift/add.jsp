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

    <script type="text/javascript" src="${ctx}/front/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/front/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${ctx}/front/js/Util.js"></script>

    <link type="text/css" rel="stylesheet" href="${ctx}/front/easyui/themes/icon.css"/>

    <script type="text/javascript">
        $(function () {
            /*************  注册表单验证 ************************/
            $("#signupForm").validate({
                rules: {
                    giftName : "required",
                    startTime : {
                        required:true,
                        date:true
                    },
                    endTime : {
                        required:true,
                        date:true
                    },
                    giftCount : {
                        digits:true
                    }
                },
                messages : {
                    giftName : "礼包名称必填",
                    startTime : {
                        required : "开始时间必填",
                        date : "输入项需符合日期格式yyyy-mm-dd hh:mm:ss"
                    },
                    endTime : {
                        required : "结束时间必填",
                        date : "输入项需符合日期格式yyyy-mm-dd hh:mm:ss"
                    },
                    giftCount : {
                    	required : "礼包数量必填",
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
            <td><input type="text" name="giftName"/><font color="red">*</font></td>
        </tr>
        <tr>
            <td>礼包描述</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td>礼包数量</td>
            <td><input type="text" name="giftCount"/><font color="red">*</font></td>
        </tr>
        <tr>
            <td>开始时间</td>
            <td><input type="text" name="startTime" /><font color="red">*</font></td>
        </tr>
        <tr>
            <td>结束时间</td>
            <td><input type="text" name="endTime"/><font color="red">*</font></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="button" id="btnAdd" value="添加"/>
            </td>
        </tr>
    </table>

    <div align="center"><font color="red">${msg.content}</font></div>
</form>
</body>
</html>
