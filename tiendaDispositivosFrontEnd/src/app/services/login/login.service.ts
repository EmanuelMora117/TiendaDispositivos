import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../../interfaces/categoria';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private apiUrl = 'http://localhost:8088/login';

  constructor(private http: HttpClient) {}


  getAllCategoria():Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.apiUrl);
  }

  logout() {
  }
}
