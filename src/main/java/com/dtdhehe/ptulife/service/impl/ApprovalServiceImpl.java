package com.dtdhehe.ptulife.service.impl;

import com.dtdhehe.ptulife.entity.Approval;
import com.dtdhehe.ptulife.repository.ApprovalRepository;
import com.dtdhehe.ptulife.service.ApprovalService;
import com.dtdhehe.ptulife.util.DateUtils;
import com.dtdhehe.ptulife.util.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By Xie_东
 * on 2019/4/4 15:18
 * @author admin
 */
@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    @Override
    public Approval save(Approval approval) {
        if (approval == null){
            approval = new Approval();
        }
        approval.setId(KeyUtils.getUniqueKey());
        approval.setCreateTime(DateUtils.getCurrentDateTime());
        approval.setApprovalTime(DateUtils.viewType2Date(approval.getApprovalTime()));
        approval.setStatus("0");
        return approvalRepository.save(approval);
    }
}
