import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../model/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = 'http://localhost:8080/factory';
  header: HttpHeaders;

  constructor(private http: HttpClient) {
    this.header = new HttpHeaders({'Content-type': 'application/json', 'Authorization': 'Basic '});
  }

  public list(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}/rest/login/`, {headers: this.header});

  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/rest/user/${id}`, {headers: this.header});

  }

  public findById(id: number): Observable<User> {
    return this.http.get<User>(`${this.url}/rest/user/${id}`, {headers: this.header});

  }

  public save(user: User): Observable<any> {
    if (user.username) {
      return this.http.put(`${this.url}/rest/user/`, user, {headers: this.header});
    } else {
      const o = {
        username: user.username, password: user.password, enable: user.enable, role: user.role
      };
      return this.http.post(`${this.url}/rest/login`, o, {headers: this.header});
    }
  }
}
