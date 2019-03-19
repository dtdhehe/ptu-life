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

    private String postId;

    private String labelTitle;

    private Integer labelHot;

    public HotLabel() {
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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
