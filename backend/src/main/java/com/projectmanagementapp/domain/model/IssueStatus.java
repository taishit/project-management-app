package com.projectmanagementapp.domain.model;

public enum IssueStatus {
    TODO("未着手"),
    IN_PROGRESS("対応中"),
    REVIEW("レビュー中"),
    DONE("完了");

    private final String label;

    IssueStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
