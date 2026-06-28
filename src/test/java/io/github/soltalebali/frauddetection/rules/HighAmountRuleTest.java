package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HighAmountRuleTest {

    private HighAmountRule rule;
    private LocalDateTime dateTime;
    @BeforeEach
    void setUp() {
        rule = new HighAmountRule(new BigDecimal("10000.00"));
        dateTime = LocalDateTime.of(2026, 6, 25, 10, 30, 56);
    }

    @Test
    void test_high_amount_is_flagged () {
        Transaction transaction = new Transaction("ABC", "JohnD",
                new BigDecimal("250000.50"), dateTime, "London");

        assertThat(rule.evaluate(transaction).isFlagged(), is(true));
    }

    @Test
    void test_safe_amount_is_not_flagged () {
        Transaction transaction = new Transaction("ABC", "JohnD",
                new BigDecimal("2500.50"), dateTime, "London");

        assertThat(rule.evaluate(transaction).isFlagged(), is(false));
    }
}
