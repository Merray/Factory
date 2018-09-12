import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RessourceMaterielleComponent} from './ressource-materielle/ressource-materielle.component';
import {RessourceHumaineComponent} from './ressource-humaine/ressource-humaine.component';
import {RessourceHumaineEditComponent} from './ressource-humaine/ressource-humaine-edit.component';
import {CursusComponent} from './cursus/cursus.component';
import {RessourceMaterielleEditComponent} from './ressource-materielle/ressource-materielle-edit.component';
import {CursusEditComponent} from './cursus/cursus-edit.component';

export const routes: Routes = [{path: 'home', component: HomeComponent},
  {path: 'ressourcematerielle', component: RessourceMaterielleComponent},
  {path: 'ressourcematerielle/edit/:id', component: RessourceMaterielleEditComponent},
  {path: 'ressourcematerielle/create/:type', component: RessourceMaterielleEditComponent},
  {path: 'ressourcehumaine', component: RessourceHumaineComponent},
  {path: 'ressourcehumaine/edit/:id', component: RessourceHumaineEditComponent},
  {path: 'ressourcehumaine/create/:type', component: RessourceHumaineEditComponent},
  {path: 'cursus', component: CursusComponent},
  {path: 'cursus/create', component: CursusEditComponent},
  {path: 'cursus/edit/:id', component: CursusEditComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}];
