import { Routes } from '@angular/router';
import { loadRemoteModule } from '@angular-architects/module-federation';
import { ErrorComponent } from './component/error/error.component';

export const routes: Routes = [
  {
    path: 'calculator',
    loadChildren: () =>
      loadRemoteModule({
        type: 'module',
        remoteEntry: 'http://localhost:8082/remoteEntry.js',
        exposedModule: './routes',
      }).then((m) => m.routes),
  },
  {
    path: 'collector',
    loadChildren: () =>
      loadRemoteModule({
        type: 'module',
        remoteEntry: 'http://localhost:8083/remoteEntry.js',
        exposedModule: './routes',
      }).then((m) => m.routes),
  },
  {
    path: 'decision',
    loadChildren: () =>
      loadRemoteModule({
        type: 'module',
        remoteEntry: 'http://localhost:8084/remoteEntry.js',
        exposedModule: './routes'
      }).then(m => m.routes)
  },
  { path: 'error', 
    component: ErrorComponent 
  }
];
