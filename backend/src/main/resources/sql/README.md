# SQL管理ルール

ProjectFlowでは、Flyway / Liquibase / 独自Java migration runner は使用しません。
SQLは手動で番号順に実行し、適用履歴は `management_app.sql_history` で確認します。

## 初期構築用SQL

- 配置先: `backend/src/main/resources/sql/init`
- 採番範囲: `001`〜`099`
- 新規環境構築時のみ番号順に実行する。
- 既存環境へ再実行する場合は、内容と影響を確認する。
- `DROP TABLE` や既存データ削除を原則禁止する。

## 追加変更用SQL

- 配置先: `backend/src/main/resources/sql/changes`
- 採番範囲: `101`〜`999`
- ファイル名形式: `{3桁連番}_{変更内容を英語のsnake_case}.sql`
- 例:
  - `101_add_issue_priority_index.sql`
  - `102_create_issue_comments_table.sql`
  - `103_add_issue_status_history.sql`
- 最大番号の次を採番する。
- 一度使用した番号は再利用しない。
- 削除したSQLの番号は欠番のままにする。
- 1ファイルには原則1つの変更目的だけを記載する。
- 適用済みSQLを後から書き換えない。
- 修正が必要な場合は新しい番号のSQLを追加する。

## 初期構築の実行方法

リポジトリルートで、Windowsのコマンドプロンプトから以下を番号順に実行します。

```cmd
psql -h localhost -p 5432 -U postgres -d postgres -f backend\src\main\resources\sql\init\001_create_schema.sql
psql -h localhost -p 5432 -U postgres -d postgres -f backend\src\main\resources\sql\init\002_create_projects_table.sql
psql -h localhost -p 5432 -U postgres -d postgres -f backend\src\main\resources\sql\init\003_create_issues_table.sql
psql -h localhost -p 5432 -U postgres -d postgres -f backend\src\main\resources\sql\init\004_create_indexes.sql
psql -h localhost -p 5432 -U postgres -d postgres -f backend\src\main\resources\sql\init\005_create_sql_history.sql
psql -h localhost -p 5432 -U postgres -d postgres -f backend\src\main\resources\sql\init\006_insert_initial_data.sql
```

## 追加SQLの実行方法

例:

```cmd
psql -h localhost -p 5432 -U postgres -d postgres -f backend\src\main\resources\sql\changes\101_add_issue_priority_index.sql
```

## 適用履歴確認

```sql
SELECT
    script_no,
    script_name,
    description,
    executed_at,
    executed_by
FROM management_app.sql_history
ORDER BY script_no;
```
