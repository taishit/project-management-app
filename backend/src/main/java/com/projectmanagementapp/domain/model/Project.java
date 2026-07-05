package com.projectmanagementapp.domain.model;

import java.time.LocalDateTime;
import lombok.Value;

@Value
public class Project {
    Long id;
    String projectKey;
    String name;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
