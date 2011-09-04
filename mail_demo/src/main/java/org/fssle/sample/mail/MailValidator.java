package org.fssle.sample.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidator {
    private MailErrors errors;

    public MailValidator() {
        errors = new MailErrors();
    }

    public MailErrors getErrors() {
        return errors;
    }

    public void validateEmail(String field, String value, String emptyMessage, String notEmailMessage) {
        try {
            rejectIfEmptyOrWhitespace(field, value, emptyMessage);
            rejectIfNotEmail(field, value, notEmailMessage);
        } catch (IllegalArgumentException e) {
        }
    }

    private void rejectIfEmptyOrWhitespace(String field, String value, String defaultMessage) throws IllegalArgumentException {
        if (value.trim().isEmpty()) {
            errors.rejectValue(field, defaultMessage);
            throw new IllegalArgumentException(defaultMessage);
        }
    }

    private void rejectIfNotEmail(String field, String value, String defaultMessage) throws IllegalArgumentException {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches() == false) {
            errors.rejectValue(field, defaultMessage);
            throw new IllegalArgumentException(defaultMessage);
        }
    }
}
