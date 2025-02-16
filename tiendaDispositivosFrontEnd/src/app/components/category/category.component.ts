import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-category',
  imports: [],
  templateUrl: './category.component.html',
  styleUrl: './category.component.scss'
})
export class CategoryComponent {

  @Output() showProduct = new EventEmitter<boolean>();
  @Input() categorySelected: string = '';

  products: any[] = [
    { id: 1,
      categoria: "Celulares",
      items: [
        {
          marca: 'apple',
          productos: [
            {id: 1, titulo: "Iphone 13 128Gb", precio: '2.365.900', urlImage1:'images/Iphone 13.png', urlImage2:'images/Iphone 13 imagen2.png', urlImage3:'images/Iphone 13 imagen3.png'},
            {id: 2,titulo: "Iphone 11 128Gb", precio: '1.278.990', urlImage1:'images/Iphone 11.png', urlImage2:'images/Iphone 11 imagen2.png', urlImage3:'images/Iphone 11 imagen3.png'},
            {id: 3,titulo: "Iphone 14 128Gb 5G", precio: '3.175.489', urlImage1:'images/Iphone 14.png', urlImage2:'images/Iphone 14 imagen2.png', urlImage3:'images/Iphone 14 imagen3.png'}
            
          ]
        },
        {
          marca: 'Samsung',
          productos: [
            {id: 1,titulo: "SAMSUNG A35 256GB 5G Lila", precio: '1.599.990', urlImage1:'images/SAMSUNG A35 256GB.png', urlImage2:'images/SAMSUNG A35 256GB imagen2.png', urlImage3:'images/SAMSUNG A35 256GB imagen3.png'},
            {id: 2,titulo: "Samsung Galaxy S23 256GB 5G", precio: '4.899.990', urlImage1:'images/Samsung Galaxy S23 256GB 5G.png', urlImage2:'images/Samsung Galaxy S23 256GB 5G imagen2.png', urlImage3:'images/Samsung Galaxy S23 256GB 5G imagen3.png'},
            {id: 3,titulo: "SAMSUNG Galaxy A06 128GB", precio: '499.900', urlImage1:'images/SAMSUNG Galaxy A06 128GB.png', urlImage2:'images/SAMSUNG Galaxy A06 128GB imagen2.png', urlImage3:'images/SAMSUNG Galaxy A06 128GB imagen3.png'}
          ]
        },
        {
          marca: 'Xiaomi',
          productos: [
            {id: 1,titulo: "Celular Xiaomi 14T 512GB 5G", precio: '2.799.900', urlImage1:'images/Xiaomi 14T 512GB 5G.png', urlImage2:'images/Xiaomi 14T 512GB 5G imagen2.png', urlImage3:'images/.png'},
            {id: 2,titulo: "XIAOMI Redmi A3 64GB", precio: '499.900', urlImage1:'images/XIAOMI Redmi A3 64GB.png', urlImage2:'images/XIAOMI Redmi A3 64GB imagen2.png', urlImage3:'images/XIAOMI Redmi A3 64GB imagen3.png'},
            {id: 3,titulo: "Celular REDMI Note 13 256GB", precio: '1.399.900', urlImage1:'images/REDMI Note 13 256GB.png', urlImage2:'images/REDMI Note 13 256GB imagen2.png', urlImage3:'images/REDMI Note 13 256GB imagen3.png'}
          ]
        }
      ]
    },
    {
      id: 2,
      categoria: "Computadores",
      items: [
        { 
          marca: "Asus", 
          productos:[
            {id: 1, titulo: "Asus ROG Strix G15", precio: '4.899.990', urlImage1:'images/asus rog strix g15.png', urlImage2:'images/asus rog strix g15 imagen2.png', urlImage3:'images/asus rog strix g15 imagen3.png'},
            {id: 2, titulo: "Portátil Asus L510", precio: '2.799.900', urlImage1:'images/Portátil Asus L510.png', urlImage2:'images/Portátil Asus L510 imagen2.png', urlImage3:'images/Portátil Asus L510 imagen3.png'},
            {id: 3, titulo: "ASUS E410", precio: '1.399.900', urlImage1:'images/ASUS 14.png', urlImage2:'images/ASUS 14 imagen2.png', urlImage3:'images/ASUS 14 imagen3.png'}
          ]
        },
        { marca: "HP", 
          productos:[
            {id: 1, titulo: "HP Spectre x360", precio: '4.399.900', urlImage1:'images/HP Spectre x360.png', urlImage2:'images/HP Spectre x360 imagen2.png', urlImage3:'images/HP Spectre x360 imagen3.png'},
            {id: 2, titulo: "Laptop Hp 14-fq1012la", precio: '1.399.900', urlImage1:'images/Laptop Hp 14-fq1012la.png', urlImage2:'images/Laptop Hp 14-fq1012la imagen2.png', urlImage3:'images/Laptop Hp 14-fq1012la imagen3.png' }
          ]
        },
      ]
    },
    {
      id: 3,
      categoria: "Smartwatches",
      items: [
        { 
          marca: "Redmi", 
          productos:[
            {
              titulo: "Redmi Watch 3", precio: 150
            }
          ] 
        },
        { 
          marca: "Apple", 
          productos:[
            {
              titulo: "Apple Watch Series 8", precio: 400
            }
          ] 
        },
        { 
          marca: "Samsung", 
          productos:[
            {
              titulo: "Samsung Galaxy Watch 5", precio: 350
            }
          ]
        }
      ]
    }
  ];
  

  ngOnInit(){

  }

  showProductSelected(product :any){
    this.showProduct.emit(product);
  }
}
