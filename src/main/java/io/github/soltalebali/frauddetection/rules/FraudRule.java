package io.github.soltalebali.frauddetection.rules;

import io.github.soltalebali.frauddetection.model.FlagResult;
import io.github.soltalebali.frauddetection.model.Transaction;

public interface FraudRule {
    FlagResult evaluate(Transaction transaction);
}
