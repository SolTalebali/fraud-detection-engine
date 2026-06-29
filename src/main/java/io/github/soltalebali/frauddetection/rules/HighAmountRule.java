package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.FlagResult;
import io.github.soltalebali.frauddetection.model.Severity;
import io.github.soltalebali.frauddetection.model.Transaction;

import java.math.BigDecimal;

public class HighAmountRule implements FraudRule {
    private final BigDecimal threshold;

    public HighAmountRule(BigDecimal threshold) {
        this.threshold = threshold;
    }

    @Override
    public FlagResult evaluate(Transaction transaction) {
        if (transaction.getAmount().compareTo(threshold) > 0) {
            return new FlagResult(true, "Amount exceeds safe threshold", Severity.HIGH);
        } else {
            return new FlagResult(false, "Amount within safe threshold", Severity.LOW);
        }
    }
}