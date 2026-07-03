package com.projectmanagementapp.repository;

import com.projectmanagementapp.entity.Issue;
import java.util.List;
import java.util.Optional;

public interface IssueRepository {

    List<Issue> findAll();

    Optional<Issue> findById(Long id);
}

