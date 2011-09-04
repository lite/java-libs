package org.fssle.sample.mail;

import org.fssle.sample.presenter.MailSharePresenter;
import org.springframework.beans.factory.annotation.Autowired;

public class MailService {
    private Mailer mailer;
    private String senderAddress;
    private MailMessageBuilder mailMessageBuilder;

    @Autowired
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    @Autowired
    public void setMailer(Mailer mailer) {
        this.mailer = mailer;
    }

    public void setMailMessageBuilder(MailMessageBuilder mailMessageBuilder) {
        this.mailMessageBuilder = mailMessageBuilder;
    }

    public void send(MailForm form) {
        form.validate();
        Mail mail = createMessage(form);
        this.mailer.send(mail);
    }

    private Mail createMessage(MailForm form) {
        String text = mailMessageBuilder.build(form.getModel());
        return form.toMail(senderAddress, text);
    }

    public MailSharePresenter createMailPresenter(String imageUrl) {
        return new MailSharePresenter(imageUrl);
    }

    public MailSharePresenter createMailPresenter(MailShareForm mailShareForm, MailErrors errors) {
        return new MailSharePresenter(mailShareForm, errors);
    }

    public MailErrors validate(MailShareForm mailShareForm) {
        return mailShareForm.validate();
    }
}
