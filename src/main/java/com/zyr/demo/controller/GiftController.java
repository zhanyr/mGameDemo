package com.zyr.demo.controller;


import com.zyr.demo.bean.DemoGift;
import com.zyr.demo.bean.vo.Message;
import com.zyr.demo.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gift")
public class GiftController {
    @Autowired
    private GiftService giftService;

    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 查看所有礼包
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<DemoGift> giftList = giftService.getAllGift();
        model.addAttribute("gifts",giftList);
        return "/gift/list";
    }

    /**
     * 进入礼包新增页面
     * @return 礼包新增页面
     */
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/gift/add";
    }

    /**
     * 厂商添加新的礼包
     * @param model
     */
    @RequestMapping("/add")
    public String add(Model model,@RequestParam Map<String,String> params){
        Message msg = new Message();

        try {
            DemoGift gift = new DemoGift();
            gift.setGiftName(params.get("giftName"));
            gift.setDescription(params.get("description"));
            gift.setGiftCount(Integer.valueOf(params.get("giftCount").trim()));
            gift.setStartTime(df.parse(params.get("startTime")));
            gift.setEndTime(df.parse(params.get("endTime")));

            giftService.addGift(gift);
            return "redirect:/gift/list";
        } catch (ParseException e) {
            msg.setResult(1);
            msg.setContent("礼包生成失败！");
            return "/gift/add";
        }

    }

    /**
     * 抢购
     *
     * @param model
     * @return 成功返回当前用户礼包页；失败返回所有礼包列表
     */
    @RequestMapping("/buy/{id}")
    @ResponseBody
    public Message buy(Model model,@PathVariable Integer id,HttpSession session) {
       String giftKey = giftService.grabGift((Integer)session.getAttribute("user"),id);

        Message msg = new Message();
        //1 已抢过该礼包  2未抢到再接再励   3出现异常
        if("1".equals(giftKey)){
            msg.setResult(1);
            msg.setContent("您已经抢过该礼包，不能再抢");
        }else if("2".equals(giftKey)){
            msg.setResult(1);
            msg.setContent("没有抢到兑换码，请再接再厉！");
        }else if("3".equals(giftKey) || null == giftKey){
            msg.setResult(1);
            msg.setContent("服务器忙");
        } else{
            msg.setResult(0);
            msg.setContent("恭喜你，抢到礼包，礼包码是"+giftKey);
        }
        return msg;
    }
}
