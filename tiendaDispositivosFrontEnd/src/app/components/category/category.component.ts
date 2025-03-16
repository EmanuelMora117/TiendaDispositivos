import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ProductService } from '../../services/product/product.service';
import { Product } from '../../interfaces/product';
import { Data } from '../../models/data.model';
import { Marca } from '../../interfaces/marca';

@Component({
  selector: 'app-category',
  imports: [],
  templateUrl: './category.component.html',
  styleUrl: './category.component.scss'
})
export class CategoryComponent {

  @Output() showProduct = new EventEmitter<boolean>();
  @Input() categorySelected: string = '';
  marca: Marca[] = [];

  constructor (
    private productService : ProductService,
    private modelData : Data
    
  )
  {}
  

  ngOnInit(){
    this.getProductByCategoria();
  }

  getProductByCategoria(){
    this.productService.getProductByCategory(this.modelData.getIdCategoria()).subscribe((data) =>{
      this.marca = data;
      console.log(this.marca)
    })
  }

  showProductSelected(product :any){
    console.log(product)
    this.showProduct.emit(product);
  }
}
