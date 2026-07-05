package com.projectmanagementapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ProjectRequest(
    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^[A-Za-z0-9_-]+$")
    String projectKey,

    @NotBlank
    @Size(max = 100)
    String name,

    @Size(max = 2000)
    String description
) {
}
