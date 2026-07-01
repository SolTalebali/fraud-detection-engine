package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

public class RoundNumberRuleTest {
    private LocalDateTime dateTime;
    private RoundNumberRule rule;

    @BeforeEach
    void setUp() {
        dateTime = LocalDateTime.of(2026, 6, 25, 10, 30, 56);
        rule = new RoundNumberRule();
    }

    @Test
    void test_round_number_returns_flagged () {
        Transaction transaction = new Transaction("ABC", "JohnD",
                new BigDecimal("200.00"), dateTime, "London");

        assertThat(rule.evaluate(transaction).isFlagged(), is(true));
    }

    @Test
    void test_number_with_decimal_not_flagged () {
        Transaction transaction = new Transaction("ABC", "JohnD",
                new BigDecimal("200.20"), dateTime, "London");

        assertThat(rule.evaluate(transaction).isFlagged(), is(false));
    }
}
