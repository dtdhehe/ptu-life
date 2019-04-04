package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.Approval;

/**
 * Create By Xie_东
 * on 2019/4/4 15:17
 */
public interface ApprovalService {

    /**
     * 保存审批记录
     * @param approval
     * @return
     */
    Approval save(Approval approval);

}
