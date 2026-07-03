package com.projectmanagementapp.dto;

import java.util.List;

public record DashboardSummaryResponse(
    int activeProjects,
    int openIssues,
    int dueToday,
    List<String> recentUpdates
) {
}

