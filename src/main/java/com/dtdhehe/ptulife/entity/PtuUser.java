package com.dtdhehe.ptulife.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户实体类
 * crate By：dtehehe
 * date:2018-10-29
 */
@Entity
public class PtuUser {

    //用户主键      必须      int
    @Id
    private String userId;
    //用户名       必须      text
    private String userName;
    //用户密码      必须      text
    private String userPwd;
    //用户身份标识    必须     int    0:学生  1:教师   2:职工
    private Integer userStatus;
    //用户所属机构    必须      text
    private String orgName;
    /**
     * 所属机构代码
     */
    private String orgStatus;

    //用户性别      必须      int     0：男     1：女
    private Integer userSex;
    //用户真实姓名    非必须
    private String trueName;
    //用户手机号码       非必须
    private String mobileNum;
    //用户qq号     非必须
    private String qqNum;
    //用户微信号     非必须
    private String wechatNum;

    private String nickName;

    private String motto;

    @Override
    public String toString() {
        return "PtuUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userStatus=" + userStatus +
                ", orgName='" + orgName + '\'' +
                ", orgStatus='" + orgStatus + '\'' +
                ", userSex=" + userSex +
                ", trueName='" + trueName + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", qqNum='" + qqNum + '\'' +
                ", wechatNum='" + wechatNum + '\'' +
                ", nickName='" + nickName + '\'' +
                ", motto='" + motto + '\'' +
                '}';
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getWechatNum() {
        return wechatNum;
    }

    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum;
    }
}
