package com.projectflow.repository;

import com.projectflow.entity.Issue;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryIssueRepository implements IssueRepository {

    private static final List<Issue> ISSUES = List.of(
        new Issue(1L, "ISS-101", 1L, "Alpha Lane", "ログイン画面の導線整理", "進行中", "High", "Airi Kato", "2026-07-10", "初回利用者の導線を整理して迷いを減らす"),
        new Issue(2L, "ISS-102", 2L, "Nova Hub", "課題詳細 API の仕様確認", "未着手", "Medium", "Ren Ito", "2026-07-12", "フロントエンド連携に必要なレスポンス構造を確認する"),
        new Issue(3L, "ISS-103", 3L, "Sprint Canvas", "ダッシュボード指標の見直し", "レビュー待ち", "Low", "Mio Sato", "2026-07-15", "主要 KPI の見え方を調整する")
    );

    @Override
    public List<Issue> findAll() {
        return ISSUES;
    }

    @Override
    public Optional<Issue> findById(Long id) {
        return ISSUES.stream().filter(issue -> issue.id().equals(id)).findFirst();
    }
}
