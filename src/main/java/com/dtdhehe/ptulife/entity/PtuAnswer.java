package com.dtdhehe.ptulife.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Create By Xie_东
 * on 2019/2/25 15:18
 */
@Entity
public class PtuAnswer {
    @Id
    private String answerId;

    private String answerTitle;

    private String answerDesc;

    private String answerAuthor;

    private String answerDate;

    private String answerHot;

    private String userId;

    private String answerIcon;

    public String getAnswerIcon() {
        return answerIcon;
    }

    public void setAnswerIcon(String answerIcon) {
        this.answerIcon = answerIcon;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }

    public String getAnswerDesc() {
        return answerDesc;
    }

    public void setAnswerDesc(String answerDesc) {
        this.answerDesc = answerDesc;
    }

    public String getAnswerAuthor() {
        return answerAuthor;
    }

    public void setAnswerAuthor(String answerAuthor) {
        this.answerAuthor = answerAuthor;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }

    public String getAnswerHot() {
        return answerHot;
    }

    public void setAnswerHot(String answerHot) {
        this.answerHot = answerHot;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
