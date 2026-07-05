export interface Project {
  id: number;
  projectKey: string;
  name: string;
  description: string | null;
  createdAt: string;
  updatedAt: string;
}

export interface ProjectRequest {
  projectKey: string;
  name: string;
  description: string;
}
