package com.projectmanagementapp.dto;

import com.projectmanagementapp.domain.model.IssuePriority;
import com.projectmanagementapp.domain.model.IssueStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record IssueRequest(
    @NotNull
    Long projectId,

    @NotBlank
    @Size(max = 200)
    String title,

    @Size(max = 5000)
    String description,

    @NotNull
    IssueStatus status,

    @NotNull
    IssuePriority priority,

    @Size(max = 100)
    String assigneeName,

    LocalDate dueDate
) {
}
