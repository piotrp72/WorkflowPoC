import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CalculatorService } from '../../service/calculator.service'
import { NextStep } from '../../model/NextStep';
import { Router } from '@angular/router';

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
  loading = true;
  error: string | null = null;
 
   constructor(
    private calculatorService: CalculatorService,  
    private cdr: ChangeDetectorRef,
    private router: Router
   ) {}

  ngOnInit(): void {
    try {
    this.processId = sessionStorage.getItem('processId') ?? 'BRAK-ID';
    this.taskId = sessionStorage.getItem('taskId') ?? 'BRAK-ID';
  } catch {
    this.processId = 'BRAK-ID';
    this.taskId = 'BRAK-ID';
  }
  }

  finishTask(): void {
    this.loading = true;
    this.error = '';

    const request = {
      processId: this.processId,
      taskId: this.taskId,
      amount: Number(this.amount)
    };

    
    this.calculatorService.finishTask(request).subscribe({
      next: (response: NextStep) => {
        console.log('Task finished', response);
        this.processId = response.processId;
        this.taskId = response.taskId;
        sessionStorage.setItem('processId', this.processId);
        sessionStorage.setItem('taskId', this.taskId);
        switch (response.nextStep) {
            case 'calculator':
              this.openCalculator();
              this.loading = false;
              this.cdr.detectChanges();
              break;
            case 'collector':
              this.openCollector();
              this.loading = false;
              this.cdr.detectChanges();
              break;
            case 'decision':
              this.openDecision();
              this.loading = false;
              this.cdr.detectChanges();
              break;
            default:
              this.router.navigate(['/error']); 
              //TODO: Tej ścieżki nie ma - chyba warto coś dodać. i raczej nie finish tylko błąd. zmieniam na error bo taka ścieżka chyba jest
          }
      },
      error: (err: unknown) => {
        console.error('Finish failed', err);
        this.error = 'Nie udało się zamknąć taska.';
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
}

openCalculator(): void {
    this.router.navigate(['/calculator']);
  }

  openCollector(): void {
    this.router.navigate(['/collector']);
  }

  openDecision(): void {
    this.router.navigate(['/decision']);
  } 

}

