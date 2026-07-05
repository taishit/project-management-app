import { request } from "./httpClient";
import type { Issue, IssueRequest, IssueStatus } from "../types/issue";

export const issueApi = {
  findAll: (params: { projectId?: number; status?: IssueStatus } = {}) => {
    const query = new URLSearchParams();
    if (params.projectId) query.set("projectId", String(params.projectId));
    if (params.status) query.set("status", params.status);
    const suffix = query.toString() ? `?${query}` : "";
    return request<Issue[]>(`/issues${suffix}`);
  },
  findById: (id: number) => request<Issue>(`/issues/${id}`),
  create: (body: IssueRequest) => request<Issue>("/issues", { method: "POST", body: JSON.stringify(body) }),
  update: (id: number, body: IssueRequest) => request<Issue>(`/issues/${id}`, { method: "PUT", body: JSON.stringify(body) }),
  delete: (id: number) => request<void>(`/issues/${id}`, { method: "DELETE" })
};
