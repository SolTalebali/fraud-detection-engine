package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.FlagResult;
import io.github.soltalebali.frauddetection.model.Severity;
import io.github.soltalebali.frauddetection.model.Transaction;

import java.math.BigDecimal;

public class RoundNumberRule implements FraudRule{
    @Override
    public FlagResult evaluate(Transaction transaction) {
        if (transaction.getAmount().remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
            return new FlagResult(true, "No decimal value found", Severity.MEDIUM);
        }

        return new FlagResult(false, "Decimal value found", Severity.LOW);
    }
}
