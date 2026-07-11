package com.projectmanagementapp.dto;

import com.projectmanagementapp.domain.model.IssuePriority;
import com.projectmanagementapp.domain.model.IssueStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueRequest {

    @NotNull
    private Long projectId;

    @NotBlank
    @Size(max = 200)
    private String title;

    @Size(max = 5000)
    private String description;

    @NotNull
    private IssueStatus status;

    @NotNull
    private IssuePriority priority;

    @Size(max = 100)
    private String assigneeName;

    private LocalDate dueDate;
}
