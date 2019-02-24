package com.dtdhehe.ptulife.controller;

import com.alibaba.fastjson.JSONObject;
import com.dtdhehe.ptulife.entity.PtuNews;
import com.dtdhehe.ptulife.entity.PtuUser;
import com.dtdhehe.ptulife.service.NewsService;
import com.dtdhehe.ptulife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private NewsService newsService;

    /**
     * 返回我的资料页面
     * @return
     */
    @RequestMapping("/getMyInformation")
    public String getMyInformation(HttpServletRequest request,Model model){
        //查出当前登录用户
        PtuUser ptuUser = (PtuUser) request.getSession().getAttribute("loginUser");
        ptuUser = userService.findOne(ptuUser.getUserId());
        logger.info("当前用户是:"+ptuUser);
        model.addAttribute("currentUser",ptuUser);
        return "myInformation";
    }

    @RequestMapping("/getFormInfo")
    public String getFormInfo(HttpServletRequest request,Model model){
        //查出当前登录用户
        PtuUser ptuUser = (PtuUser) request.getSession().getAttribute("loginUser");
        ptuUser = userService.findOne(ptuUser.getUserId());
        logger.info("当前用户是:"+ptuUser);
        model.addAttribute("currentUser",ptuUser);
        String infoName = request.getParameter("infoName");
        if ("baseInfo".equals(infoName) || "myInformation".equals(infoName)){
            return "baseFormInfo";
        }else if ("otherInfo".equals(infoName)){
            return "otherFormInfo";
        }else if ("pwdInfo".equals(infoName)){
            return "pwdFormInfo";
        }else if ("myNews".equals(infoName)){
            return "myNewsTable";
        }
        return "";
    }

    @RequestMapping("/getNewsTable")
    @ResponseBody
    public JSONObject getNewsTable(HttpServletRequest request,Integer rows,Integer page,String newsTitle){
        //查出当前登录用户
        PtuUser ptuUser = (PtuUser) request.getSession().getAttribute("loginUser");
        logger.info("当前用户是:"+ptuUser);
        //对查询条件判断是否为空
        if (StringUtils.isEmpty(newsTitle)){
            newsTitle = "";
        }
        try {
            Pageable pageable = PageRequest.of(page,rows,Sort.Direction.DESC,"newsDate");
            Page<PtuNews> newsPage = newsService.queryNewsByUserId(ptuUser.getUserId(),newsTitle,pageable);
            List<PtuNews> newsList = newsPage.getContent();
            long total = newsPage.getTotalElements();
            Map map = new HashMap();
            map.put("total",total);
            map.put("rows",newsList);
            JSONObject json = new JSONObject(map);
            return json;
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return null;
    }

}
