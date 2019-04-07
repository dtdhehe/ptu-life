package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.Approval;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    /**
     * 根据用户id查询全部申请记录
     * @param userId
     * @param approvalType
     * @param pageable
     * @return
     */
    Page<Approval> queryApprovalByUserId(String userId, String approvalType, Pageable pageable);

    /**
     * 根据用户邮箱查询全部待审核记录
     * @param email
     * @param approvalType
     * @param pageable
     * @return
     */
    Page<Approval> queryApprovalByEmail(String email, String approvalType, Pageable pageable);

    /**
     * 根据id通过审核
     * @param id
     */
    void doPass(String id);

    /**
     * 根据id拒绝审核
     * @param id
     */
    void doRefuse(String id);

}
