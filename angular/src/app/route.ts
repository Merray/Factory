import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RessourceMaterielleComponent} from './ressource-materielle/ressource-materielle.component';
import {RessourceHumaineComponent} from './ressource-humaine/ressource-humaine.component';
import {RessourceHumaineEditComponent} from './ressource-humaine/ressource-humaine-edit.component';
import {CursusComponent} from './cursus/cursus.component';
import {RessourceMaterielleEditComponent} from './ressource-materielle/ressource-materielle-edit.component';
import {CursusEditComponent} from './cursus/cursus-edit.component';
import {MatiereComponent} from './matiere/matiere.component';
import {MatiereEditComponent} from './matiere/matiere-edit.component';
import {LessonComponent} from './lesson/lesson.component';
import {LessonEditComponent} from './lesson/lesson-edit.component';
import {LoginEditComponent} from './login/login-edit.component';
import {AuthComponent} from './auth/auth.component';
import {FourOhFourComponent} from './four-oh-four/four-oh-four.component';
import {AuthGuardService} from './service/auth/auth-guard.service';

export const routes: Routes = [
  {path: 'auth', component: AuthComponent},
  {path: 'home', canActivate: [AuthGuardService], component: HomeComponent},
  {path: 'ressourcematerielle', component: RessourceMaterielleComponent},
  {path: 'ressourcematerielle/edit/:id', component: RessourceMaterielleEditComponent},
  {path: 'ressourcematerielle/create/:type', component: RessourceMaterielleEditComponent},
  {path: 'ressourcehumaine', component: RessourceHumaineComponent},
  {path: 'ressourcehumaine/edit/:id', component: RessourceHumaineEditComponent},
  {path: 'ressourcehumaine/create/:type', component: RessourceHumaineEditComponent},
  {path: 'cursus', component: CursusComponent},
  {path: 'cursus/create', component: CursusEditComponent},
  {path: 'cursus/edit/:id', component: CursusEditComponent},
  {path: 'matiere', component: MatiereComponent},
  {path: 'matiere/create', component: MatiereEditComponent},
  {path: 'matiere/edit/:id', component: MatiereEditComponent},
  {path: 'lesson', component: LessonComponent},
  {path: 'lesson/create', component: LessonEditComponent},
  {path: 'lesson/edit/:id', component: LessonEditComponent},
  {path: 'login', component: LoginEditComponent},
  {path: '', redirectTo: 'auth', pathMatch: 'full'},
  {path: 'not-found', component: FourOhFourComponent},
  {path: '**', redirectTo: 'not-found'}
  ,
];
