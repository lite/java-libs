package org.fssle.sample.mail;

import java.util.HashMap;
import java.util.Map;

public class MailShareForm implements MailForm {
    private String senderName;
    private String replyTo;
    private String to;
    private String subject;
    private String message;
    private String imageUrl;

    public MailShareForm() {
        this("");
    }

    public MailShareForm(String imageUrl) {
        this("", "", "", "", "", imageUrl);
    }

    public MailShareForm(String senderName, String replyTo, String to, String subject, String message, String imageUrl) {
        this.senderName = senderName;
        this.replyTo = replyTo;
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.imageUrl = imageUrl;
    }

    @Override
    public MailErrors validate() {
        MailValidator mailValidator = new MailValidator();
        String emptyMessage = "Please input email address";
        String notEmailMessage = "Invalid email address";
        mailValidator.validateEmail("replyTo", replyTo, emptyMessage, notEmailMessage);
        mailValidator.validateEmail("to", to, emptyMessage, notEmailMessage);
        return mailValidator.getErrors();
    }

    @Override
    public Mail toMail(String from, String text) {
        return new Mail(from, replyTo, to, subject, text);
    }

    @Override
    public Map<String, String> getModel() {
        Map<String, String> model = new HashMap();
        model.put("imageUrl", imageUrl);
        model.put("senderName", senderName);
        model.put("message", message);
        return model;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getTo() {
        return to;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
