<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(function () {
        //权限编辑表单注册
        $('#func_edit_form').form({
            url: "${pageContext.request.contextPath}/func/${action}",
            onSubmit: function () {
                if (!$("#func_edit_form").form("validate")) {
                    $.messager.show({
                        title: "提示信息",
                        msg: "输入有误，请重新输入...",
                        showType: 'slide',
                        timeout: 5000
                    });
                    return false;
                }
            },
            success: function (data) {
                $("#func_edit_dialog").dialog("close");
                $('#func_main_list').datagrid("reload");

                $.messager.show({
                    title: "提示信息",
                    msg: "更新完毕...",
                    showType: 'slide',
                    timeout: 5000
                });
            }
        });

        $("#func_edit_ok").click(function () {
            $('#func_edit_form').submit();
        });

        $("#func_edit_cancel").click(function () {
            $("#func_edit_dialog").dialog("close");
        });
    });
</script>

<form id="func_edit_form" method="post">
    <input name="id" id="func_edit_id" type="hidden" value="${func.id }"/>
    <input name="menuId" id="func_eidt_menuId" type="hidden" value="${menuId }"/>
    <c:if test="${action  == 'update'}"><input type="hidden" name="bindable" value="true"/></c:if>
    <table
            style="border:0px solid; width: 100%;height: 100%; border-collapse: 0">
        <tr>
            <td>权限名称</td>
            <td><input class="easyui-validatebox" type="text"
                       name="funcName" validType="midLength[2,9]" value="${func.funcName }"
                       invalidMessage="权限名称长度在2到9个字符之间" data-options="required:true"/></td>
        </tr>

        <tr>
            <td>权限代码</td>
            <td><input class="easyui-validatebox" validType="midLength[2,29]"
                       type="text" invalidMessage="权限代码长度在2到29个字符之间" value="${func.funcCode }"
                       data-options="required:true" name="funcCode"/>
            </td>
        </tr>

        <tr align="center">
            <td colspan="2"><a id="func_edit_ok" class="easyui-linkbutton"
                               data-options="iconCls:'icon-ok'">确定</a> <a id="func_edit_cancel"
                                                                          class="easyui-linkbutton"
                                                                          data-options="iconCls:'icon-cancel'">取消</a>
            </td>
        </tr>
    </table>
</form>
