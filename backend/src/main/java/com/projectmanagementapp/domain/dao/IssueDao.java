package com.projectmanagementapp.domain.dao;

import com.projectmanagementapp.domain.model.Issue;
import com.projectmanagementapp.domain.model.IssueStatus;
import com.projectmanagementapp.dto.IssueRequest;
import java.util.List;

public interface IssueDao {
    List<Issue> findAll();
    Issue findById(Long id);
    List<Issue> findByProjectId(Long projectId);
    List<Issue> findByStatus(IssueStatus status);
    List<Issue> findByProjectIdAndStatus(Long projectId, IssueStatus status);
    List<Issue> findRecent(int limit);
    Issue insert(IssueRequest request);
    Issue update(Long id, IssueRequest request);
    int delete(Long id);
    long countAll();
    long countByStatus(IssueStatus status);
}
