package com.projectmanagementapp.domain.service;

import com.projectmanagementapp.domain.dao.IssueDao;
import com.projectmanagementapp.domain.dao.ProjectDao;
import com.projectmanagementapp.domain.model.IssueStatus;
import com.projectmanagementapp.dto.DashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final ProjectDao projectDao;
    private final IssueDao issueDao;
    private final IssueServiceImpl issueService;

    public DashboardServiceImpl(ProjectDao projectDao, IssueDao issueDao, IssueServiceImpl issueService) {
        this.projectDao = projectDao;
        this.issueDao = issueDao;
        this.issueService = issueService;
    }

    @Override
    public DashboardResponse getDashboard() {
        return new DashboardResponse(
            projectDao.countAll(),
            issueDao.countAll(),
            issueDao.countByStatus(IssueStatus.TODO),
            issueDao.countByStatus(IssueStatus.IN_PROGRESS),
            issueDao.countByStatus(IssueStatus.REVIEW),
            issueDao.countByStatus(IssueStatus.DONE),
            issueDao.findRecent(5).stream().map(issueService::toResponse).toList()
        );
    }
}
