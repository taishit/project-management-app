package com.projectflow.service;

import com.projectflow.dto.ProjectResponse;
import com.projectflow.repository.ProjectRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectResponse> findAll() {
        return projectRepository.findAll().stream()
            .map(project -> new ProjectResponse(
                project.id(),
                project.code(),
                project.name(),
                project.status(),
                project.owner(),
                project.description()
            ))
            .toList();
    }
}
