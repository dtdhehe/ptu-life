package com.dtdhehe.ptulife.repository;

import com.dtdhehe.ptulife.entity.Approval;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Create By Xie_东
 * on 2019/4/4 15:16
 * @author admin
 */
public interface ApprovalRepository extends JpaRepository<Approval,String> {

    /**
     * 根据用户id查询全部申请记录
     * @param userId
     * @param approvalType
     * @param pageable
     * @return
     */
    @Query(value = "select t from Approval t where t.userId=?1 and t.approvalType like %?2%")
    Page<Approval> findByUserId(String userId, String approvalType, Pageable pageable);

    /**
     * 根据用户邮箱查询全部待审核记录
     * @param email
     * @param approvalType
     * @param pageable
     * @return
     */
    @Query(value = "select t from Approval t where t.verifyEmail=?1 and t.approvalType like %?2%")
    Page<Approval> findByEmail(String email, String approvalType, Pageable pageable);

}
