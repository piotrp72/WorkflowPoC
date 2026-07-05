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
  applicationId = '';
  loading = true;
  error: string | null = null;

  constructor(
    private router: Router, 
    private cdr: ChangeDetectorRef,
    private processService: ProcessService
  ) {}

//  ngOnInit(): void {
//    this.generateApplicationId();
//  }

  ngOnInit(): void {
    this.loading = true;
    this.error = '';

      this.processService.createProcess().pipe(
        switchMap(response => {
          this.applicationId = response.applicationId;
          sessionStorage.setItem('applicationId', this.applicationId);
          return this.processService.getNextStep(response.applicationId);
        })
      ).subscribe({
        next: response => {
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

  private generateApplicationId(): void {
    this.loading = true;
    this.error = '';

    this.http.post<{ applicationId: string }>('http://localhost:8091/workflow/process', {})
      .subscribe({
        next: response => {
          this.applicationId = response.applicationId;
          sessionStorage.setItem('applicationId', this.applicationId);
          this.loading = false;
          this.cdr.detectChanges();
        },
        error: () => {
          this.error = 'Nie udało się utworzyć wniosku.';
          this.loading = false;
          this.cdr.detectChanges();
        }
      });
  }
}
