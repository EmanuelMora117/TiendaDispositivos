import { Component, Input } from '@angular/core';
import { Marca } from '../../interfaces/marca';

@Component({
  selector: 'app-product-view',
  imports: [],
  templateUrl: './product-view.component.html',
  styleUrl: './product-view.component.scss'
})
export class ProductViewComponent {

  

  @Input() detailsProduct: Marca[] = [];
  img: string = '';

  productReviews: any[] = [
    { id: 1,
      categoria: "Celulares",
      items: [
        {
          marca: 'apple',
          opinionProductos: [
            {id: 1,titulo: "Iphone 13 128Gb", user: "Marcos", opinion:'Regular el servicio de entrega', qualification: 3, date:'30/01/25'},
            {id: 2,titulo: "Iphone 11 128Gb", user: "Andres Ortiz", opinion:'Muy buen producto', qualification: 4, date:'28/01/25'},
            {id: 3,titulo: "Iphone 14 128Gb 5G", user: "Ricardo Duque", opinion:'Excelente cumplimiento en entrega', qualification: 5, date:'05/02/25'}
            
          ]
        },
        {
          marca: 'Samsung',
          opinionProductos: [
            {id: 1, titulo: "SAMSUNG A35 256GB 5G Lila", user: "Sandra Perez", opinion:'Me encanto es muy lindo', qualification: 2,date:'30/01/25'},
            {id: 2, titulo: "Samsung Galaxy S23 256GB 5G", user: "Juan", opinion:'Me encanto es muy lindo, súper rápido y seguro', qualification: 5,date:'05/02/25'},
            {id: 3, titulo: "SAMSUNG Galaxy A06 128GB", user: "Elkin Rivera", opinion:'Muy bueno', qualification: 5,date:'28/01/25'}
          ]
        },
        {
          marca: 'Xiaomi',
          opinionProductos: [
            {id: 1, titulo: "Celular Xiaomi 14T 512GB 5G", user: "Paola restrepo", opinion:'súper bueno el producto', qualification: 5,date:'23/12/24'},
            {id: 2, titulo: "XIAOMI Redmi A3 64GB", user: "Paola Guzman", opinion:'Me encanto es muy lindo, súper rápido y seguro', qualification: 5,date:'18/12/24'},
            {id: 2, titulo: "XIAOMI Redmi A3 64GB", user: "Ana Garzon", opinion:'Me encanto es muy lindo', qualification: 5,date:'18/12/24'},
            {id: 2, titulo: "XIAOMI Redmi A3 64GB", user: "Elkin Rivera", opinion:'Excelente cumplimiento en entrega', qualification: 5,date:'18/12/24'},
            {id: 2, titulo: "XIAOMI Redmi A3 64GB", user: "Karol", opinion:'súper rápido y seguro', qualification: 5,date:'18/12/24'},
            {id: 3, titulo: "Celular REDMI Note 13 256GB", user: "Karol", opinion:'Me encanto', qualification: 5,date:'23/12/24'}
          ]
        }
      ]
    }]

    showProductReview: string = 'XIAOMI Redmi A3 64GB';


    ngOnInit(){
      this.img = this.detailsProduct[0].marca[0].image1;
    }

  changeImageMain(image: string){
     this.img = image;
  }
}
