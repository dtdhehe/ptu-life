package com.dtdhehe.ptulife.enums;

/**
 * crate By:dtdhehe
 * date:2018-10-31
 */
public enum UserStatusEnum {

    Stu(0,"学生"),
    Tea(1,"教师"),
    Wor(2,"职工")
    ;
    private Integer code;

    private String message;

    UserStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
