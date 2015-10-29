<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

    <title>mgameDemo</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <script type="text/javascript" src="${ctx }/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx }/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx }/js/czyUtil.js"></script>
    <script type="text/javascript" src="${ctx }/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link type="text/css" rel="stylesheet" href="${ctx }/easyui/themes/default/easyui.css"></link>
    <link type="text/css" rel="stylesheet" href="${ctx }/easyui/themes/icon.css"></link>

    <script type="text/javascript">
        $(function () {
            //**************** 初始化菜单组件  *******************************//
            var tabs = $("#home_tabs"); //选项卡组件
            tabs.tabs('close');

            //菜单项点击事件
            $("a[type='menuBtn']").click(function () {
                var title = $(this).html();
                var url = this.title;

                if (tabs.tabs("exists", title)) {
                    tabs.tabs("select", title);
                } else {
                    $(tabs).tabs('add', {
                        title: title,
                        href: url,
                        closable: true
                    });
                }
            });
        });
    </script>
</head>

<body class="easyui-layout">
<div id="home_menu" data-options="region:'west',title:'菜单',split:true" style="width:208px;">
    <div class="easyui-accordion" style="width:200px;">
        <c:forEach var="levelOne" items="${menus }">
            <div title="${levelOne.menuname }">
                <ul class="easyui-tree">
                    <c:forEach var="sub" items="${levelOne.children }">
                        <li>
                            <a type="menuBtn" title="${ctx}/${sub.url }">${sub.menuname }</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:forEach>
    </div>
</div>
<div id="home_content" data-options="region:'center',title:'主面板'">
    <div id="home_tabs" class="easyui-tabs" data-options="fit:true">
    </div>
</div>

</body>

</html>
