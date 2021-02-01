package io.wilson.email;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

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
    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Test
    public void tmp() throws InterruptedException {
        System.out.println(new Date());
        threadPoolTaskScheduler.schedule(() -> System.out.println("after 15s:" + new Date()),
                DateUtils.addSeconds(new Date(),15));
        Thread.sleep(40 * 1000);

    }

    @Test
    public void sendOutLookEmail() throws MessagingException, IOException {
        emailService.sendSimpleMail("subject", "test\r\ntest", "Weixuan.He@kuka.com");
     /*   emailService.sendHtmlMail("subject", "<html><body><I>Hello World</I></body></html>", mailSender.getUsername());
        emailService.sendAttachmentsMail("subject", "<html><body><I>Hello World with attachment</I></body></html>",
                mailSender.getUsername());*/
    }

    public static LocalDateTime setTime(LocalDateTime time, String timeValuePattern) {
        String[] timeValue = timeValuePattern.split(":");
        return time
                .withHour(Integer.parseInt(timeValue[0]))
                .withMinute(Integer.parseInt(timeValue[1]))
                .withSecond(Integer.parseInt(timeValue[2]))
                .truncatedTo(ChronoUnit.SECONDS);
    }

    private static Date parseHourPattern(Date date, String hourPattern) {
        date = org.apache.commons.lang3.time.DateUtils.truncate(date, Calendar.SECOND);
        String[] timeValue = hourPattern.split(":");
        date = org.apache.commons.lang3.time.DateUtils.setHours(date, Integer.parseInt(timeValue[0]));
        date = org.apache.commons.lang3.time.DateUtils.setMinutes(date, Integer.parseInt(timeValue[1]));
        date = org.apache.commons.lang3.time.DateUtils.setSeconds(date, Integer.parseInt(timeValue[2]));
        return date;
    }

    @Test
    public void sendOutLookAttachmentEmail() throws MessagingException, IOException {
        /*emailService.sendSimpleMail("subject", "test", mailSender.getUsername());
        emailService.sendHtmlMail("subject", "<html><body><I>Hello World</I></body></html>", mailSender.getUsername());
        emailService.sendAttachmentsMail("subject", "<html><body><I>Hello World with attachment</I></body></html>",
                mailSender.getUsername());*/
        emailService.sendAttachmentMail("subject", "<html><body><I>Hello World with attachment</I></body></html>",
                "/info.log", "Weixuan.He@kuka.com");
    }

}
