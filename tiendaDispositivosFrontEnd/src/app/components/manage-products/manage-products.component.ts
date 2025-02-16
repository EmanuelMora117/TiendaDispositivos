import { Component } from '@angular/core';

@Component({
  selector: 'app-manage-products',
  imports: [],
  templateUrl: './manage-products.component.html',
  styleUrl: './manage-products.component.scss'
})
export class ManageProductsComponent {

  products: any[] = [
            {id: 1, titulo: "Iphone 13 128Gb", precio: '2.365.900', description: '', urlImage1:'images/Iphone 13.png', urlImage2:'images/Iphone 13 imagen2.png', urlImage3:'images/Iphone 13 imagen3.png'},
            {id: 2,titulo: "Iphone 11 128Gb", precio: '1.278.990', description: '', urlImage1:'images/Iphone 11.png', urlImage2:'images/Iphone 11 imagen2.png', urlImage3:'images/Iphone 11 imagen3.png'},
            {id: 3,titulo: "Iphone 14 128Gb 5G", precio: '3.175.489', description: '', urlImage1:'images/Iphone 14.png', urlImage2:'images/Iphone 14 imagen2.png', urlImage3:'images/Iphone 14 imagen3.png'},
            {id: 4,titulo: "SAMSUNG A35 256GB 5G Lila", precio: '1.599.990', description: '', urlImage1:'images/SAMSUNG A35 256GB.png', urlImage2:'images/SAMSUNG A35 256GB imagen2.png', urlImage3:'images/SAMSUNG A35 256GB imagen3.png'},
            {id: 5,titulo: "Samsung Galaxy S23 256GB 5G", precio: '4.899.990', description: '', urlImage1:'images/Samsung Galaxy S23 256GB 5G.png', urlImage2:'images/Samsung Galaxy S23 256GB 5G imagen2.png', urlImage3:'images/Samsung Galaxy S23 256GB 5G imagen3.png'},
            {id: 6,titulo: "SAMSUNG Galaxy A06 128GB", precio: '499.900', description: '', urlImage1:'images/SAMSUNG Galaxy A06 128GB.png', urlImage2:'images/SAMSUNG Galaxy A06 128GB imagen2.png', urlImage3:'images/SAMSUNG Galaxy A06 128GB imagen3.png'},
            {id: 7,titulo: "Celular Xiaomi 14T 512GB 5G", precio: '2.799.900', description: '',  urlImage1:'images/Xiaomi 14T 512GB 5G.png', urlImage2:'images/Xiaomi 14T 512GB 5G imagen2.png', urlImage3:'images/.png'},
            {id: 8,titulo: "XIAOMI Redmi A3 64GB", precio: '499.900', description: '', urlImage1:'images/XIAOMI Redmi A3 64GB.png', urlImage2:'images/XIAOMI Redmi A3 64GB imagen2.png', urlImage3:'images/XIAOMI Redmi A3 64GB imagen3.png'},
            {id: 9,titulo: "Celular REDMI Note 13 256GB", precio: '1.399.900', description: '', urlImage1:'images/REDMI Note 13 256GB.png', urlImage2:'images/REDMI Note 13 256GB imagen2.png', urlImage3:'images/REDMI Note 13 256GB imagen3.png'}
          ];

    keys: any[] = [];

    ngOnInit(){
      this.keys = Object.keys(this.products[0])
    }
}
