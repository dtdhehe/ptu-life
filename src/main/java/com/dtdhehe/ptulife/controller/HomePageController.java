package com.dtdhehe.ptulife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户访问首页controller
 * date:2018-10-31
 * @author dtdhehe
 */
@Controller
@RequestMapping("/ptu/homePageController")
public class HomePageController {

    /**
     * 测试页面的controller，后期删除
     * @return
     */
//    @RequestMapping("/newspage")
//    public String index2(){
//        return "editNews";
//    }

    @RequestMapping("/home")
    public String index(){
        return "homepage";
    }

    @RequestMapping("/life")
    public String life(){
        return "life";
    }

    @GetMapping("/index")
    public ModelAndView homePage(){
        return new ModelAndView("login");
    }

    @GetMapping("/registPage")
    public ModelAndView registPage() {
        return new ModelAndView("regist");
    }
}
