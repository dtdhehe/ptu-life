package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.PtuUser;
import com.dtdhehe.ptulife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Create By Xie_东
 * on 2019/2/20 17:51
 * @author admin
 */
@Controller
@RequestMapping("/myInformationController")
public class MyInformationController {

    private final Logger logger = LoggerFactory.getLogger(MyInformationController.class);

    @Autowired
    private UserService userService;

    /**
     * 返回我的资料页面
     * @return
     */
    @RequestMapping("/getMyInformation")
    public String getMyInformation(HttpServletRequest request,Model model){
        //查出当前登录用户
        PtuUser ptuUser = (PtuUser) request.getSession().getAttribute("loginUser");
        ptuUser = userService.findOne(ptuUser.getUserId());
        model.addAttribute("currentUser",ptuUser);
        return "myInformation";
    }

}
