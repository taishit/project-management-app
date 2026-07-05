import { request } from "./httpClient";
import type { Project, ProjectRequest } from "../types/project";

export const projectApi = {
  findAll: () => request<Project[]>("/projects"),
  findById: (id: number) => request<Project>(`/projects/${id}`),
  create: (body: ProjectRequest) => request<Project>("/projects", { method: "POST", body: JSON.stringify(body) }),
  update: (id: number, body: ProjectRequest) => request<Project>(`/projects/${id}`, { method: "PUT", body: JSON.stringify(body) }),
  delete: (id: number) => request<void>(`/projects/${id}`, { method: "DELETE" })
};
