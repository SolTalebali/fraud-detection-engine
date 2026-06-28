package io.github.soltalebali.frauddetection.model;

public class FlagResult {
    private final boolean flagged;
    private final String reason;
    private final Severity severity;

    public FlagResult(boolean flagged, String reason, Severity severity) {
        this.flagged = flagged;
        this.reason = reason;
        this.severity = severity;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public String getReason() {
        return reason;
    }

    public Severity getSeverity() {
        return severity;
    }

    @Override
    public String toString() {
        return "flagged status: " + flagged + '\'' +
                "reason: " + reason + '\'' +
                "severity: " + severity.getDescription();
    }
}
