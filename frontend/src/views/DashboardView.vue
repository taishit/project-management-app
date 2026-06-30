<template>
  <PageSection
    title="ダッシュボード"
    kicker="Overview"
    description="進行中のプロジェクトと課題の状態をまとめて確認できます。"
  >
    <div class="stats-grid">
      <article class="stat-card">
        <span>進行中プロジェクト</span>
        <strong>8</strong>
      </article>
      <article class="stat-card">
        <span>未対応課題</span>
        <strong>14</strong>
      </article>
      <article class="stat-card">
        <span>本日期限</span>
        <strong>3</strong>
      </article>
    </div>

    <div class="panel-grid">
      <article class="panel">
        <h3>最近の更新</h3>
        <ul class="timeline">
          <li>UI 改善タスクがレビュー待ちに移動</li>
          <li>API 設計の初版が共有完了</li>
          <li>プロジェクト Alpha Lane が開始</li>
        </ul>
      </article>
      <article class="panel">
        <h3>注目プロジェクト</h3>
        <p>Alpha Lane, Nova Hub, Sprint Canvas</p>
      </article>
    </div>
  </PageSection>
</template>

<script setup lang="ts">
import PageSection from "../components/PageSection.vue";
</script>
