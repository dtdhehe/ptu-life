package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.PtuUser;
import com.dtdhehe.ptulife.service.UserService;
import com.dtdhehe.ptulife.util.CheckUserUtils;
import com.dtdhehe.ptulife.util.KeyUtils;
import com.dtdhehe.ptulife.util.PasswordUtils;
import com.dtdhehe.ptulife.vo.ResultVO;
import com.dtdhehe.ptulife.vo.UserRegistVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户注册
 * crate By:dtdhehe
 * date:2018-10-29
 */
@RestController
@RequestMapping("/ptu/registUserController")
public class RegistUserController {

    private final Logger logger = LoggerFactory.getLogger(RegistUserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public ResultVO regist(UserRegistVO userRegistVO) {
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
                resultVO.setStatus("0");
                resultVO.setError_msg("注册成功");
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            resultVO.setError_msg(e.getMessage());
        }
        return resultVO;
    }
}
