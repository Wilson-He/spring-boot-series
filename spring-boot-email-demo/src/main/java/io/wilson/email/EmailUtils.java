package io.wilson.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Wilson
 */
public class EmailUtils {
    static String USERNAME = "Weixuan.He@kuka.com";
    static String PASSWORD = "!Wilson0";
    static String HOST_NAME = "smtp.office365.com";

    public static void main(String[] args) {
        sendSMTPMail(USERNAME,"test email", "test email");
    }

    public static boolean sendSMTPMail(String to, String text, String title) {
        String protocol = "smtp";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST_NAME);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.protocol", protocol);
        props.put("mail.smtp.user", USERNAME);
        props.put("mail.smtp.password", PASSWORD);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USERNAME, PASSWORD);
                    }
                });
        session.setDebug(true);
        //props.put("mail.smtp.socketFactory.fallback", "false");
        try {
            // 创建邮件消息
            MimeMessage message = new MimeMessage(session);
            // 设置发件人
            InternetAddress form = new InternetAddress(USERNAME);
            message.setFrom(form);
            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            // 设置邮件标题
            message.setSubject(title);
            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
