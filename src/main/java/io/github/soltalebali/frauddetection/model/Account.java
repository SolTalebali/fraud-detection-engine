package io.github.soltalebali.frauddetection.model;

import java.util.Objects;

public class Account {
    private final String accountId;
    private final String accountHolder;
    private final String homeLocation;

    public Account(String accountId, String accountHolder, String homeLocation) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.homeLocation = homeLocation;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getHomeLocation() {
        return homeLocation;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", homeLocation='" + homeLocation + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountId);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) return false;
        Account that  = (Account) obj;
        return Objects.equals(accountId, that.accountId);
    }
}
