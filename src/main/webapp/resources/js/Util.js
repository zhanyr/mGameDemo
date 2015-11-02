//多选框默认选中某项(用于回显)
function setCheckbox(checkboxName, menuId) {
    $("[name='" + checkboxName + "']:checkbox").each(function () {
        if (this.value == menuId) { // 比较 相等 则选择
            this.checked = true;
        }
    });
}

function setRadio(radioName, menuId) {
    $("[name='" + radioName + "']:radio").each(function () {
        if (this.value == menuId) { // 比较 相等 则选择
            this.checked = true;
        }
    });
}

//控件href、height、width属性转json对象
function input2Json(inputParam) {
    var result = {};

    result.href = inputParam.attr("href");
    result.height = inputParam.attr("height");
    result.width = inputParam.attr("width");
    return result;
}