import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Cursus} from '../../model/cursus';

@Injectable({
  providedIn: 'root'
})
export class CursusService {

  url: string = 'http://localhost:8080/factory';
  headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.headers = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic ' + btoa('olivier:olivier')});
  }

  public list(): Observable<Cursus[]> {
    return this.http.get<Cursus[]>(`${this.url}/rest/cursus/`, {headers: this.headers});
  }


  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/cursus/${id}`, {headers: this.headers});

  }

  public findById(id: number): Observable<Cursus> {
    return this.http.get<Cursus>(`${this.url}/rest/cursus/${id}`, {headers: this.headers});
  }

  public save(cursus: Cursus): Observable<any> {
    if (cursus.id) {
      // update
      return this.http.put(`${this.url}/rest/cursus/`, cursus, {headers: this.headers});
    } else {
      // create
      const o = {
        id: cursus.id, dateDebut: cursus.dateDebut, dateFin: cursus.dateFin, nbStagiaire: cursus.nbStagiaire, salle: cursus.salle,
        stagiaires: cursus.stagiaires, videoProjecteur: cursus.videoProjecteur
      };
      return this.http.post(`${this.url}/rest/cursus/`, o, {headers: this.headers});
    }
  }
}
