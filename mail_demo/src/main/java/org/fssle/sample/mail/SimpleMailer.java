package org.fssle.sample.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

public class SimpleMailer implements Mailer {
    private MailSender mailSender;

    @Autowired
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void send(Mail mail) {
        sendMail(mail);
    }

    @Async
    private void sendMail(Mail mail){
        mailSender.send(toMailMessage(mail));
    }

    private SimpleMailMessage toMailMessage(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mail.getFrom());
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setReplyTo(mail.getReplyTo());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getText());
        return simpleMailMessage;
    }
}
