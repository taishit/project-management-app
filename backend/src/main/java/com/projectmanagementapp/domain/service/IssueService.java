package com.projectmanagementapp.domain.service;

import com.projectmanagementapp.domain.model.IssueStatus;
import com.projectmanagementapp.dto.IssueRequest;
import com.projectmanagementapp.dto.IssueResponse;
import java.util.List;

public interface IssueService {
    List<IssueResponse> findAll(Long projectId, IssueStatus status);
    IssueResponse findById(Long id);
    IssueResponse create(IssueRequest request);
    IssueResponse update(Long id, IssueRequest request);
    void delete(Long id);
}
