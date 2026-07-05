# 04 API一覧

## 共通

Base URL は `http://localhost:8080/api` とする。

エラーレスポンスは以下の形式とする。

```json
{
  "message": "入力内容を確認してください。",
  "details": ["name: must not be blank"]
}
```

## エンドポイント

| メソッド | パス | 概要 |
| --- | --- | --- |
| GET | `/health` | ヘルスチェック |
| GET | `/dashboard` | ダッシュボード集計取得 |
| GET | `/projects` | プロジェクト一覧取得 |
| GET | `/projects/{id}` | プロジェクト詳細取得 |
| POST | `/projects` | プロジェクト登録 |
| PUT | `/projects/{id}` | プロジェクト更新 |
| DELETE | `/projects/{id}` | プロジェクト削除 |
| GET | `/issues` | 課題一覧取得 |
| GET | `/issues/{id}` | 課題詳細取得 |
| POST | `/issues` | 課題登録 |
| PUT | `/issues/{id}` | 課題更新 |
| DELETE | `/issues/{id}` | 課題削除 |

## クエリパラメータ

`GET /issues` は以下の絞り込みに対応する。

| パラメータ | 型 | 概要 |
| --- | --- | --- |
| projectId | number | プロジェクトIDで絞り込み |
| status | string | `TODO`, `IN_PROGRESS`, `REVIEW`, `DONE` で絞り込み |

## リクエスト例

```json
{
  "projectId": 1,
  "title": "課題タイトル",
  "description": "説明",
  "status": "TODO",
  "priority": "MEDIUM",
  "assigneeName": "担当者",
  "dueDate": "2026-07-31"
}
```
