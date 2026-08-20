import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CalculatorResponse } from '../model/CalculatorResponse';
import { CalculatorRequest } from '../model/CalculatorRequest'
import { Observable } from 'rxjs';
import { NextStep } from '../model/NextStep';

@Injectable({ providedIn: 'root' })
export class CalculatorService {
  constructor(private http: HttpClient) 
  {}

   finishTask(request: CalculatorRequest): Observable<NextStep> {
    return this.http.post<NextStep>(
      'http://localhost:8092/calculator/finish',
      request
    );
  }
}
