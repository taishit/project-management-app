import type { ApiError } from "../types/error";

const baseURL = "http://localhost:8080/api";

export async function request<T>(path: string, options: RequestInit = {}): Promise<T> {
  const response = await fetch(`${baseURL}${path}`, {
    headers: {
      "Content-Type": "application/json",
      ...options.headers
    },
    ...options
  });

  if (!response.ok) {
    let error: ApiError = { message: "APIリクエストに失敗しました。", details: [] };
    try {
      error = await response.json();
    } catch {
      error.message = `${response.status} ${response.statusText}`;
    }
    throw error;
  }

  if (response.status === 204) {
    return undefined as T;
  }
  return response.json();
}
