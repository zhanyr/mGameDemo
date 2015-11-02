package com.zyr.demo.controller;


import com.zyr.demo.bean.DemoUser;
import com.zyr.demo.bean.UserGift;
import com.zyr.demo.bean.vo.Message;
import com.zyr.demo.service.GiftService;
import com.zyr.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * UserController 用户管理Controller层
 *
 * @author zhanyr
 * @date 2015/11/1
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GiftService giftService;

    /**
     * 进入个人信息修改页面
     * @return
     */
    @RequestMapping("/toModify")
    public String toModify(Model model, HttpSession session) {
        Integer userId = (Integer)session.getAttribute("user");
        DemoUser user = userService.getUserData(userId);
        model.addAttribute("user",user);
        return "/user/user_modify";
    }

    /**
     * 修改个人信息
     * @return
     */
    @RequestMapping("/modify")
    public String modify(Model model, DemoUser user) {
        userService.changeUserData(user);
        return "redirect:/user/info";
    }

    /**
     * 进入个人信息页面
     * @return
     */
    @RequestMapping("/info")
    public String info(Model model,HttpSession session) {
        Integer userId = (Integer)session.getAttribute("user");
        DemoUser user = userService.getUserData(userId);

        model.addAttribute("user", user);
        return "/user/user_info";
    }

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/user/login";
    }

    /**
     * 登录功能
     * @user 用户信息
     * @param model
     * @return 成功进入主页面；失败退回登录页
     */
    @RequestMapping("/login")
    public String login(Model model,String userName,String password,HttpSession session) {
        DemoUser user = userService.login(userName,password);
        Message msg = new Message();

        if(null == user){
            msg.setResult(1);
            msg.setContent("登录失败！");
            model.addAttribute("msg",msg);
            return "/user/login";
        }else{
            session.setAttribute("user",user.getId());
            msg.setResult(0);
            msg.setContent("登录成功！");
            return "redirect:/home/index";
        }

    }

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");

        return "/user/login";
    }

    /**
     * 进入注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(Model model) {

        return "/user/register";
    }

    /**
     * 注册功能
     * @user 用户信息
     * @param model
     * @return 成功进入登录页面；失败退回注册页面
     */
    @RequestMapping("/register")
    public String register(Model model,DemoUser user,HttpSession session) {
        String username = user.getUserName();

        Message msg = new Message();
        if(1 == userService.checkUserName(username)){
            msg.setResult(1);
            msg.setContent("用户名已存在，请重新输入！");

            model.addAttribute("msg",msg);
            return "/user/register";
        }else{
            //新增用户暂定为启用状态
            user.setEnabled("0");
            //登录送10积分
            user.setScore(10);
            userService.addUser(user);
        }

        return "redirect:/user/toLogin";
    }

    /**
     * 查看用户已拥有礼包
     * @return
     */
    @RequestMapping("/gifts")
    public String gifts(Model model,HttpSession session){
       List<UserGift> userGiftList = giftService.possessedGift((Integer) session.getAttribute("user"));
        model.addAttribute("userGifts",userGiftList);
        return "/user/gifts";
    }

}
