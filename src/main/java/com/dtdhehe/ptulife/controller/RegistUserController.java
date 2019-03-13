package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.PtuUser;
import com.dtdhehe.ptulife.service.MailService;
import com.dtdhehe.ptulife.service.UserService;
import com.dtdhehe.ptulife.util.MailUtils;
import com.dtdhehe.ptulife.util.PasswordUtils;
import com.dtdhehe.ptulife.vo.ResultVO;
import com.dtdhehe.ptulife.vo.UserRegistVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户注册
 * crate By:dtdhehe
 * date:2018-10-29
 */
@Controller
@RequestMapping("/ptu/registUserController")
public class RegistUserController {

    private final Logger logger = LoggerFactory.getLogger(RegistUserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    /**
     * 注册用户
     * @param userRegistVO
     * @return
     */
    @RequestMapping("/regist")
    @ResponseBody
    public ResultVO regist(UserRegistVO userRegistVO, HttpServletRequest request) {
        logger.info("传入的对象为："+userRegistVO);
        PtuUser resultUser;
        ResultVO resultVO = new ResultVO();
        try {
            logger.info("用户输入密码为:" + userRegistVO.getUserPwd());
            //给用户密码加密
            userRegistVO.setUserPwd( PasswordUtils.getPWD(userRegistVO.getUserPwd()));
            logger.info("用户密码加密后为:" + userRegistVO.getUserPwd());
            resultUser = userService.save(userRegistVO);
            logger.info("处理后的用户为:" + resultUser);
            //判断存入是否成功，封装返回对象
            if (resultUser != null) {
                //注册成功后发送邮件
                String htmls = MailUtils.getValidHtml(resultUser.getUserId(),request);
                mailService.sendHtmlMail(resultUser.getEmail(),"激活邮件",htmls);
                resultVO.setStatus("0");
                resultVO.setError_msg("注册成功");
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            resultVO.setError_msg("注册失败");
        }
        return resultVO;
    }

    /**
     * 激活账户
     * @param userId
     * @return
     */
    @RequestMapping("/validUser")
    public String validUser(@RequestParam("userId") String userId){
        //激活用户
        return "index/login";
    }

}
