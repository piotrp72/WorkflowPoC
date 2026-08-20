import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './decision.component.html',
  styleUrl: './decision.component.css'
})
export class DecisionComponent implements OnInit {
   
  choice = '';
  processId = '';
  taskId = '';

  ngOnInit(): void {
   try {
    this.processId = sessionStorage.getItem('processId') ?? 'BRAK-ID';
    this.taskId = sessionStorage.getItem('taskId') ?? 'BRAK-ID';
  } catch {
    this.processId = 'BRAK-ID';
    this.taskId = 'BRAK-ID';
  }
  }
}
