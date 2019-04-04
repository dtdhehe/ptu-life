package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.Approval;
import com.dtdhehe.ptulife.enums.ApprovalTypeEnum;
import com.dtdhehe.ptulife.service.ApprovalService;
import com.dtdhehe.ptulife.service.MailService;
import com.dtdhehe.ptulife.util.MailUtils;
import com.dtdhehe.ptulife.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create By Xie_东
 * on 2019/4/3 11:16
 * @author dtdhehe
 */
@Controller
@RequestMapping("/approval/approvalController")
public class ApprovalController {

    private final Logger logger = LoggerFactory.getLogger(ApprovalController.class);

    @Autowired
    private ApprovalService approvalService;

    @Autowired
    private MailService mailService;

    @RequestMapping("/getApproval")
    public String getApproval(){
        return "approval/approval";
    }

    @RequestMapping("/getLeave")
    public String getLeave(){
        return "approval/type/leave";
    }

    @RequestMapping("/saveApproval")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ResultVO saveApproval(Approval approval){
        ResultVO resultVO = new ResultVO();
        try {
            logger.info("保存审批记录");
            approval = approvalService.save(approval);
            logger.info("审批记录保存成功,approval = "+approval);
            //保存成功后，发送邮件给审核人邮箱
            String htmls = MailUtils.getApprovalHtml(approval.getApprovalType());
            mailService.sendHtmlMail(approval.getVerifyEmail(),"审核邮件",htmls);
            logger.info("邮件发送成功");
            resultVO.setStatus("0");
            resultVO.setError_msg("审批成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            resultVO.setError_msg("审批失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return resultVO;
    }

}
