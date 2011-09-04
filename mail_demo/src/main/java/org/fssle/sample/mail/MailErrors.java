package org.fssle.sample.mail;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

public class MailErrors {
    private Map<String, String> errors = newHashMap();

    public int getErrorCount() {
        return errors.size();
    }

    public void rejectValue(String field, String defaultMessage) {
        errors.put(field, defaultMessage);
    }

    public String getErrorMessage(String validField) {
        return errors.containsKey(validField)?errors.get(validField):"";
    }
}
