import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  
  birthDate = '';
  applicationId = '';

  constructor(
    private router: Router
   ) {}

  ngOnInit(): void {
    this.applicationId = sessionStorage.getItem('applicationId') ?? 'BRAK-ID';
  }

  openDecision(): void {
    this.router.navigate(['/decision']);
  }

}
