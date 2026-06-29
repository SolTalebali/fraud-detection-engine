package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.Account;
import io.github.soltalebali.frauddetection.model.FlagResult;
import io.github.soltalebali.frauddetection.model.Severity;
import io.github.soltalebali.frauddetection.model.Transaction;

public class UnusualLocationRule implements FraudRule{
    private final Account account;

    public UnusualLocationRule(Account account) {
        this.account = account;
    }

    @Override
    public FlagResult evaluate(Transaction transaction) {
        if (!transaction.getLocation().equals(account.getHomeLocation())) {
            return new FlagResult(true, "Location does not match home location.", Severity.MEDIUM);
        }
        return new FlagResult(false, "Sent from home location", Severity.LOW);
    }
}
