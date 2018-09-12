import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {RessourceMaterielle} from '../model/ressourceMaterielle';
import {Ordinateur} from '../model/RessourceMaterielleHeritage/ordinateur';
import {VideoProjecteur} from '../model/RessourceMaterielleHeritage/videoProjecteur';
import {Salle} from '../model/RessourceMaterielleHeritage/salle';

@Injectable({
  providedIn: 'root'
})
export class RessourceMaterielleService {

  url: string = 'http://localhost:8080/factory';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic ' + btoa('olivier:olivier')});
  }

  public list(): Observable<RessourceMaterielle[]> {
    return this.http.get<RessourceMaterielle[]>(`${this.url}/rest/ressourcematerielle/`, {headers: this.header});
  }

  public listO(): Observable<Ordinateur[]> {
    return this.http.get<Ordinateur[]>(`${this.url}/rest/ressourcematerielle/ordinateur`, {headers: this.header});
  }
  public listS(): Observable<Salle[]> {
    return this.http.get<Salle[]>(`${this.url}/rest/ressourcematerielle/salle`, {headers: this.header});
  }
  public listV(): Observable<VideoProjecteur[]> {
    return this.http.get<VideoProjecteur[]>(`${this.url}/rest/ressourcematerielle/videoprojecteur`, {headers: this.header});
  }
  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/ressourcematerielle/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<RessourceMaterielle> {
    return this.http.get<RessourceMaterielle>(`${this.url}/rest/ressourcematerielle/${id}`, {headers: this.header});
  }

  public save(ressourceMaterielle: RessourceMaterielle): Observable<any> {
    if (ressourceMaterielle.id) {
      return this.http.put(`${this.url}/rest/ressourcematerielle/`, ressourceMaterielle, {headers: this.header});
    } else {

      if (ressourceMaterielle instanceof Ordinateur) {
        const o = {
          id: ressourceMaterielle.id, coutUtilisation: ressourceMaterielle.coutUtilisation, code: ressourceMaterielle.code,
          processeur: ressourceMaterielle.processeur, ram: ressourceMaterielle.ram,
          disqueDur: ressourceMaterielle.disqueDur, anneeAchat: ressourceMaterielle.anneeAchat, stagiaires: ressourceMaterielle.stagiaires,
          type: ressourceMaterielle.type
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/ressourcematerielle/ordinateur`, o, {headers: this.header});
      } else if (ressourceMaterielle instanceof VideoProjecteur) {
        const o = {
          id: ressourceMaterielle.id, coutUtilisation: ressourceMaterielle.coutUtilisation, code: ressourceMaterielle.code,
          type: ressourceMaterielle.type
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/ressourcematerielle/videoprojecteur`, o, {headers: this.header});
      } else if (ressourceMaterielle instanceof Salle) {
        const o = {
          id: ressourceMaterielle.id, coutUtilisation: ressourceMaterielle.coutUtilisation, code: ressourceMaterielle.code,
          nbPersonne: ressourceMaterielle.nbPersonne, type: ressourceMaterielle.type
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/ressourcematerielle/salle`, o, {headers: this.header});
      }
    }
  }


}
