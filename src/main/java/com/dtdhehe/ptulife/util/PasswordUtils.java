package com.dtdhehe.ptulife.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 密码加密
 * crate By:dtd
 * date:2018-10-31
 * 利用MD5给用户密码加密
 */
public class PasswordUtils {

    //盐：dtdhehe
    private static final String SALT = "dtdhehe";

    public static String getPWD(String userPwd){
        return new Md5Hash(userPwd,SALT).toString();
    }
}
