package com.projectmanagementapp.dto;

import java.util.List;

public record DashboardResponse(
    long projectCount,
    long issueCount,
    long todoCount,
    long inProgressCount,
    long reviewCount,
    long doneCount,
    List<IssueResponse> recentIssues
) {
}
