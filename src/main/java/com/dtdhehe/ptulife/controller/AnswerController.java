package com.dtdhehe.ptulife.controller;

import com.alibaba.fastjson.JSONObject;
import com.dtdhehe.ptulife.entity.PtuAnswer;
import com.dtdhehe.ptulife.entity.PtuUser;
import com.dtdhehe.ptulife.service.AnswerService;
import com.dtdhehe.ptulife.service.UserService;
import com.dtdhehe.ptulife.util.DateUtils;
import com.dtdhehe.ptulife.util.KeyUtils;
import com.dtdhehe.ptulife.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Create By Xie_东
 * on 2019/2/25 15:30
 * @author dtdhehe
 */
@Controller
@RequestMapping("/answer/answerController")
public class AnswerController {

    private final Logger logger = LoggerFactory.getLogger(AnswerController.class);

    @Autowired
    private AnswerService answerService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getEditAnswer")
    public String getEditAnswer(HttpServletRequest request, Model model){
        //查出当前登录用户
        PtuUser ptuUser = (PtuUser) request.getSession().getAttribute("loginUser");
        ptuUser = userService.findOne(ptuUser.getUserId());
        model.addAttribute("date",DateUtils.getCurrentDate());
        model.addAttribute("currentUser",ptuUser);
        return "/answer/editAnswer";
    }

    /**
     * 保存新闻
     * @return
     */
    @RequestMapping("/saveAnswer")
    @ResponseBody
    public ResultVO saveAnswer(@RequestParam(name = "answer",required = false)String answerObject){
        JSONObject jsonObject = JSONObject.parseObject(answerObject);
        logger.info("开始保存新闻");
        ResultVO resultVO = new ResultVO();
        try {
            PtuAnswer ptuAnswer = new PtuAnswer();
            ptuAnswer.setAnswerId(KeyUtils.getUniqueKey());
            ptuAnswer.setAnswerAuthor((String) jsonObject.get("author"));
            ptuAnswer.setAnswerTitle((String) jsonObject.get("title"));
            ptuAnswer.setAnswerDesc((String) jsonObject.get("content"));
            ptuAnswer.setAnswerDate(DateUtils.getCurrentDateTime());
            ptuAnswer.setUserId((String) jsonObject.get("userId"));
            PtuAnswer answerNew = answerService.save(ptuAnswer);
            if (answerNew != null){
                resultVO.setStatus("0");
                resultVO.setObject(answerNew);
            }else {
                logger.error("问答保存失败");
                resultVO.setStatus("1");
                resultVO.setError_msg("answerNew对象为空");
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            resultVO.setError_msg(e.getMessage());
        }
        return resultVO;
    }

}
