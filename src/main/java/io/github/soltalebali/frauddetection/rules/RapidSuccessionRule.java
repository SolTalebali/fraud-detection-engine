package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.FlagResult;
import io.github.soltalebali.frauddetection.model.Severity;
import io.github.soltalebali.frauddetection.model.Transaction;

import java.time.temporal.ChronoUnit;

public class RapidSuccessionRule implements FraudRule{
    private final Transaction previousTransaction;
    private final long withinSeconds;

    public RapidSuccessionRule(Transaction previousTransaction, long withinSeconds) {
        this.previousTransaction = previousTransaction;
        this.withinSeconds = withinSeconds;
    }

    @Override
    public FlagResult evaluate(Transaction transaction) {
        long timeBetweenTransactions = ChronoUnit.SECONDS.between(
                previousTransaction.getTimestamp(), transaction.getTimestamp()
        );

        if (timeBetweenTransactions < withinSeconds) {
            return new FlagResult(
                    true, "Time between transactions less than threshold.", Severity.HIGH
            );
        };

        return new FlagResult(
                false, "Time within transactions within threshold.", Severity.LOW
        );
    }
}
