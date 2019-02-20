package com.dtdhehe.ptulife.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By Xie_东
 * on 2019/2/20 17:51
 * @author admin
 */
@Controller
@RequestMapping("/myInformationController")
public class MyInformationController {

    private final Logger logger = LoggerFactory.getLogger(MyInformationController.class);

    /**
     * 返回我的资料页面
     * @return
     */
    @RequestMapping("/getMyInformation")
    public String getMyInformation(){

        return "myInformation";
    }

}
