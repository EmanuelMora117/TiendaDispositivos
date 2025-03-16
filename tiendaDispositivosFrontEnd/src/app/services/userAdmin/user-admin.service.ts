import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UsuarioAdmin } from '../../interfaces/UsuarioAdmin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserAdminService {

  constructor(private http:HttpClient) { }

  private apiUrl = 'http://localhost:8088/user';
  private apiUrlAdmin = 'http://localhost:8088/admin';

  getAllAdmin(): Observable<UsuarioAdmin[]>{
    return this.http.get<UsuarioAdmin[]>(`${this.apiUrl + '/getAllAdmins'}`);
  }

  createUserAdmin(createAdmin: UsuarioAdmin): Observable<any>{
    return this.http.post(`${this.apiUrlAdmin + '/createUserAdmin'}`, createAdmin);
  }

  updateAdmin(updateAdmin: UsuarioAdmin){
    return this.http.put(`${this.apiUrlAdmin + '/updateAdmin'}`, updateAdmin);
  }

  deleteAdmin(idAdmin : number){
    return this.http.delete(`${this.apiUrlAdmin + '/deleteAdmin'}?idUsu=${idAdmin}`);
  }
}
