package com.dtdhehe.ptulife.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Create By Xie_东
 * on 2018/12/18 15:48
 */
@Entity
public class HotLabel {

    @Id
    private String labelId;

    private String orgId;

    private String labelTitle;

    private Integer labelHot;

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(String labelTitle) {
        this.labelTitle = labelTitle;
    }

    public Integer getLabelHot() {
        return labelHot;
    }

    public void setLabelHot(Integer labelHot) {
        this.labelHot = labelHot;
    }
}
