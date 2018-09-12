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
import { LessonComponent } from './lesson/lesson.component';
import { LessonEditComponent } from './lesson/lesson-edit.component';

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
    LessonComponent,
    LessonEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [RessourceMaterielleService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
