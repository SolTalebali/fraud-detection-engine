package io.github.soltalebali.frauddetection.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SeverityTest {
    @Test
    void constant_returns_right_description() {
        assertThat(Severity.HIGH.getDescription(), equalTo("High risk - flag for investigation"));
    }

    @Test
    void test_returns_correct_value() {
        assertThat(Severity.valueOf("LOW"), equalTo(Severity.LOW));
    }
}
