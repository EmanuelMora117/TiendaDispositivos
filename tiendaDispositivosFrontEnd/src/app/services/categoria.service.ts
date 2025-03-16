import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categoria } from '../interfaces/categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  private apiUrl = 'http://localhost:8088/categoria/getCategoria'

  constructor(private http:HttpClient) {}

  getAllCategoria():Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.apiUrl);
  }
}
  