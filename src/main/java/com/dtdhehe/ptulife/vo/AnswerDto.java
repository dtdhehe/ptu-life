package com.dtdhehe.ptulife.vo;

import com.dtdhehe.ptulife.entity.PtuAnswer;

/**
 * Create By Xie_东
 * on 2019/4/24 14:40
 */
public class AnswerDto {
    private String answerId;

    private String answerTitle;

    private String answerDesc;

    private String answerAuthor;

    private String answerDate;

    private String answerHot;

    private String userId;

    private String answerIcon;

    private String headImg;

    public AnswerDto(PtuAnswer ptuAnswer, String headImg) {
        this.answerId = ptuAnswer.getAnswerId();
        this.answerAuthor = ptuAnswer.getAnswerAuthor();
        this.answerDate = ptuAnswer.getAnswerDate();
        this.answerDesc = ptuAnswer.getAnswerDesc();
        this.answerHot = ptuAnswer.getAnswerHot();
        this.answerIcon = ptuAnswer.getAnswerIcon();
        this.answerTitle = ptuAnswer.getAnswerTitle();
        this.userId = ptuAnswer.getUserId();
        this.headImg = headImg;
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

    public String getAnswerIcon() {
        return answerIcon;
    }

    public void setAnswerIcon(String answerIcon) {
        this.answerIcon = answerIcon;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
