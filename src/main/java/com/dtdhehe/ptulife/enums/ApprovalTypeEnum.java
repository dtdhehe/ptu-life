package com.dtdhehe.ptulife.enums;

/**
 * Create By Xie_东
 * on 2019/4/4 16:44
 */
public enum ApprovalTypeEnum {
    LEAVE("0","请假"),
    ROOM("1","教室"),
    LAB("2","社团")
    ;
    private String typeCode;
    private String typeText;

    ApprovalTypeEnum(String typeCode, String typeText) {
        this.typeCode = typeCode;
        this.typeText = typeText;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }
}
