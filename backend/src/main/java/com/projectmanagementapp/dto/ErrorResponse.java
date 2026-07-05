package com.projectmanagementapp.dto;

import java.util.List;

public record ErrorResponse(String message, List<String> details) {
}
