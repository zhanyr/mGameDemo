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
    	
    	Menu pCenter = new Menu();
    	pCenter.setId("1");
    	pCenter.setMenuname("个人中心");
    	
    	Set<Menu> pCenterChildren = new HashSet<Menu>();
    	
    	Menu changePwd = new Menu();
    	changePwd.setId("1_1");
    	changePwd.setMenuname("修改密码");
    	changePwd.setUrl("/user/modifyPwd");
    	pCenterChildren.add(changePwd);
    	
    	Menu pData = new Menu();
    	pData.setId("1_2");
    	pData.setMenuname("个人资料");
    	pData.setUrl("/user/selfInfo");
    	pCenterChildren.add(pData);
    	
    	Menu authorityManage = new Menu();
    	authorityManage.setId("1_3");
    	authorityManage.setMenuname("权限管理");
    	authorityManage.setUrl("/func/main");
    	pCenterChildren.add(authorityManage);
    	
    	pCenter.setChildren(pCenterChildren);
    	
    	Menu getGift = new Menu();
    	getGift.setId("2");
    	getGift.setMenuname("抢礼包");
    	
    	Set<Menu> getGiftChildren = new HashSet<Menu>();
    	
    	Menu grabGift = new Menu();
    	grabGift.setId("2_1");
    	grabGift.setMenuname("抢礼包");
    	grabGift.setUrl("/gift/getGiftType");
    	getGiftChildren.add(grabGift);
    	
    	Menu giftList = new Menu();
    	giftList.setId("2_2");
    	giftList.setMenuname("拥有礼包");
    	giftList.setUrl("/gift/haveGift");
    	getGiftChildren.add(giftList);
    	
    	getGift.setChildren(getGiftChildren);
    	
    	Menu addGift = new Menu();
    	addGift.setId("3");
    	addGift.setMenuname("录入礼包");
    	
    	Set<Menu> addGiftChildren = new HashSet<Menu>();
    	
    	Menu addGiftType = new Menu();
    	addGiftType.setId("3_1");
    	addGiftType.setMenuname("添加礼包种类");
    	addGiftType.setUrl("/gift/addGiftType");
    	addGiftChildren.add(addGiftType);
    	
    	Menu addGiftKey = new Menu();
    	addGiftKey.setId("3_2");
    	addGiftKey.setMenuname("添加礼包码");
    	addGiftKey.setUrl("/gift/addGiftKey");
    	addGiftChildren.add(addGiftKey);
    	
    	addGift.setChildren(addGiftChildren);
    	
    	menus.add(pCenter);
    	menus.add(getGift);
    	menus.add(addGift);
    	
    	model.addAttribute("menus", menus);
        return "/home/back";
    }
}
