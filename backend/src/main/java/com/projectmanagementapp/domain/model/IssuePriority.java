package com.projectmanagementapp.domain.model;

public enum IssuePriority {
    LOW("低"),
    MEDIUM("中"),
    HIGH("高");

    private final String label;

    IssuePriority(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
