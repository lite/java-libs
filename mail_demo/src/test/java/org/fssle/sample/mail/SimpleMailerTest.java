package org.fssle.sample.mail;

import org.junit.Test;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class SimpleMailerTest {

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_when_failed_to_send_mail() {
        SimpleMailer mailer = new SimpleMailer();
        mailer.setMailSender(createMailSender("smtp.163.com", "", ""));
        Mail mail = createMail("from@email.com", "to@email.com", "replyTo@email.com", "subject", "text");
        mailer.send(mail);
    }

    @Test
    public void should_send_mail() {
        SimpleMailer mailer = new SimpleMailer();
        mailer.setMailSender(createMailSender("smtp.163.com", "twtwtest2011@163.com", "123456"));
        Mail mail = createMail("twtwtest2011@163.com", "to@email.com", "replyTo@email.com", "subject", "text");
        mailer.send(mail);
    }

    private MailSender createMailSender(String host, String username, String password) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        Properties prop = new Properties();
        prop.setProperty("mail.smtp.auth", "true");
        mailSender.setJavaMailProperties(prop);
        return mailSender;
    }

    private Mail createMail(String from, String to, String replyTo, String subject, String text) {
        return new Mail(from, replyTo, to, subject, text);
    }
}
