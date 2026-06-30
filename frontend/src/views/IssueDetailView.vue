<template>
  <PageSection
    title="課題詳細"
    kicker="Issue Detail"
    description="課題の背景、担当、期限、進捗を確認するための画面です。"
  >
    <article class="detail-card">
      <div class="detail-head">
        <div>
          <p class="section-kicker">Issue {{ id }}</p>
          <h3>課題 {{ id }} の詳細サマリー</h3>
        </div>
        <span class="pill">進行中</span>
      </div>

      <dl class="detail-grid">
        <div>
          <dt>プロジェクト</dt>
          <dd>Alpha Lane</dd>
        </div>
        <div>
          <dt>担当者</dt>
          <dd>Airi Kato</dd>
        </div>
        <div>
          <dt>優先度</dt>
          <dd>High</dd>
        </div>
        <div>
          <dt>期限</dt>
          <dd>2026-07-10</dd>
        </div>
      </dl>

      <p class="detail-text">
        ここでは課題の経緯や対応方針、関連リンクなどを確認できます。初期プロジェクトでは
        モックデータ表示に留め、将来的に API 連携へ切り替える想定です。
      </p>
    </article>
  </PageSection>
</template>

<script setup lang="ts">
defineProps<{
  id: string;
}>();
</script>
