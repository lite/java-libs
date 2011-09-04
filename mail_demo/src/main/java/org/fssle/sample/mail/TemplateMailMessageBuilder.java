package org.fssle.sample.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class TemplateMailMessageBuilder implements MailMessageBuilder {
    private Template template;

    public void setTemplate(String template) {
        try {
            this.template = createMailTemplate(template);
        } catch (IOException e) {
            throw new IllegalArgumentException("fail to create template", e);
        }
    }

    private Template createMailTemplate(String templateName) throws IOException {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        return cfg.getTemplate(templateName);
    }

    @Override
    public String build(Map<String, String> model) {
        try {
            Writer writer = new StringWriter();
            template.process(model, writer);
            writer.flush();
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("failed to build mail message", e);
        }
    }
}
