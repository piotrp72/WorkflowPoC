import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  amount = '';
  applicationId = '';

  ngOnInit(): void {
    this.applicationId = sessionStorage.getItem('applicationId') ?? 'BRAK-ID';
  }
}
