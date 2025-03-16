import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categoria } from '../../interfaces/categoria';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginValidateService {


  private apiUrl = 'http://localhost:8088/categoria';
  private apiUrlLogin = 'http://localhost:8088/login';
   
     constructor(private http:HttpClient) { }

     validationLogin(username : string, middle : string):Observable<any>{
      return this.http.post<any>(`${this.apiUrlLogin + '/loginUser'}`, {username: username, middle : middle});
     }
     
     getAllCategorias():Observable<Categoria[]>{
         return this.http.get<Categoria[]>(this.apiUrl + '/getCategoria');
      }
}
