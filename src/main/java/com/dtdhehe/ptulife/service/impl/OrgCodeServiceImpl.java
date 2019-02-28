package com.dtdhehe.ptulife.service.impl;

import com.dtdhehe.ptulife.entity.OrgCode;
import com.dtdhehe.ptulife.repository.OrgCodeRepository;
import com.dtdhehe.ptulife.service.OrgCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By Xie_东
 * on 2019/2/28 15:18
 */
@Service
public class OrgCodeServiceImpl implements OrgCodeService {

    @Autowired
    private OrgCodeRepository orgCodeRepository;

    @Override
    public String getOrgNameByOrgStatus(String orgStatus) {
        OrgCode org = orgCodeRepository.findByOrOrgStatus(orgStatus);
        return org.getOrgName();
    }
}
