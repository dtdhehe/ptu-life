package com.dtdhehe.ptulife.service;


import javax.mail.MessagingException;

/**
 * Create By Xie_东
 * on 2019/3/9 20:07
 */
public interface MailService {

    /**
     * 发送简单文本邮件
     * @param to        :接收者
     * @param subject   :主题
     * @param content   :内容
     */
    void sendSimpleMail(String to, String subject, String content);


    /**
     * 发送html邮件
     * @param to        :接收者
     * @param subject   :主题
     * @param content   :内容
     * @throws Exception :异常处理
     */
    void sendHtmlMail(String to, String subject, String content) throws Exception;

    /**
     * 发送带附件的邮件
     * @param to        :接收者
     * @param subject   :主题
     * @param content   :内容
     * @param filePath   :文件地址
     */
    void sendAttachmentMail(String to, String subject, String content,String filePath) throws MessagingException;

    /**
     * 发送内容含图片的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    void sendInlineResourceMail(String to, String subject, String content,
                               String rscPath,String rscId) throws MessagingException;
}
