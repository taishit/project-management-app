package com.projectmanagementapp.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Value;

@Value
public class Issue {
    Long id;
    Long projectId;
    String projectKey;
    String projectName;
    String title;
    String description;
    IssueStatus status;
    IssuePriority priority;
    String assigneeName;
    LocalDate dueDate;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
