import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class ProcessService {
  constructor(private http: HttpClient) {}

  createProcess() {
    return this.http.post<{ applicationId: string }>('http://localhost:8091/workflow/process', {});
  }

  getNextStep(applicationId: string) {
    return this.http.get<{ step: string }>(`http://localhost:8091/workflow/${applicationId}/next-step`);
  }
}