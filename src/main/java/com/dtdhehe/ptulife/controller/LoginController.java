package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.PtuUser;
import com.dtdhehe.ptulife.service.UserService;
import com.dtdhehe.ptulife.util.PasswordUtils;
import com.dtdhehe.ptulife.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Create By Xie_东
 * on 2019/2/13 17:28
 * @author dtdhehe
 */
@Controller
@RequestMapping("/login/loginController")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultVO login(HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        logger.info("用户登录");
        String userName = request.getParameter("username");
        String realPwd = request.getParameter("password");
        logger.info("用户输入的用户名和密码:"+userName+";"+realPwd);
        //对密码进行加密
        String userPwd = PasswordUtils.getPWD(realPwd);
        logger.info("用户加密后的密码:"+userPwd);
        PtuUser ptuUser = userService.findByUserNameAndUserPwd(userName,userPwd);
        if (ptuUser != null){
            if ("0".equals(ptuUser.getValid())){
                resultVO.setStatus("1");
                resultVO.setError_msg("该用户尚未激活");
                return resultVO;
            }
            request.getSession().setAttribute("loginUser",ptuUser);
            resultVO.setStatus("0");
            resultVO.setObject(ptuUser);
        }else {
            logger.error("用户名或密码错误");
            resultVO.setStatus("1");
            resultVO.setError_msg("用户名或密码错误");
        }
        return resultVO;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        logger.info("清除session中登录的用户");
        HttpSession session = request.getSession();
        if (session != null){
            session.removeAttribute("loginUser");
        }
        return "login";
    }

}
