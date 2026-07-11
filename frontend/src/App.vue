<template>
  <div class="shell">
    <aside class="sidebar">
      <RouterLink class="brand" to="/">
        <span class="brand-mark">PF</span>
        <span>
          <strong>ProjectFlow</strong>
          <small>Team Workspace</small>
        </span>
      </RouterLink>

      <nav class="menu">
        <RouterLink to="/">ダッシュボード</RouterLink>
        <RouterLink to="/projects">プロジェクト</RouterLink>
        <RouterLink to="/issues">課題</RouterLink>
      </nav>

      <div class="sidebar-footer">
        <div class="user-info-block">
          <div class="user-avatar">PF</div>
          <div class="user-meta">
            <span class="user-name">ProjectFlow</span>
            <span class="user-role">v0.1.0</span>
          </div>
        </div>
      </div>
    </aside>

    <main class="content">
      <RouterView />
    </main>
  </div>
</template>

<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
</script>
