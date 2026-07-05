package com.projectmanagementapp.domain.dao;

import com.projectmanagementapp.domain.dao.mapper.IssueMapper;
import com.projectmanagementapp.domain.model.Issue;
import com.projectmanagementapp.domain.model.IssueStatus;
import com.projectmanagementapp.dto.IssueRequest;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class IssueDaoImpl implements IssueDao {

    private final IssueMapper issueMapper;

    public IssueDaoImpl(IssueMapper issueMapper) {
        this.issueMapper = issueMapper;
    }

    @Override
    public List<Issue> findAll() {
        return issueMapper.findAll();
    }

    @Override
    public Issue findById(Long id) {
        return issueMapper.findById(id);
    }

    @Override
    public List<Issue> findByProjectId(Long projectId) {
        return issueMapper.findByProjectId(projectId);
    }

    @Override
    public List<Issue> findByStatus(IssueStatus status) {
        return issueMapper.findByStatus(status);
    }

    @Override
    public List<Issue> findByProjectIdAndStatus(Long projectId, IssueStatus status) {
        return issueMapper.findByProjectIdAndStatus(projectId, status);
    }

    @Override
    public List<Issue> findRecent(int limit) {
        return issueMapper.findRecent(limit);
    }

    @Override
    public Issue insert(IssueRequest request) {
        return issueMapper.insert(request);
    }

    @Override
    public Issue update(Long id, IssueRequest request) {
        return issueMapper.update(id, request);
    }

    @Override
    public int delete(Long id) {
        return issueMapper.delete(id);
    }

    @Override
    public long countAll() {
        return issueMapper.countAll();
    }

    @Override
    public long countByStatus(IssueStatus status) {
        return issueMapper.countByStatus(status);
    }
}
