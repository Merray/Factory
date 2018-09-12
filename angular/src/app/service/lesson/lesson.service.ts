import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Matiere} from '../../model/matiere';
import {Lesson} from '../../model/lesson';

@Injectable({
  providedIn: 'root'
})
export class LessonService {

  url: string = 'http://localhost:8080/factory';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-Type': 'application/json', 'Authorization': 'Basic ' + btoa('olivier:olivier')});
  }

  public list(): Observable<Lesson[]> {
    return this.http.get<Lesson[]>(`${this.url}/rest/lesson`, {headers: this.header});
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/lesson/${id}`, {headers: this.header});
  }

  public findById(id: number): Observable<Lesson> {
    return this.http.get<Lesson>(`${this.url}/rest/lesson/${id}`, {headers: this.header});
  }

  public save(lesson: Lesson): Observable<any> {
    if (lesson.id) {
      return this.http.put(`${this.url}/rest/lesson/`, lesson, {headers: this.header});
    } else {
      const o = {
        id: lesson.id,
        dateDebut: lesson.dateDebut,
        dateFin: lesson.dateFin,
        formateur: lesson.formateur,
        matiere: lesson.matiere,
        cursus: lesson.cursus
      };
      return this.http.post(`${this.url}/rest/lesson/`, o, {headers: this.header});
    }
  }
}
