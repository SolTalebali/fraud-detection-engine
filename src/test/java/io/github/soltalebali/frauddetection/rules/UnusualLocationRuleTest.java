package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.Account;
import io.github.soltalebali.frauddetection.model.FlagResult;
import io.github.soltalebali.frauddetection.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UnusualLocationRileTest {
    private LocalDateTime dateTime;
    private Account account;
    private UnusualLocationRule rule;

    @BeforeEach
    void setUp() {
       dateTime = LocalDateTime.of(2026, 6, 25, 10, 30, 56);
       account = new Account("JohnD", "John David", "London");
       rule = new UnusualLocationRule(account);
    }


    @Test
    void transaction_location_positive_path () {
        Transaction transaction = new Transaction("ABC", "JohnD",
                new BigDecimal("250.50"), dateTime, "London");

        assertThat(rule.evaluate(transaction).isFlagged(), is(false));
    }

    @Test
    void transaction_location_negative_path () {
        Transaction transaction = new Transaction("ABC", "JohnD",
                new BigDecimal("250.50"), dateTime, "Manchester");

        assertThat(rule.evaluate(transaction).isFlagged(), is(true));
    }
}
