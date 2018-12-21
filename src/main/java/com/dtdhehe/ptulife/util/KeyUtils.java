package com.dtdhehe.ptulife.util;

import java.util.UUID;

/**
 * 用户主键生成
 * crate By:dtdhehe
 * date:2018-10-30
 * @author admin
 */
public class KeyUtils {
    public static synchronized String getUniqueKey() {
        //取前8位为用户主键
        String uuid = UUID.randomUUID().toString().substring(0,8);
        return uuid;
    }

    public static void main(String[] args) {
        String s = getUniqueKey();
        System.out.println(s);
    }
}
