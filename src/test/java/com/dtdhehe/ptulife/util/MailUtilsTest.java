package com.dtdhehe.ptulife.util;

import com.dtdhehe.ptulife.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

import static org.junit.Assert.*;

/**
 * Create By Xie_东
 * on 2019/3/9 19:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailUtilsTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("dtdhehe@sina.com","第一封简单邮件","简单邮件的正文内容");
    }

    @Test
    public void sendHtmlMail() throws Exception {
        String htmls = "<html>\n" +
                "<body>\n<h3>点击下方链接激活账号</h3>" +
                "<a href=''>激活</a>" +
                "</body>\n</html>";
        mailService.sendHtmlMail("dtdhehe@sina.com","第一封Html邮件",htmls);
    }

    @Test
    public void sendAttachmentMail() throws MessagingException {
        String filePath = "D:/wechatfile/创新班照片.zip";
        mailService.sendAttachmentMail("1579475437@qq.com","带附件的邮件","带附件的哟!",filePath);
    }

    @Test
    public void sendInlineResourceMail() throws MessagingException {
        String filePath = "C:/Users/admin/Desktop/lss.jpg";
        String rscId = "img001";
        String htmls = "<html>" +
                "<body>" +
                "<h1>这是带图片的邮件</h1>" +
                "<img src=\'cid:"+rscId+"\' />" +
                "</body>" +
                "</html>";
        mailService.sendInlineResourceMail("1579475437@qq.com","图片邮件",htmls,filePath,rscId);
    }

}