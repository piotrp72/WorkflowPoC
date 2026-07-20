import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CalculatorService } from '../service/calculator.service'
import { CalculatorResponse } from '../dto/CalculatorResponse';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './calculator.component.html',
  styleUrl: './calculator.component.css'
})

export class CalculatorComponent implements OnInit {
  amount = '';
  processId = '';
  taskId = '';
 
   constructor(
    private calculatorService: CalculatorService  
   ) {}

  ngOnInit(): void {
    this.processId = sessionStorage.getItem('processId') ?? 'BRAK-ID';
    this.taskId = sessionStorage.getItem('taskId') ?? 'BRAK-ID';
  }

  finishTask(): void {
    const request = {
      processId: this.processId,
      taskId: this.taskId,
      amount: Number(this.amount)
    };

    this.calculatorService.finishTask(request).subscribe({
      next: (response: CalculatorResponse) => {
        console.log('Task finished', response);
      },
      error: (err: unknown) => {
        console.error('Finish failed', err);
      }
    });
}
}