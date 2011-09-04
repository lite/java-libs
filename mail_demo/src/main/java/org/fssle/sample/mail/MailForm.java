package org.fssle.sample.mail;

import java.util.Map;

public interface MailForm {
    MailErrors validate();
    Mail toMail(String from, String text);
    Map<String, String> getModel();
}
