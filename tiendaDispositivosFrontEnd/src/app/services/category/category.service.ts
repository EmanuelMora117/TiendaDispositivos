import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categoria } from '../../interfaces/categoria';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private apiUrl = 'http://localhost:8088/categoria';
 
   constructor(private http:HttpClient) { }
   
   getAllCategorias():Observable<Categoria[]>{
       return this.http.get<Categoria[]>(this.apiUrl + '/getCategoria');
    }
   
    createCategoria(formData : FormData): Observable<any>{
       return this.http.post(`${this.apiUrl + '/createCategoria'}`, formData);
    }
     
     updateCategory(formData : FormData){
       return this.http.put(`${this.apiUrl + '/updateCategory'}`, formData);
     }
     
     deleteCategory(idCategory : number){
       return this.http.delete(`${this.apiUrl + '/deleteCategory'}?idCategoria=${idCategory}`);
     }

}
