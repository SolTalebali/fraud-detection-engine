package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class RapidSuccessionRuleTest {
    private RapidSuccessionRule rule;

    @BeforeEach
    void setUp() {
        LocalDateTime oldDateTime = LocalDateTime.of(2026, 6, 25, 10, 30, 56);
        Transaction previousTransaction = new Transaction("ABC", "JohnD",
                new BigDecimal("200.00"), oldDateTime, "London");
        long withinSeconds = 600L;
        rule = new RapidSuccessionRule(previousTransaction, withinSeconds);
    }

    @Test
    void short_time_between_transactions_returns_flagged () {
        LocalDateTime newDateTime = LocalDateTime.of(2026, 6, 25, 10, 32, 23);
        Transaction newTransaction = new Transaction("ABC", "JohnD",
                new BigDecimal("200.00"), newDateTime, "London");

        assertThat(rule.evaluate(newTransaction).isFlagged(), is(true));
    }

    @Test
    void long_time_between_transactions_not_flagged () {
        LocalDateTime newDateTime = LocalDateTime.of(2026, 6, 25, 11, 32, 23);
        Transaction newTransaction = new Transaction("ABC", "JohnD",
                new BigDecimal("200.00"), newDateTime, "London");

        assertThat(rule.evaluate(newTransaction).isFlagged(), is(false));
    }
}