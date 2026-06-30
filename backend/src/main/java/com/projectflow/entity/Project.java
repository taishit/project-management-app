package com.projectflow.entity;

public record Project(
    Long id,
    String code,
    String name,
    String status,
    String owner,
    String description
) {
}
