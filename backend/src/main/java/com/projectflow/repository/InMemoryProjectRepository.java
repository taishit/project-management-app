package com.projectflow.repository;

import com.projectflow.entity.Project;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProjectRepository implements ProjectRepository {

    private static final List<Project> PROJECTS = List.of(
        new Project(1L, "PJF-101", "Alpha Lane", "進行中", "Airi Kato", "新規ダッシュボード改善プロジェクト"),
        new Project(2L, "PJF-102", "Nova Hub", "企画中", "Ren Ito", "API 連携を中心とした次期基盤構築"),
        new Project(3L, "PJF-103", "Sprint Canvas", "進行中", "Mio Sato", "課題管理導線の最適化")
    );

    @Override
    public List<Project> findAll() {
        return PROJECTS;
    }
}
