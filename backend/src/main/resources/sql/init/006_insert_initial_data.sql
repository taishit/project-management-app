INSERT INTO management_app.projects (project_key, name, description, created_at, updated_at)
VALUES
    ('SAMPLE', 'Sample Project', 'Sample project for learning ProjectFlow.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('APP', 'App Development', 'Project for ProjectFlow application development.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON CONFLICT (project_key) DO NOTHING;

INSERT INTO management_app.issues (
    project_id,
    title,
    description,
    status,
    priority,
    assignee_name,
    due_date,
    created_at,
    updated_at
)
SELECT
    p.id,
    seed.title,
    seed.description,
    seed.status,
    seed.priority,
    seed.assignee_name,
    seed.due_date,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
FROM (
    VALUES
        ('SAMPLE', 'Check project list', 'Confirm that the sample project is shown in the list.', 'TODO', 'LOW', 'Sato', CURRENT_DATE + 3),
        ('SAMPLE', 'Check issue detail', 'Confirm that required fields are shown on the detail page.', 'IN_PROGRESS', 'MEDIUM', 'Tanaka', CURRENT_DATE + 7),
        ('APP', 'Implement backend API', 'Implement CRUD APIs with Spring Boot and MyBatis.', 'REVIEW', 'HIGH', 'Suzuki', CURRENT_DATE + 5),
        ('APP', 'Implement frontend pages', 'Call APIs from Vue 3 and support create, update, and delete operations.', 'IN_PROGRESS', 'HIGH', 'Takahashi', CURRENT_DATE + 10),
        ('APP', 'Update documents', 'Update design documents to match the MVP implementation.', 'DONE', 'MEDIUM', 'Ito', CURRENT_DATE + 1)
) AS seed(project_key, title, description, status, priority, assignee_name, due_date)
JOIN management_app.projects p
    ON p.project_key = seed.project_key
WHERE NOT EXISTS (
    SELECT 1
    FROM management_app.issues i
    WHERE i.project_id = p.id
      AND i.title = seed.title
);

SELECT setval(
    pg_get_serial_sequence('management_app.projects', 'id'),
    COALESCE((SELECT MAX(id) FROM management_app.projects), 1),
    true
);

SELECT setval(
    pg_get_serial_sequence('management_app.issues', 'id'),
    COALESCE((SELECT MAX(id) FROM management_app.issues), 1),
    true
);

INSERT INTO management_app.sql_history (
    script_no,
    script_name,
    description,
    executed_by
)
VALUES
    ('001', '001_create_schema.sql', 'Create management_app schema.', CURRENT_USER),
    ('002', '002_create_projects_table.sql', 'Create projects table.', CURRENT_USER),
    ('003', '003_create_issues_table.sql', 'Create issues table.', CURRENT_USER),
    ('004', '004_create_indexes.sql', 'Create indexes.', CURRENT_USER),
    ('005', '005_create_sql_history.sql', 'Create sql_history table.', CURRENT_USER),
    ('006', '006_insert_initial_data.sql', 'Insert initial sample data.', CURRENT_USER)
ON CONFLICT (script_no) DO NOTHING;
