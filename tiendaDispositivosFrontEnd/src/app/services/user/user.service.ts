import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsuarioCliente } from '../../interfaces/UsuarioCliente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrlCliente = 'http://localhost:8088/cliente';

  constructor(private http:HttpClient) { }


  createUserCliente(usuarioCliente: UsuarioCliente): Observable<any>{
    return this.http.post(`${this.apiUrlCliente + '/createCliente'}`, usuarioCliente);
  }

  updateClient(datosCliente: UsuarioCliente){

  }

  deleteCliente(datosCliente: UsuarioCliente){

  }
}
