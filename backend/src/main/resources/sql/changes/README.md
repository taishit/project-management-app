# 追加変更用SQL

追加変更用SQLは `backend/src/main/resources/sql/changes` に配置します。

## テンプレート

```sql
-- ==================================================
-- Script No : 101
-- File Name : 101_example_change.sql
-- Purpose   : 変更目的を記載
-- Related Issue : #xxx
-- Created By:
-- Created At:
-- ==================================================

BEGIN;

-- SQLを記載

INSERT INTO management_app.sql_history (
    script_no,
    script_name,
    description,
    executed_by
)
VALUES (
    '101',
    '101_example_change.sql',
    '変更内容の説明',
    CURRENT_USER
);

COMMIT;
```

## 注意事項

- DDLが途中で失敗した場合に履歴だけ登録されないよう、同一トランザクション内で実行する。
- PostgreSQLでトランザクション不可の操作を使う場合は、個別に注意事項を書く。
- 実行前に `management_app.sql_history` を確認する。
- 同じ `script_no` が登録済みの場合は実行しない。
- 実行後にテーブル、カラム、制約、データを確認する。
