package com.example.mail.mail.service;

import com.example.mail.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    private String toAddr = "731734107@qq.com";

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail(toAddr, "test simple mail", " hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(toAddr, "test simple mail", content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath = "C:\\Users\\quanzaiyu\\OneDrive\\我的\\logo.png";
        mailService.sendAttachmentsMail(toAddr, "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "xiaoyu";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\quanzaiyu\\OneDrive\\我的\\logo.png";
        mailService.sendInlineResourceMail("731734107@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("name", "categories");
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail("731734107@qq.com","主题：这是模板邮件", emailContent);
    }
}
