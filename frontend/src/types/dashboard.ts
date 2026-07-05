import type { Issue } from "./issue";

export interface Dashboard {
  projectCount: number;
  issueCount: number;
  todoCount: number;
  inProgressCount: number;
  reviewCount: number;
  doneCount: number;
  recentIssues: Issue[];
}
