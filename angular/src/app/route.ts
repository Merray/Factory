import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RessourceMaterielleComponent} from './ressource-materielle/ressource-materielle.component';
import {RessourceHumaineComponent} from './ressource-humaine/ressource-humaine.component';

export const routes: Routes = [{path: 'home', component: HomeComponent},
  {path: 'ressource/materielle', component: RessourceMaterielleComponent},
  {path: 'ressourcehumaine', component: RessourceHumaineComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}];
