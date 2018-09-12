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
  {path: 'ressourcematerielle', canActivate: [AuthGuardService], component: RessourceMaterielleComponent},
  {path: 'ressourcematerielle/edit/:id', canActivate: [AuthGuardService], component: RessourceMaterielleEditComponent},
  {path: 'ressourcematerielle/create/:type', canActivate: [AuthGuardService], component: RessourceMaterielleEditComponent},
  {path: 'ressourcehumaine', canActivate: [AuthGuardService], component: RessourceHumaineComponent},
  {path: 'ressourcehumaine/edit/:id', canActivate: [AuthGuardService], component: RessourceHumaineEditComponent},
  {path: 'ressourcehumaine/create/:type', canActivate: [AuthGuardService], component: RessourceHumaineEditComponent},
  {path: 'cursus', canActivate: [AuthGuardService], component: CursusComponent},
  {path: 'cursus/create', canActivate: [AuthGuardService], component: CursusEditComponent},
  {path: 'cursus/edit/:id', canActivate: [AuthGuardService], component: CursusEditComponent},
  {path: 'matiere', canActivate: [AuthGuardService], component: MatiereComponent},
  {path: 'matiere/create', canActivate: [AuthGuardService], component: MatiereEditComponent},
  {path: 'matiere/edit/:id', canActivate: [AuthGuardService], component: MatiereEditComponent},
  {path: 'lesson', canActivate: [AuthGuardService], component: LessonComponent},
  {path: 'lesson/create', canActivate: [AuthGuardService], component: LessonEditComponent},
  {path: 'lesson/edit/:id', canActivate: [AuthGuardService],  component: LessonEditComponent},
  {path: 'login', canActivate: [AuthGuardService], component: LoginEditComponent},
  {path: '', redirectTo: 'auth', pathMatch: 'full'},
  {path: 'not-found', component: FourOhFourComponent},
  {path: '**', redirectTo: 'not-found'}
  ,
];
