INSERT INTO management_app.projects (id, project_key, name, description, created_at, updated_at)
VALUES
    (1, 'SAMPLE', 'サンプルプロジェクト', '学習用のサンプルプロジェクト', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 'APP', 'アプリ開発', 'ProjectFlow開発用プロジェクト', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO management_app.issues (id, project_id, title, description, status, priority, assignee_name, due_date, created_at, updated_at)
VALUES
    (1, 1, 'プロジェクト一覧を確認する', 'サンプルプロジェクトで一覧表示を確認する。', 'TODO', 'LOW', '佐藤', CURRENT_DATE + INTERVAL '3 days', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 1, '課題詳細を確認する', '詳細画面に必要な項目が表示されるか確認する。', 'IN_PROGRESS', 'MEDIUM', '田中', CURRENT_DATE + INTERVAL '7 days', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 2, 'バックエンドAPIを実装する', 'ProjectFlowのCRUD APIをSpring BootとMyBatisで実装する。', 'REVIEW', 'HIGH', '鈴木', CURRENT_DATE + INTERVAL '5 days', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 2, 'フロントエンド画面を実装する', 'Vue 3からAPIを呼び出し、登録・更新・削除を行う。', 'IN_PROGRESS', 'HIGH', '高橋', CURRENT_DATE + INTERVAL '10 days', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, 2, 'ドキュメントを更新する', 'MVPの実装内容に合わせて設計資料を更新する。', 'DONE', 'MEDIUM', '伊藤', CURRENT_DATE + INTERVAL '1 day', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

SELECT setval(pg_get_serial_sequence('management_app.projects', 'id'), COALESCE((SELECT MAX(id) FROM management_app.projects), 1), true);
SELECT setval(pg_get_serial_sequence('management_app.issues', 'id'), COALESCE((SELECT MAX(id) FROM management_app.issues), 1), true);
