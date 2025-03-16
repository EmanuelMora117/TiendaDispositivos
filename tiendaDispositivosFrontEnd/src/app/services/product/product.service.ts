import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Marca } from '../../interfaces/marca';
import { Product } from '../../interfaces/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl = 'http://localhost:8088/marca';
  private apiUrlProduct = 'http://localhost:8088/product';


  constructor(private http:HttpClient) { }

  getProductByCategory(idCategoria : number):Observable<Marca[]>{
    return this.http.get<Marca[]>(`${this.apiUrl + '/getMarcaYProductos'}?category=${idCategoria}`);
  }

  getAllProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.apiUrlProduct + '/getAllProducts');
  }

  createProduct(formData: FormData): Observable<any>{ 
    return this.http.post(`${this.apiUrlProduct + '/insertProduct'}`, formData);
  }
  
  updateProduct(formData: FormData){
    return this.http.put(`${this.apiUrlProduct + '/updateProduct'}`, formData);
  }
  
  deleteProduct(idProduct : number){
    return this.http.delete(`${this.apiUrlProduct + '/deleteProduct'}?idProduct=${idProduct}`);
  }
}
