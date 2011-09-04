package org.fssle.sample.mail;

public class Mail {
    private String from;
    private String replyTo;
    private String to;
    private String subject;
    private String text;

    public Mail(String from, String replyTo, String to, String subject, String text) {
        this.from = from;
        this.replyTo = replyTo;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public String getFrom() {
        return from;
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

    public String getText() {
        return text;
    }
}
