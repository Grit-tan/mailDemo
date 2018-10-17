package com.grit.learning.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("test_mail@126.com", "这是一封简单邮件",
                "大家好，这是我的第一封邮件！");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("test_mail@126.com", "test simple mail", content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath = "e:\\temp\\temp.txt";
        mailService.sendAttachmentsMail("test_mail@126.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "grit009";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "e:\\temp\\\\SpringBoot.jpg";

        mailService.sendInlineResourceMail("test_mail@126.com", "主题：这是有图片的邮件", content, imgPath,
                rscId);
    }
}
