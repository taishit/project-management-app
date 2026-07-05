<template>
  <div class="shell">
    <aside class="sidebar">
      <RouterLink class="brand" to="/">
        <span class="brand-mark">PF</span>
        <span>
          <strong>ProjectFlow</strong>
          <small>MVP Workspace</small>
        </span>
      </RouterLink>

      <nav class="menu">
        <RouterLink to="/">ダッシュボード</RouterLink>
        <RouterLink to="/projects">プロジェクト</RouterLink>
        <RouterLink to="/issues">課題</RouterLink>
      </nav>
    </aside>

    <main class="content">
      <RouterView />
    </main>
  </div>
</template>

<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
</script>
