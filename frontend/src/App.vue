<template>
  <div class="shell">
    <aside class="sidebar">
      <div class="brand">
        <span class="brand-mark">PF</span>
        <div>
          <p class="brand-title">ProjectFlow</p>
          <p class="brand-subtitle">Project control studio</p>
        </div>
      </div>

      <nav class="menu">
        <RouterLink to="/dashboard">ダッシュボード</RouterLink>
        <RouterLink to="/projects">プロジェクト</RouterLink>
        <RouterLink to="/issues">課題</RouterLink>
        <RouterLink to="/login">ログイン</RouterLink>
      </nav>
    </aside>

    <main class="content">
      <header class="topbar">
        <div>
          <p class="eyebrow">Independent workflow board</p>
          <h1>ProjectFlow Workspace</h1>
        </div>
        <div class="status-chip">Preview Build</div>
      </header>

      <RouterView />
    </main>
  </div>
</template>

<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
</script>
