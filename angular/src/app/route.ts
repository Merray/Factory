import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RessourceMaterielleComponent} from './ressource-materielle/ressource-materielle.component';
import {RessourceHumaineComponent} from './ressource-humaine/ressource-humaine.component';
import {RessourceHumaineEditComponent} from './ressource-humaine/ressource-humaine-edit.component';

export const routes: Routes = [{path: 'home', component: HomeComponent},
  {path: 'ressource/materielle', component: RessourceMaterielleComponent},
  {path: 'ressourcehumaine', component: RessourceHumaineComponent},
  {path: 'ressourcehumaine/edit/:id', component: RessourceHumaineEditComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}];
