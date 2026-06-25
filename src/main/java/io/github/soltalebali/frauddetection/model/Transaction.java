package io.github.soltalebali.frauddetection.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private final String transactionId;
    private final String accountId;
    private final BigDecimal amount;
    private final LocalDateTime timestamp;
    private final String location;

    public Transaction(String transactionId, String accountId, BigDecimal amount, LocalDateTime timestamp, String location) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.location = location;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(transactionId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", location='" + location + '\'' +
                '}';
    }
}
