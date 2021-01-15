package io.wilson.email;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author Wilson
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    @NonNull
    private final JavaMailSenderImpl mailSender;
    private static final String OR = "|";
    @Value("${spring.mail.file-path-prefix}")
    private String pathPrefix;

    @PostConstruct
    public void init() throws MessagingException, IOException {
        //sendHtmlMail("邮件测试", "<html><body><b><I>html test content</I></b></body></html>", mailSender.getUsername(), mailSender.getUsername());
    }

    public void sendSimpleMail(String subject, String content, String... recipients) throws MessagingException {
        MimeMessage message = buildMessage(subject, recipients);
        message.setText(content);
        mailSender.send(message);
    }

    public void sendHtmlMail(String subject, String content, String... recipients) throws MessagingException {
        MimeMessage message = buildMessage(subject, recipients);
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setText(content, true);
        mailSender.send(message);
    }

    public void sendAttachmentsMail(String subject, String content, String... recipients) throws MessagingException, IOException {
        MimeMessage message = buildMessage(subject, recipients);
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = patternResolver.getResource("classpath:application.yml");
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setText(content, true);
        messageHelper.addAttachment("application.yml", resource.getFile());
        mailSender.send(message);
    }


    public void sendAttachmentMail(String subject, String content, String fileLocation, String... recipients) throws MessagingException, IOException {
        MimeMessage message = buildMessage(subject, recipients);
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        String filePath = pathPrefix + fileLocation;
        File file = new File(filePath);
        //Resource resource = patternResolver.getResource(fileLocation);
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setText(content, true);
        messageHelper.addAttachment(Objects.requireNonNull(file.getName()), file);
        mailSender.send(message);
    }

    public void sendAttachmentsMail(String subject, String content, List<String> classpathFileLocations, String... recipients) throws MessagingException, IOException {
        Assert.notEmpty(classpathFileLocations, "file location cannot be empty");
        MimeMessage message = buildMessage(subject, recipients);
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        String pattern = classpathFileLocations.stream()
                .reduce((locationA, locationB) -> StringUtils.join(
                        ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX, locationA, OR,
                        ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX, locationB))
                .orElse("");
        Resource[] resources = patternResolver.getResources(pattern);
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
        messageHelper.setText(content, true);
        for (Resource resource : resources) {
            messageHelper.addAttachment(Objects.requireNonNull(resource.getFilename()), resource.getFile());
        }
        mailSender.send(message);
    }

    private MimeMessage buildMessage(String subject, String... recipients) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom(Objects.requireNonNull(mailSender.getUsername()));
        for (String recipient : recipients) {
            message.addRecipients(Message.RecipientType.TO, recipient);
        }
        message.setSubject(subject);
        return message;
    }

}
