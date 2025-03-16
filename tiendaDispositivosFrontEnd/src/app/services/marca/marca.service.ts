import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Marca } from '../../interfaces/marca';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {

  private apiUrl = 'http://localhost:8088/marca';

  constructor(private http:HttpClient) { }
  
  getAllMarcas():Observable<Marca[]>{
      return this.http.get<Marca[]>(this.apiUrl + '/getAllMarcas');
    }
  
   createMarca(marca: Marca): Observable<any>{
      return this.http.post(`${this.apiUrl + '/createMarca'}`, marca);
    }
    
    updateMarca(marca: Marca){
      return this.http.put(`${this.apiUrl + '/updateMarca'}`, marca);
    }
    
    deleteMarca(idMarca : number){
      return this.http.delete(`${this.apiUrl + '/deleteMarca'}?idMarca=${idMarca}`);
    }
}
