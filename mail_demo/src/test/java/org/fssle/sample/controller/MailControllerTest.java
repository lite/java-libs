package org.fssle.sample.controller;

import org.fssle.sample.mail.MailService;
import org.fssle.sample.mail.MailShareForm;
import org.fssle.sample.presenter.MailSharePresenter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MailControllerTest {

    private MailController mailController = new MailController();
    private ModelMap modelMap;

    @Before
    public void setUp() {
        mailController.setMailService(new MailService());
    }

    @Test
    public void should_return_with_empty_image_share() {
        modelMap = new ModelMap();
        mailController.show("15", modelMap);

        MailSharePresenter imageShare = (MailSharePresenter) modelMap.get("imageShare");
        assertThat(imageShare, notNullValue());
        assertThat(imageShare.getReplyToErrorMessage(), is(""));
        assertThat(imageShare.getToErrorMessage(), is(""));
        assertThat(imageShare.getReplyToError(), is(""));
        assertThat(imageShare.getToError(), is(""));
    }

    @Test
    public void should_send_email() {
        modelMap = new ModelMap();
        String senderName = "senderName";
        String to = "test-to@email.com";
        String replyTo = "test-replyto@email.com";
        String subject = "share subject";
        String message = "bla bla";
        String imageUrl = "";
        MailShareForm mailShareForm = new MailShareForm(senderName, replyTo, to, subject, message, imageUrl);

        mailController.post("15", mailShareForm, modelMap);

        assertThat((String) modelMap.get("to"), is(to));
    }

    @Test
    public void should_validate_failure_when_invalid_data() {
        modelMap = new ModelMap();
        String senderName = "senderName";
        String to = "invalid.email.com";
        String replyTo = "";
        String subject = "share subject";
        String message = "bla bla";
        String imageUrl = "http://127.0.0.1/url";
        MailShareForm mailShareForm = new MailShareForm(senderName, replyTo, to, subject, message, imageUrl);
        mailController.post("15", mailShareForm, modelMap);

        MailSharePresenter imageShare = (MailSharePresenter) modelMap.get("imageShare");
        assertThat(imageShare, notNullValue());
        assertThat(imageShare.getToErrorMessage(), is("Invalid email address"));
        assertThat(imageShare.getReplyToErrorMessage(), is("Please input email address"));
        assertThat(imageShare.getToError(), is("error"));
        assertThat(imageShare.getReplyToError(), is("error"));
    }

    @Test
    public void should_return_form_when_validate_failure() {
        modelMap = new ModelMap();
        String senderName = "senderName";
        String to = "to.email.com";
        String replyTo = "replyto@email.com";
        String subject = "share subject";
        String message = "bla bla";
        String imageUrl = "http://127.0.0.1/url";
        MailShareForm mailShareForm = new MailShareForm(senderName, replyTo, to, subject, message, imageUrl);
        mailController.post("15", mailShareForm, modelMap);

        MailSharePresenter imageShare = (MailSharePresenter) modelMap.get("imageShare");
        assertThat(imageShare, notNullValue());
        MailShareForm emailShareForm = imageShare.getEmailShareForm();
        assertThat(emailShareForm.getSenderName(), is(senderName));
        assertThat(emailShareForm.getTo(), is(to));
        assertThat(emailShareForm.getReplyTo(), is(replyTo));
        assertThat(emailShareForm.getSubject(), is(subject));
        assertThat(emailShareForm.getMessage(), is(message));
        assertThat(emailShareForm.getImageUrl(), is(imageUrl));
    }
}
