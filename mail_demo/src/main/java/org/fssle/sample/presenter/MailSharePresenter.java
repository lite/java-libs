package org.fssle.sample.presenter;

import org.fssle.sample.mail.MailErrors;
import org.fssle.sample.mail.MailShareForm;

public class MailSharePresenter {
    private String replyToErrorMessage;
    private String replyToError;
    private String toErrorMessage;
    private String toError;
    private MailShareForm emailShareForm;

    public MailSharePresenter(String imageUrl) {
        this.emailShareForm = new MailShareForm(imageUrl);
        this.replyToErrorMessage = "";
        this.replyToError = "";
        this.toErrorMessage = "";
        this.toError = "";
    }

    public MailSharePresenter(MailShareForm mailShareForm, MailErrors errors) {
        this.emailShareForm = mailShareForm;
        this.toErrorMessage = errors.getErrorMessage("to");
        this.toError = toErrorMessage.isEmpty()?"":"error";;
        this.replyToErrorMessage = errors.getErrorMessage("replyTo");
        this.replyToError = replyToErrorMessage.isEmpty()?"":"error";
    }

    public MailShareForm getEmailShareForm() {
        return emailShareForm;
    }

    public String getReplyToErrorMessage() {
        return replyToErrorMessage;
    }

    public String getToErrorMessage() {
        return toErrorMessage;
    }

    public String getReplyToError() {
        return replyToError;
    }

    public String getToError() {
        return toError;
    }
}
