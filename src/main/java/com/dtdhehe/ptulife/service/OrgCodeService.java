package com.dtdhehe.ptulife.service;

/**
 * Create By Xie_东
 * on 2019/2/28 15:15
 */
public interface OrgCodeService {

    /**
     * 根据机构编码查找机构名称
     * @param orgStatus
     * @return
     */
    String getOrgNameByOrgStatus(String orgStatus);

}
