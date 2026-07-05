package com.projectmanagementapp.controller;

import com.projectmanagementapp.domain.model.IssueStatus;
import com.projectmanagementapp.domain.service.IssueService;
import com.projectmanagementapp.dto.IssueRequest;
import com.projectmanagementapp.dto.IssueResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @GetMapping
    public List<IssueResponse> findAll(
        @RequestParam(required = false) Long projectId,
        @RequestParam(required = false) IssueStatus status
    ) {
        return issueService.findAll(projectId, status);
    }

    @GetMapping("/{id}")
    public IssueResponse findById(@PathVariable Long id) {
        return issueService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IssueResponse create(@Valid @RequestBody IssueRequest request) {
        return issueService.create(request);
    }

    @PutMapping("/{id}")
    public IssueResponse update(@PathVariable Long id, @Valid @RequestBody IssueRequest request) {
        return issueService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        issueService.delete(id);
    }
}
