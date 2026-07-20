import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CalculatorResponse } from '../dto/CalculatorResponse';
import { CalculatorRequest } from '../dto/CalculatorRequest'
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class CalculatorService {
  constructor(private http: HttpClient) 
  {}

   finishTask(request: CalculatorRequest): Observable<CalculatorResponse> {
    return this.http.post<CalculatorResponse>(
      'http://localhost:8092/calculator/finish',
      request
    );
  }
}
