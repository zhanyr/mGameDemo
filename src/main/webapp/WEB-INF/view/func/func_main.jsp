<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>

<script type="text/javascript">
    //权限更新方法
    function update(id) {
        $("#func_edit_dialog").dialog({title: '权限更新'}).dialog('open').dialog('refresh', 'func/edit/' + id);
    }

    $(function () {
        //右侧菜单列表
        $('#func_main_list').datagrid(
                {
                    url: '${pageContext.request.contextPath}/func/getPage',
                    idField: "id",
                    pagination: true,
                    columns: [[
                        {
                            field: 'id',
                            title: '编号',
                            width: 100,
                            checkbox: true
                        },
                        {
                            field: 'funcName',
                            title: '权限名称',
                            width: 100
                        },
                        {
                            field: 'funcCode',
                            title: '权限编码',
                            width: 100
                        },
                        {
                            field: 'cz',
                            title: '操作',
                            width: 100,
                            formatter: function (value, row, index) {
                                return "<span  onclick='update(\"" + value + "\")'>更新</span>";
                            }
                        }]],

                    toolbar: [
                        {
                            iconCls: 'icon-add',
                            text: '新增权限',
                            handler: function () {
                                    $("#func_edit_dialog").dialog('open').dialog('refresh', '${ctx}/func/add');
                            }
                        },
                        '-',
                        {
                            iconCls: 'icon-remove',
                            text: '删除权限',
                            handler: function () {
                                //获取选中的行
                                var selects = $("#func_main_list").datagrid("getSelections");

                                if (selects != null && selects.length > 0) {
                                    var ids = "";

                                    for (var i = 0; i < selects.length; i++) {
                                        ids += selects[i].id + ",";
                                    }

                                    ids = ids.substring(0, ids.length - 1);

                                    $.messager.confirm("提示", "您确定要删除该用户？", function (data) {
                                        if (data) {
                                            $.post("func/batchDelete",
                                                    {ids: ids}, function () {
                                                        $('#func_main_list').datagrid("reload");
                                                    });
                                        }
                                    });
                                }
                            }
                        }],
                    fitColumns: true
                });

    });
</script>

<table id="func_main_list" data-options="fit:true"></table>

<div id="func_edit_dialog" class="easyui-dialog" title="权限添加" style="width:400px;height:300px;"
     data-options="iconCls:'icon-save',modal:true,closed:true">
</div> 