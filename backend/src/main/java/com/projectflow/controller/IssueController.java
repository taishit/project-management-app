package com.projectflow.controller;

import com.projectflow.dto.IssueDetailResponse;
import com.projectflow.dto.IssueSummaryResponse;
import com.projectflow.service.IssueService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping
    public List<IssueSummaryResponse> findAll() {
        return issueService.findAll();
    }

    @GetMapping("/{issueId}")
    public IssueDetailResponse findById(@PathVariable Long issueId) {
        return issueService.findById(issueId);
    }
}
