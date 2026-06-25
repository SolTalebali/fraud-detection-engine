package io.github.soltalebali.frauddetection.model;

public enum Severity {
    LOW("Low risk - monitor only"),
    MEDIUM("Medium risk - review recommended"),
    HIGH("High risk - flag for investigation"),
    CRITICAL("Critical risk - block transaction immediately");

    private final String description;
    Severity(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}