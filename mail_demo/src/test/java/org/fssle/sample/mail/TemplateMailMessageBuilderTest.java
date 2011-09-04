package org.fssle.sample.mail;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TemplateMailMessageBuilderTest {
    private static final String TEMPLATE = "org/fssle/sample/mail/mail-test.ftl";
    private TemplateMailMessageBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new TemplateMailMessageBuilder();
        builder.setTemplate(TEMPLATE);
    }

    @Test
    public void should_return_message_with_model() {
        Map<String, String> model = Maps.newHashMap();
        model.put("sender", "Sender");

        String message = builder.build(model);

        assertThat(message, is("Hello, Sender"));
    }

    @Test(expected = RuntimeException.class)
    public void should_throw_exception_while_fail_to_create_message() {
        Map<String, String> model = Maps.newHashMap();
        model.put("unknown", "Sender");

        builder.build(model);
    }
}
