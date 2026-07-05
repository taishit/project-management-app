export type IssueStatus = "TODO" | "IN_PROGRESS" | "REVIEW" | "DONE";
export type IssuePriority = "LOW" | "MEDIUM" | "HIGH";

export interface Issue {
  id: number;
  projectId: number;
  projectKey: string;
  projectName: string;
  title: string;
  description: string | null;
  status: IssueStatus;
  statusLabel: string;
  priority: IssuePriority;
  priorityLabel: string;
  assigneeName: string | null;
  dueDate: string | null;
  createdAt: string;
  updatedAt: string;
}

export interface IssueRequest {
  projectId: number;
  title: string;
  description: string;
  status: IssueStatus;
  priority: IssuePriority;
  assigneeName: string;
  dueDate: string | null;
}
