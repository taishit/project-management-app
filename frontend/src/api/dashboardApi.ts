import { request } from "./httpClient";
import type { Dashboard } from "../types/dashboard";

export const dashboardApi = {
  get: () => request<Dashboard>("/dashboard")
};
