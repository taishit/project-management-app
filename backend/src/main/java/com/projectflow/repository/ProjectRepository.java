package com.projectflow.repository;

import com.projectflow.entity.Project;
import java.util.List;

public interface ProjectRepository {

    List<Project> findAll();
}
