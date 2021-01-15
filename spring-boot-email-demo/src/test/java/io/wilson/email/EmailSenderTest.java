package io.wilson.email;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileSystemUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.IOException;
import java.nio.file.FileSystem;

/**
 * @author Wilson
 */
@SpringBootTest(classes = EmailApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailSenderTest {
    @Resource
    private EmailService emailService;
    @Resource
    private JavaMailSenderImpl mailSender;
    @Value("${spring.mail.file-path-prefix}")
    private String pathPrefix;

    @Test
    public void sendOutLookEmail() throws MessagingException, IOException {
        /*emailService.sendSimpleMail("subject", "test", mailSender.getUsername());
        emailService.sendHtmlMail("subject", "<html><body><I>Hello World</I></body></html>", mailSender.getUsername());
        emailService.sendAttachmentsMail("subject", "<html><body><I>Hello World with attachment</I></body></html>",
                mailSender.getUsername());*/
        emailService.sendAttachmentMail("subject", "<html><body><I>Hello World with attachment</I></body></html>",
                "/info.log", mailSender.getUsername());
    }

    public static void main(String[] args) {

    }
}
