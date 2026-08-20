import { bootstrapApplication } from '@angular/platform-browser';
import { calculatorConfig } from './app/calculator.config';
import { CalculatorComponent } from './app/component/calculator/calculator.component';

bootstrapApplication(CalculatorComponent, calculatorConfig).catch((err) => console.error(err));
