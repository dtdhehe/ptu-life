package com.dtdhehe.ptulife.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Create By Xie_东
 * on 2019/4/4 15:06
 * @author dtdhehe
 */
@Entity
public class Approval {

    @Id
    private String id;

    private String createTime;

    private String userId;

    private String approvalType;

    private String approvalName;

    private String approvalTime;

    private String phone;

    private String approvalRoom;

    private String approvalReason;

    private String media;

    private String approvalDays;

    private String verifyName;

    private String verifyEmail;

    private String status;

    @Override
    public String toString() {
        return "Approval{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userId='" + userId + '\'' +
                ", approvalType='" + approvalType + '\'' +
                ", approvalName='" + approvalName + '\'' +
                ", approvalTime='" + approvalTime + '\'' +
                ", phone='" + phone + '\'' +
                ", approvalRoom='" + approvalRoom + '\'' +
                ", approvalReason='" + approvalReason + '\'' +
                ", media='" + media + '\'' +
                ", approvalDays='" + approvalDays + '\'' +
                ", verifyName='" + verifyName + '\'' +
                ", verifyEmail='" + verifyEmail + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getApprovalRoom() {
        return approvalRoom;
    }

    public void setApprovalRoom(String approvalRoom) {
        this.approvalRoom = approvalRoom;
    }

    public String getApprovalReason() {
        return approvalReason;
    }

    public void setApprovalReason(String approvalReason) {
        this.approvalReason = approvalReason;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getApprovalDays() {
        return approvalDays;
    }

    public void setApprovalDays(String approvalDays) {
        this.approvalDays = approvalDays;
    }

    public String getVerifyName() {
        return verifyName;
    }

    public void setVerifyName(String verifyName) {
        this.verifyName = verifyName;
    }

    public String getVerifyEmail() {
        return verifyEmail;
    }

    public void setVerifyEmail(String verifyEmail) {
        this.verifyEmail = verifyEmail;
    }
}
