package com.zyr.demo.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyr.demo.bean.Menu;

@Controller
@RequestMapping("/home")
public class HomeController {

    /**
     * 进入后台管理主页面：准备菜单数据
     *
     * @param model
     * @return
     */
    @RequestMapping("/back")
    public String back(Model model) {
    	/*********** 构造菜单  **************/
    	List<Menu> menus = new ArrayList<Menu>();
    	
    	Menu grzx = new Menu();
    	grzx.setId("1");
    	grzx.setMenuname("个人中心");
    	
    	Set<Menu> children = new HashSet<Menu>();
    	
    	Menu xgmm = new Menu();
    	xgmm.setId("1_1");
    	xgmm.setMenuname("修改密码");
    	xgmm.setUrl("/user/modifyPwd");
    	children.add(xgmm);
    	
    	Menu grzl = new Menu();
    	grzl.setId("1_2");
    	grzl.setMenuname("个人资料");
    	grzl.setUrl("/user/selfInfo");
    	children.add(grzl);
    	
    	Menu qxgl = new Menu();
    	qxgl.setId("1_3");
    	qxgl.setMenuname("权限管理");
    	qxgl.setUrl("/func/main");
    	children.add(qxgl);
    	
    	grzx.setChildren(children);
    	
    	Menu qlb = new Menu();
    	qlb.setId("2");
    	qlb.setMenuname("抢礼包");
    	
    	menus.add(grzx);
    	menus.add(qlb);
    	
    	model.addAttribute("menus", menus);
        return "/home/back";
    }
}
