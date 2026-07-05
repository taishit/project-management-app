import { request } from "./httpClient";

export const healthApi = {
  get: () => request<{ status: string }>("/health")
};
