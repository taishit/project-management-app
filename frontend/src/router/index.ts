import { createRouter, createWebHistory } from "vue-router";
import LoginView from "../views/LoginView.vue";
import DashboardView from "../views/DashboardView.vue";
import ProjectsView from "../views/ProjectsView.vue";
import IssuesView from "../views/IssuesView.vue";
import IssueDetailView from "../views/IssueDetailView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", redirect: "/dashboard" },
    { path: "/login", name: "login", component: LoginView },
    { path: "/dashboard", name: "dashboard", component: DashboardView },
    { path: "/projects", name: "projects", component: ProjectsView },
    { path: "/issues", name: "issues", component: IssuesView },
    { path: "/issues/:id", name: "issue-detail", component: IssueDetailView, props: true }
  ]
});

export default router;
