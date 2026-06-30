<template>
  <section class="page-section">
    <div class="section-heading">
      <p v-if="kicker" class="section-kicker">{{ kicker }}</p>
      <h2>{{ title }}</h2>
      <p v-if="description" class="section-description">{{ description }}</p>
    </div>
    <div class="section-body">
      <slot />
    </div>
  </section>
</template>

<script setup lang="ts">
defineProps<{
  title: string;
  kicker?: string;
  description?: string;
}>();
</script>
