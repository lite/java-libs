package org.fssle.sample.mail;


import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class MailServiceTest {
    private static final String MESSAGE = "fixed message";
    private static final String SENDER_ADDRESS = "test-from@rea-group.com";
    private MailService service;
    private StubMailer mailer;
    private MailMessageBuilder builder;

    @Before
    public void setUp() throws Exception {
        service = new MailService();
        mailer = new StubMailer();
        service.setMailer(mailer);
        builder = new StubMessageBuilder(MESSAGE);
        service.setMailMessageBuilder(builder);
        service.setSenderAddress(SENDER_ADDRESS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_form_is_invalid() {
        MailForm form = createInvalidForm();
        service.send(form);
    }

    @Test
    public void should_send_mail() {
        String sender = "test-sender";
        String to = "test-to@rea-group.com";
        String replyTo = "test-reply@rea-group.com";
        String subject = "feedback";

        MailForm form = createMailForm(sender, to, replyTo, subject, "", "");
        service.send(form);

        Mail mail = mailer.getMail();
        assertThat(mail.getFrom(), is(SENDER_ADDRESS));
        assertThat(mail.getTo(), is(to));
        assertThat(mail.getReplyTo(), is(replyTo));
        assertThat(mail.getSubject(), is(subject));
        assertThat(mail.getText(), is(MESSAGE));
    }

    private MailShareForm createMailForm(String sender, String to, String replyTo, String subject, String message, String imageUrl) {
        return new MailShareForm(sender, replyTo, to, subject, message, imageUrl);
    }

    private MailForm createInvalidForm() {
        MailShareForm shareForm = mock(MailShareForm.class);
        doThrow(new IllegalArgumentException()).when(shareForm).validate();
        return shareForm;
    }

    private static class StubMailer implements Mailer {
        private Mail mail;

        @Override
        public void send(Mail mail) {
            this.mail = mail;
        }

        public Mail getMail() {
            return mail;
        }
    }

    private static class StubMessageBuilder implements MailMessageBuilder {
        private String fixedMessage;

        public StubMessageBuilder(String fixedMessage) {
            this.fixedMessage = fixedMessage;
        }

        @Override
        public String build(Map<String, String> model) {
            return this.fixedMessage;
        }
    }
}
