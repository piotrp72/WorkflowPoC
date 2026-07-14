import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NextStepResponse } from '../dto/NextStepResponse';

@Injectable({ providedIn: 'root' })
export class ProcessService {
  constructor(private http: HttpClient) {}

  createProcess() {
    return this.http.post<{ processId: string }>('http://localhost:8091/workflow/process', {});
  }

  getNextStep(processId: string) {
    return this.http.get<NextStepResponse>(`http://localhost:8091/workflow/${processId}/next-step`);
  }
}