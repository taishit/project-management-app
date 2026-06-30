package com.projectflow.service;

import com.projectflow.dto.DashboardSummaryResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public DashboardSummaryResponse getSummary() {
        return new DashboardSummaryResponse(
            8,
            14,
            3,
            List.of(
                "UI 改善タスクがレビュー待ちに移動",
                "API 設計の初版が共有完了",
                "プロジェクト Alpha Lane が開始"
            )
        );
    }
}
