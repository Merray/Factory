import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RessourceMaterielleComponent} from './ressource-materielle/ressource-materielle.component';
import {RessourceHumaineComponent} from './ressource-humaine/ressource-humaine.component';
import {RessourceHumaineEditComponent} from './ressource-humaine/ressource-humaine-edit.component';
import {CursusComponent} from './cursus/cursus.component';

export const routes: Routes = [{path: 'home', component: HomeComponent},
  {path: 'ressourcematerielle', component: RessourceMaterielleComponent},
  {path: 'ressourcehumaine', component: RessourceHumaineComponent},
  {path: 'ressourcehumaine/edit/:id', component: RessourceHumaineEditComponent},
  {path: 'ressourcehumaine/create/stagiaire', component: RessourceHumaineEditComponent},
  {path: 'ressourcehumaine/create/gestionnaire', component: RessourceHumaineEditComponent},
  {path: 'ressourcehumaine/create/technicien', component: RessourceHumaineEditComponent},
  {path: 'ressourcehumaine/create/formateur', component: RessourceHumaineEditComponent},

  {path: 'cursus', component: CursusComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}];
