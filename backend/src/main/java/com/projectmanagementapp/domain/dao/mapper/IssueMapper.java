package com.projectmanagementapp.domain.dao.mapper;

import com.projectmanagementapp.domain.model.Issue;
import com.projectmanagementapp.domain.model.IssueStatus;
import com.projectmanagementapp.dto.IssueRequest;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IssueMapper {
    List<Issue> findAll();
    Issue findById(Long id);
    List<Issue> findByProjectId(Long projectId);
    List<Issue> findByStatus(IssueStatus status);
    List<Issue> findByProjectIdAndStatus(@Param("projectId") Long projectId, @Param("status") IssueStatus status);
    List<Issue> findRecent(int limit);
    Issue insert(IssueRequest request);
    Issue update(@Param("id") Long id, @Param("request") IssueRequest request);
    int delete(Long id);
    long countAll();
    long countByStatus(IssueStatus status);
}
