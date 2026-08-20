import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/orchestrator.config';
import { OrchestratorComponent } from './app/component/orchestrator/orchestrator.component';

bootstrapApplication(OrchestratorComponent, appConfig).catch((err) => console.error(err));