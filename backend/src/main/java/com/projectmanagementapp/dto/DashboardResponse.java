package com.projectmanagementapp.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private long projectCount;
    private long issueCount;
    private long todoCount;
    private long inProgressCount;
    private long reviewCount;
    private long doneCount;
    private List<IssueResponse> recentIssues;
}
