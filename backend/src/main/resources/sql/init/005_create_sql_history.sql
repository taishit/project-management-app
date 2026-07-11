CREATE TABLE IF NOT EXISTS management_app.sql_history (
    script_no VARCHAR(10) PRIMARY KEY,
    script_name VARCHAR(255) NOT NULL,
    description VARCHAR(500),
    executed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    executed_by VARCHAR(100)
);
