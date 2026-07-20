import { ChangeDetectorRef, Component, inject, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ProcessService } from './service/process.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent implements OnInit {
  private http = inject(HttpClient);
  processId = '';
  taskId = '';
  loading = true;
  error: string | null = null;

  constructor(
    private router: Router, 
    private cdr: ChangeDetectorRef,
    private processService: ProcessService
  ) {}

  ngOnInit(): void {
    this.loading = true;
    this.error = '';

      this.processService.createProcess().pipe(
        switchMap(response => {
          return this.processService.getNextStep(response.processId);
        })
      ).subscribe({
        next: response => {
          this.processId = response.processId;
          this.taskId = response.taskId;
          sessionStorage.setItem('processId', this.processId);
          sessionStorage.setItem('taskId', this.taskId);
          switch (response.step) {
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
              this.router.navigate(['/finish']); 
          }
        },
        error: err => {
          this.error = 'Nie udało się utworzyć wniosku.';
          this.loading = false;
          this.cdr.detectChanges();
        }
      }
    )
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
