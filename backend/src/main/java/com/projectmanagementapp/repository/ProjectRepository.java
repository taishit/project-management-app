package com.projectmanagementapp.repository;

import com.projectmanagementapp.entity.Project;
import java.util.List;

public interface ProjectRepository {

    List<Project> findAll();
}

