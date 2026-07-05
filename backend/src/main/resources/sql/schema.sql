CREATE SCHEMA IF NOT EXISTS management_app AUTHORIZATION postgres;

DROP TABLE IF EXISTS management_app.issues;
DROP TABLE IF EXISTS management_app.projects;

CREATE TABLE management_app.projects (
    id BIGSERIAL PRIMARY KEY,
    project_key VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE management_app.issues (
    id BIGSERIAL PRIMARY KEY,
    project_id BIGINT NOT NULL REFERENCES management_app.projects(id),
    title VARCHAR(200) NOT NULL,
    description TEXT,
    status VARCHAR(30) NOT NULL,
    priority VARCHAR(30) NOT NULL,
    assignee_name VARCHAR(100),
    due_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_projects_project_key ON management_app.projects(project_key);
CREATE INDEX idx_issues_project_id ON management_app.issues(project_id);
CREATE INDEX idx_issues_status ON management_app.issues(status);
CREATE INDEX idx_issues_updated_at ON management_app.issues(updated_at);
