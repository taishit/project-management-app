package com.projectmanagementapp.dto;

public record IssueSummaryResponse(
    Long id,
    String issueKey,
    String projectName,
    String title,
    String status,
    String priority,
    String assignee
) {
}

