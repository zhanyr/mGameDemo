package com.zyr.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyr.demo.bean.Function;

@Controller
@RequestMapping("/func")
public class FunctionController {

    @RequestMapping("/getPage")
    @ResponseBody
    public List<Function> getPage() {
        List<Function> funcList = new ArrayList<Function>();
        Function func = new Function();
        func.setId("1");
        func.setFuncCode("delete");
        func.setFuncName("删除菜单");
        funcList.add(func);
        
        func = new Function();
        func.setId("2");
        func.setFuncCode("update");
        func.setFuncName("更新菜单");
        funcList.add(func);
        
        func = new Function();
        func.setId("3");
        func.setFuncCode("add");
        func.setFuncName("新增菜单");
        funcList.add(func);
        
        return funcList;
    }

    /**
     * 批量删除权限
     */
    @RequestMapping("/batchDelete")
    @ResponseBody
    public String batchDelete(Model model, String[] ids) {
        return "success";
    }

    /**
     * 添加权限页面
     */
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("func", new Function());
        model.addAttribute("action", "save");
        return "/func/func_edit";
    }

    /**
     * 保存权限
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(Model model, Function func, String menuId) {
        return "success";
    }

    /**
     * 编辑权限页面
     */
    @RequestMapping("/edit/{funcId}")
    public String edit(Model model, @PathVariable String funcId) {
        model.addAttribute("action", "update");
        return "/func/func_edit";
    }

    /**
     * 更新权限
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(Model model, @ModelAttribute("updateObj") Function func) {
        return "success";
    }

    /**
     * 进入权限管理主页面
     */
    @RequestMapping("/main")
    public String main() {
        return "/func/func_main";
    }

    /**
     * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
     * 表单请求参数bind=true才执行，仅对update()有效（提交请求中不包含password, registerDate, salt, roles属性值，须预绑定到model）
     */
    @ModelAttribute
    public void prepare(@RequestParam(defaultValue = "false") Boolean bindable, String id, Model model) {
        if (bindable) {
//            model.addAttribute("updateObj", funcService.findById(id));
        }
    }
}
