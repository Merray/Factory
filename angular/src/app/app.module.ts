import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { RessourceMaterielleComponent } from './ressource-materielle/ressource-materielle.component';
import { RessourceMaterielleEditComponent } from './ressource-materielle/ressource-materielle-edit.component';
import {RessourceMaterielleService} from './service/ressource-materielle.service';
import { RessourceHumaineComponent } from './ressource-humaine/ressource-humaine.component';
import { RessourceHumaineEditComponent } from './ressource-humaine/ressource-humaine-edit.component';
import {routes} from './route';
import { CursusComponent } from './cursus/cursus.component';
import { CursusEditComponent } from './cursus/cursus-edit.component';
import { MatiereComponent } from './matiere/matiere.component';
import { MatiereEditComponent } from './matiere/matiere-edit.component';
import { LoginComponent } from './login/login.component';
import { LoginEditComponent } from './login/login-edit.component';
import { LessonComponent } from './lesson/lesson.component';
import { LessonEditComponent } from './lesson/lesson-edit.component';
import {AuthGuardService} from './service/auth/auth-guard.service';
import {AuthService} from './service/auth/auth.service';
import {AuthComponent} from './auth/auth.component';
import {FourOhFourComponent} from './four-oh-four/four-oh-four.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RessourceMaterielleComponent,
    RessourceMaterielleEditComponent,
    RessourceHumaineComponent,
    RessourceHumaineEditComponent,
    CursusComponent,
    CursusEditComponent,
    MatiereComponent,
    MatiereEditComponent,
    LoginComponent,
    LoginEditComponent,
    LessonComponent,
    LessonEditComponent,
    AuthComponent,
    FourOhFourComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [RessourceMaterielleService, AuthGuardService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
