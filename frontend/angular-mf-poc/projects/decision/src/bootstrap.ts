import { bootstrapApplication } from '@angular/platform-browser';
import { decisionConfig } from './app/decision.config';
import { DecisionComponent } from './app/component/decision/decision.component';

bootstrapApplication(DecisionComponent, decisionConfig).catch((err) => console.error(err));
