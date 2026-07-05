import { Routes } from '@angular/router';
import { loadRemoteModule } from '@angular-architects/module-federation';
import { ErrorComponent } from './error.component';

export const routes: Routes = [
  {
    path: 'calculator',
    loadComponent: () =>
      loadRemoteModule({
        type: 'module',
        remoteEntry: 'http://localhost:8082/remoteEntry.js',
        exposedModule: './Component'
      }).then(m => m.AppComponent)
  },
  {
    path: 'collector',
    loadComponent: () =>
      loadRemoteModule({
        type: 'module',
        remoteEntry: 'http://localhost:8083/remoteEntry.js',
        exposedModule: './Component'
      }).then(m => m.AppComponent)
  },
  {
    path: 'decision',
    loadComponent: () =>
      loadRemoteModule({
        type: 'module',
        remoteEntry: 'http://localhost:8084/remoteEntry.js',
        exposedModule: './Component'
      }).then(m => m.AppComponent)
  },
  { path: 'error', 
    component: ErrorComponent 
  }
];
