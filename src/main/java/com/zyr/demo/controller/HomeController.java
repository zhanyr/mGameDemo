package com.zyr.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    /**
     * 进入主页
     *
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String back(Model model) {
        return "/home/index";
    }

	/**
	 * 进入左侧菜单页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/menu")
	public String menu(Model model) {
		return "/home/menu";
	}
}
