import { Routes } from '@angular/router';
import { loadRemoteModule } from '@angular-architects/module-federation';

export const routes: Routes = [
  {
    path: 'kalkulator',
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
  }
];
