package com.dtdhehe.ptulife.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Create By Xie_东
 * on 2019/3/13 16:35
 * @author admin
 */
public class MailUtils {

    /**
     * 根据用户id返回激活邮件html模板
     * @param code
     * @return
     */
    public static String getValidHtml(String code,HttpServletRequest request){
        StringBuffer requestURL = request.getRequestURL();
        String methodPath = request.getRequestURI();
        //获得项目访问根路径
        String urlPath = new String(requestURL).replace(methodPath,"");
        String htmls = "<html>\n" +
                "<body>\n" +
                "<h1>欢迎注册校园生活通：</h1>" +
                "<h3 style='margin:20px 0 0 30px'>请点击<a href='"+urlPath+"/ptu/registUserController/validUser?userId="+code+"'>此处</a>激活账号。</h3>" +
                "</body>\n</html>";
        return htmls;
    }

}
