package com.dtdhehe.ptulife.repository;

import com.dtdhehe.ptulife.entity.OrgCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create By Xie_东
 * on 2019/2/28 15:14
 */
public interface OrgCodeRepository extends JpaRepository<OrgCode, String> {

    /**
     * 根据orgStatus返回org对象
     * @param orgStatus
     * @return
     */
    OrgCode findByOrOrgStatus(String orgStatus);

}
