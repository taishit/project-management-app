-- projects.project_key has a UNIQUE constraint in 002_create_projects_table.sql.
-- PostgreSQL creates an index for the UNIQUE constraint, so no duplicate index is created here.

CREATE INDEX IF NOT EXISTS idx_issues_project_id
    ON management_app.issues(project_id);

CREATE INDEX IF NOT EXISTS idx_issues_status
    ON management_app.issues(status);

CREATE INDEX IF NOT EXISTS idx_issues_updated_at
    ON management_app.issues(updated_at);
