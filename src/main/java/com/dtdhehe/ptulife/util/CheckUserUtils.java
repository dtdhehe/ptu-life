package com.dtdhehe.ptulife.util;

import com.dtdhehe.ptulife.enums.UserSexEnum;
import com.dtdhehe.ptulife.enums.UserStatusEnum;

/**
 * 判断用户状态
 * crate By:dtd
 * date:2018-10-31
 *
 */
public class CheckUserUtils {

    //检验性别
    public static Integer checkSex(String userSex){
        if (userSex.equals(UserSexEnum.WOMAN.getSex())) {
            return 1;
        }
        return 0;
    }
    //检验用户身份标识
    public static Integer checkStatus(String userStatus){
        if (userStatus == null || userStatus.equals("")){
            return 0;
        }
        if (userStatus.equals(UserStatusEnum.Wor.getMessage())) {
            return 2;
        }else if (userStatus.equals(UserStatusEnum.Tea.getMessage())){
            return 1;
        }
        return 0;
    }
}
