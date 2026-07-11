package com.projectmanagementapp.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Issue {
    private Long id;
    private Long projectId;
    private String projectKey;
    private String projectName;
    private String title;
    private String description;
    private IssueStatus status;
    private IssuePriority priority;
    private String assigneeName;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
