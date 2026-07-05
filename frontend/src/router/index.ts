import { createRouter, createWebHistory } from "vue-router";
import DashboardView from "../views/DashboardView.vue";
import ProjectListView from "../views/ProjectListView.vue";
import ProjectFormView from "../views/ProjectFormView.vue";
import IssueListView from "../views/IssueListView.vue";
import IssueFormView from "../views/IssueFormView.vue";
import IssueDetailView from "../views/IssueDetailView.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", name: "dashboard", component: DashboardView },
    { path: "/projects", name: "projects", component: ProjectListView },
    { path: "/projects/new", name: "project-new", component: ProjectFormView },
    { path: "/projects/:id/edit", name: "project-edit", component: ProjectFormView, props: true },
    { path: "/issues", name: "issues", component: IssueListView },
    { path: "/issues/new", name: "issue-new", component: IssueFormView },
    { path: "/issues/:id", name: "issue-detail", component: IssueDetailView, props: true },
    { path: "/issues/:id/edit", name: "issue-edit", component: IssueFormView, props: true }
  ]
});

export default router;
