import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RessourceMaterielleComponent} from './ressource-materielle/ressource-materielle.component';

export const routes: Routes = [{path: 'home', component: HomeComponent},
  {path: 'ressource/materielle', component: RessourceMaterielleComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}];
