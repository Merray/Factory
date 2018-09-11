import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RessourceHumaine} from '../../model/ressource-humaine';
import {Observable} from 'rxjs';
import {Coordonnee} from '../../model/coordonnee';
import {Adresse} from '../../model/adresse';
import {Stagiaire} from '../../model/RessourceHumaineHeritage/stagiaire';
import {Gestionnaire} from '../../model/RessourceHumaineHeritage/gestionnaire';
import {Technicien} from '../../model/RessourceHumaineHeritage/technicien';
import {Formateur} from '../../model/RessourceHumaineHeritage/formateur';
import {Lesson} from '../../model/lesson';
import {Matiere} from '../../model/matiere';

@Injectable({
  providedIn: 'root'
})
export class RessourceHumaineService {

  url: string = 'http://localhost:8080/factory';
  headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.headers = new HttpHeaders({'Content-Type': 'application/json', 'Authorization': 'Basic ' + btoa('florent:florent')});
  }

  public list(): Observable<RessourceHumaine[]> {
    return this.http.get<RessourceHumaine[]>(`${this.url}/rest/ressourcehumaine`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/ressourcehumaine/${id}`, {headers: this.headers});
  }

  public findById(id: number): Observable<RessourceHumaine> {
    // @ts-ignore
    return this.http.get(`${this.url}/rest/ressourcehumaine/${id}`, {headers: this.headers});
  }

  public save(ressourceHumaine: Stagiaire): Observable<any> {
    if (ressourceHumaine.id) {
      console.log(ressourceHumaine);
      return this.http.put(`${this.url}/rest/ressourcehumaine/`, ressourceHumaine, {headers: this.headers});
    } else {
      if (ressourceHumaine instanceof Stagiaire) {
        const o = {
          id: ressourceHumaine.id, nom: ressourceHumaine.nom, prenom: ressourceHumaine.prenom, coordonnee: ressourceHumaine.coordonnee,
          adresse: ressourceHumaine.adresse, type: ressourceHumaine.type, profil: ressourceHumaine.profil,
          ordinateur: ressourceHumaine.ordinateur, cursus: ressourceHumaine.cursus
        };
        return this.http.post(`${this.url}/rest/ressourcehumaine/`, o, {headers: this.headers});
      } else if (ressourceHumaine instanceof Gestionnaire) {
        const o = {
          id: ressourceHumaine.id, nom: ressourceHumaine.nom, prenom: ressourceHumaine.prenom, coordonnee: ressourceHumaine.coordonnee,
          adresse: ressourceHumaine.adresse, type: ressourceHumaine.type, cursusGeres: ressourceHumaine.cursusGeres
        };
        return this.http.post(`${this.url}/rest/ressourcehumaine/`, o, {headers: this.headers});
      } else if (ressourceHumaine instanceof Technicien) {
        const o = {
          id: ressourceHumaine.id, nom: ressourceHumaine.nom, prenom: ressourceHumaine.prenom, coordonnee: ressourceHumaine.coordonnee,
          adresse: ressourceHumaine.adresse, type: ressourceHumaine.type
        };
        return this.http.post(`${this.url}/rest/ressourcehumaine/`, o, {headers: this.headers});
      } else if (ressourceHumaine instanceof Formateur) {
        const o = {
          id: ressourceHumaine.id, nom: ressourceHumaine.nom, prenom: ressourceHumaine.prenom, coordonnee: ressourceHumaine.coordonnee,
          adresse: ressourceHumaine.adresse, type: ressourceHumaine.type, lessons: ressourceHumaine.lessons,
          matieres: ressourceHumaine.matieres
        };
        return this.http.post(`${this.url}/rest/ressourcehumaine/`, o, {headers: this.headers});
      }
    }
  }
}
