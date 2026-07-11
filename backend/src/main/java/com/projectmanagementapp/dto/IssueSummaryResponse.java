package com.projectmanagementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueSummaryResponse {
    private Long id;
    private String issueKey;
    private String projectName;
    private String title;
    private String status;
    private String priority;
    private String assignee;
}
