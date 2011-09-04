package org.fssle.sample.mail;

import java.util.Map;

public interface MailMessageBuilder {
    String build(Map<String, String> model);
}
