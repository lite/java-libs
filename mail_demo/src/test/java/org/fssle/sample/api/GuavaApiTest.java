package org.fssle.sample.api;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static junit.framework.Assert.assertNull;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GuavaApiTest {

    @Test
    public void should_return_when_string() {
        GuavaApi guavaApi = new GuavaApi();

        assertNull(Strings.emptyToNull(""));
        assertThat(Strings.nullToEmpty(null), is(""));
        assertThat(Strings.isNullOrEmpty("") && Strings.isNullOrEmpty(null), is(true));
        assertThat(Strings.repeat("java", 3), is("javajavajava"));
    }

    @Test
    public void should_return_when_charmatcher() {
        String source = "a1b2c3";
        CharMatcher matcher = CharMatcher.DIGIT;
        assertThat(matcher.matches('8'), is(true));
        assertThat(matcher.retainFrom(source), is("123"));
        assertThat(matcher.countIn(source), is(3));
        assertThat(matcher.removeFrom(source), is("abc"));
        assertThat(matcher.trimFrom("1a2b3c4"), is("a2b3c"));
    }

    @Test
    public void should_return_when_joiner() {
        assertThat(Joiner.on("-").join("2011", "08", "04"), is("2011-08-04"));
    }

    @Test
    public void should_return_when_splitter() {
        assertThat(getSplitterLength(Splitter.on(',').split("a,b")), is(2));
        assertThat(getSplitterLength(Splitter.on(',').trimResults().split("a , b")), is(2));
        assertThat(getSplitterLength(Splitter.on(',').omitEmptyStrings().split("a,,b")), is(2));
    }

    @Test
    public void should_return_when_char_format() {
        assertThat(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, "helloGuava"), is("HELLO_GUAVA"));
        assertThat(CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, "hello-guava"), is("HelloGuava"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_when_pre_condition() {
        int count = -1;
        Preconditions.checkArgument(count > 0, "must be positive: %s", count);
    }

    @Test
    public void should_return_when_file_io() throws IOException {
        File from = new File("README.md");
        File to = new File("target/temp");
        Files.copy(from, to);
        File renamed = new File("target/renamed");
        Files.move(to, renamed);
        Files.copy(renamed, to);
        File target = new File("target");
        Files.deleteDirectoryContents(target);
        Files.deleteRecursively(target);
    }

    // @Test
    public void should_return_when_resource() {
        URL url = Resources.getResource("web.config.properties");
        assertThat(url.getPath(), containsString("target"));
        assertThat(url.getFile(), containsString("web.config.properties"));
    }

    // @Test
    public void should_return_when_iterator_transform() {
        List<String> strings = newArrayList("abc", "def", "");
        Iterable<String> names = Iterables.transform(strings, new Function<String, String>() {
            public String apply(String from) {
                return from.toUpperCase();
            }
        });
        assertThat(getSplitterLength(names), is(3));
    }

    private int getSplitterLength(Iterable<String> split) {
        return newArrayList(split).size();
    }
}
