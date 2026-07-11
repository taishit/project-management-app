package com.projectmanagementapp.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DashboardSummaryResponse {
    private int activeProjects;
    private int openIssues;
    private int dueToday;
    private List<String> recentUpdates;
}
