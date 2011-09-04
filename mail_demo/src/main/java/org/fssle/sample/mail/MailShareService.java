package org.fssle.sample.mail;

public class MailShareService extends MailService{
    public MailShareService() {
        TemplateMailMessageBuilder mailMessageBuilder = new TemplateMailMessageBuilder();
        mailMessageBuilder.setTemplate("share_mail.ftl");
        setMailMessageBuilder(mailMessageBuilder);
    }
}
