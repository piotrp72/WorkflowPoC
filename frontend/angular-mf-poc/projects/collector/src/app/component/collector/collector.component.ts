import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './collector.component.html',
  styleUrl: './collector.component.css'
})
export class CollectorComponent implements OnInit {
  
  firstName = '';
  processId = '';
  taskId = '';

  constructor(
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

  openDecision(): void {
    this.router.navigate(['/decision']);
  }

}
