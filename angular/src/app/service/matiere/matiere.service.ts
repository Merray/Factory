import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Matiere} from '../../model/matiere';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  url: string = 'http://localhost:8080/TPVolAngular';
  headers: HttpHeaders;

  constructor(private http: HttpClient) {
    // this.headers = new HttpHeaders({'Content-Type': 'application/json', 'Authorization': 'Basic ' + btoa('florent:florent')});
  }

  public list(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>(`${this.url}/rest/matiere`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/matiere/${id}`);
  }

  public findById(id: number): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/rest/matiere/${id}`);
  }

  public save(matiere: Matiere): Observable<any> {
    if (matiere.id) {
      return this.http.put(`${this.url}/rest/matiere/`, matiere);
    } else {
      const o = {
        id: matiere.id, titre: matiere.titre, niveau: matiere.niveau
      };
      return this.http.post(`${this.url}/rest/reservation/`, o);
    }
  }
}
