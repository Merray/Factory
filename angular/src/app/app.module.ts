import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {routes} from '../route';
import { RessourceMaterielleComponent } from './ressource-materielle/ressource-materielle.component';
import { RessourceMaterielleEditComponent } from './ressource-materielle/ressource-materielle-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RessourceMaterielleComponent,
    RessourceMaterielleEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
