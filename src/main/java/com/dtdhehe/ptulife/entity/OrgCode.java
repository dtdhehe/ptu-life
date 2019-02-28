package com.dtdhehe.ptulife.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Create By Xie_东
 * on 2019/2/28 15:12
 */
@Entity
public class OrgCode {

    @Id
    private Integer id;

    private String orgStatus;

    private String orgName;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
