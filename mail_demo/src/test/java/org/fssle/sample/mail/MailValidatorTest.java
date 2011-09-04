package org.fssle.sample.mail;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MailValidatorTest {

    private static final String EMPTY_MESSAGE = "required";
    private static final String NOT_EMAIL_MESSAGE = "invalid";

    @Test
    public void should_return_valid_email_address() {
        MailValidator validator = new MailValidator();
        String validField = "validField";
        validator.validateEmail(validField, "valid@email.com", EMPTY_MESSAGE, NOT_EMAIL_MESSAGE);

        MailErrors errors = validator.getErrors();
        assertThat(errors, notNullValue());
        assertThat(errors.getErrorCount(), equalTo(0));
        assertThat(errors.getErrorMessage(validField), is(""));
    }

    @Test
    public void should_return_invalid_email_address() {
        MailValidator validator = new MailValidator();
        String invalidField = "invalidField";
        validator.validateEmail(invalidField, "invalid.email.com", EMPTY_MESSAGE, NOT_EMAIL_MESSAGE);

        MailErrors errors = validator.getErrors();
        assertThat(errors, notNullValue());
        assertThat(errors.getErrorCount(), equalTo(1));
        assertThat(errors.getErrorMessage(invalidField), is(NOT_EMAIL_MESSAGE));
    }

    @Test
    public void should_return_invalid_empty_or_whitespace() {
        MailValidator validator = new MailValidator();
        String whitespaceField = "whitespaceField";
        String emptyField = "emptyField";
        validator.validateEmail(whitespaceField, "  ", EMPTY_MESSAGE, NOT_EMAIL_MESSAGE);
        validator.validateEmail(emptyField, "", EMPTY_MESSAGE, NOT_EMAIL_MESSAGE);

        MailErrors errors = validator.getErrors();
        assertThat(errors, notNullValue());
        assertThat(errors.getErrorCount(), equalTo(2));
        assertThat(errors.getErrorMessage(whitespaceField), is(EMPTY_MESSAGE));
        assertThat(errors.getErrorMessage(emptyField), is(EMPTY_MESSAGE));
    }
}
