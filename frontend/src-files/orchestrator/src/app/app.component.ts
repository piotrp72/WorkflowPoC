import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  applicationId = '';

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.applicationId = this.generateApplicationId();
    sessionStorage.setItem('applicationId', this.applicationId);
  }

  openKalkulator(): void {
    this.router.navigate(['/kalkulator']);
  }

  opencollector(): void {
    this.router.navigate(['/collector']);
  }

  private generateApplicationId(): string {
    return 'APP-' + Math.random().toString(36).slice(2, 10).toUpperCase();
  }
}
