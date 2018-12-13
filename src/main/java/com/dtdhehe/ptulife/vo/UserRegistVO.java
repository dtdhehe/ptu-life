package com.dtdhehe.ptulife.vo;

/**
 * 用户注册传递对象
 */
public class UserRegistVO {

    private String userName;

    private String userPwd;

    private String userSex;

    private String userStatus;

    private String orgName;

    @Override
    public String toString() {
        return "UserRegistVO{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}