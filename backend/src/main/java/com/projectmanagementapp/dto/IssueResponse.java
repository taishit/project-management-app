package com.projectmanagementapp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueResponse {

    private Long id;
    private Long projectId;
    private String projectKey;
    private String projectName;
    private String title;
    private String description;
    private String status;
    private String statusLabel;
    private String priority;
    private String priorityLabel;
    private String assigneeName;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
