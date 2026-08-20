import { bootstrapApplication } from '@angular/platform-browser';
import { collectorConfig } from './app/collector.config';
import { CollectorComponent } from './app/component/collector/collector.component';

bootstrapApplication(CollectorComponent, collectorConfig).catch((err) => console.error(err));
