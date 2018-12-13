package com.dtdhehe.ptulife.enums;

/**
 * 用户性别枚举
 * crate By:dtdhehe
 * date:2018-10-29
 */
public enum  UserSexEnum {

    WOMAN(1,"女"),
    MAN(0,"男")
    ;
    /**
     * 用户性别代码
     */
    private Integer code;

    /**
     * 用户性别
     */
    private String sex;

    UserSexEnum(Integer code, String sex) {
        this.code = code;
        this.sex = sex;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
