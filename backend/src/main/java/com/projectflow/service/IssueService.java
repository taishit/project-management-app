package com.projectflow.service;

import com.projectflow.dto.IssueDetailResponse;
import com.projectflow.dto.IssueSummaryResponse;
import com.projectflow.entity.Issue;
import com.projectflow.repository.IssueRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List<IssueSummaryResponse> findAll() {
        return issueRepository.findAll().stream()
            .map(issue -> new IssueSummaryResponse(
                issue.id(),
                issue.issueKey(),
                issue.projectName(),
                issue.title(),
                issue.status(),
                issue.priority(),
                issue.assignee()
            ))
            .toList();
    }

    public IssueDetailResponse findById(Long id) {
        Issue issue = issueRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Issue not found"));

        return new IssueDetailResponse(
            issue.id(),
            issue.issueKey(),
            issue.projectName(),
            issue.title(),
            issue.status(),
            issue.priority(),
            issue.assignee(),
            issue.dueDate(),
            issue.description()
        );
    }
}
