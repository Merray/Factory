import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {RessourceMaterielle} from '../model/RessourceMaterielle/ressourceMaterielle';
import {Ordinateur} from '../model/RessourceMaterielle/ordinateur';
import {VideoProjecteur} from '../model/RessourceMaterielle/videoProjecteur';
import {RessourceHumaine} from '../model/ressource-humaine';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  url: string = 'http://localhost:8080/demo';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic ' + btoa('olivier:olivier')});
  }

  public list(): Observable<RessourceMaterielle[]> {
    return this.http.get<RessourceMaterielle[]>(`${this.url}/rest/RessourceMaterielle/`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/RessourceMaterielle/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<RessourceMaterielle> {
    return this.http.get<RessourceMaterielle>(`${this.url}/rest/RessourceMaterielle/${id}`, {headers: this.header});
  }

  public save(article: RessourceMaterielle[]): Observable<any> {
    if (RessourceMaterielle.id) {
      return this.http.put(`${this.url}/rest/RessourceMaterielle/`, article, {headers: this.header});
    } else {
      /* return this.http.post(`${this.url}/rest/adherent/`, adherent);*/
      if (RessourceMaterielle instanceof Ordinateur) {
        const o = {
          id: RessourceMaterielle.id, coutUtilisation: RessourceMaterielle.coutUtilisation, code: RessourceMaterielle.code,
          processeur: RessourceMaterielle.processeur, ram: RessourceMaterielle.ram,
          disqueDur: RessourceMaterielle.disqueDur, anneeAchat: RessourceMaterielle.anneeAchat, StagiaireRattache: RessourceHumaine.id
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/RessourceMaterielle/`, o);
      } else if (article instanceof VideoProjecteur) {
        const o = {
          id: RessourceMaterielle.id, coutUtilisation: RessourceMaterielle.coutUtilisation, code: RessourceMaterielle.code,
        };
        console.log(o);
        return this.http.post(`${this.url}/rest/article/`, o, {headers: this.header});

      }

    }
  }


}
