import { Component } from '@angular/core';
import { CategoryComponent} from '../category/category.component';
import { ProductViewComponent } from '../product-view/product-view.component'; 
import { LoginComponent } from '../login/login.component';
import { ManageProductsComponent } from '../manage-products/manage-products.component';

@Component({
  selector: 'app-home',
  imports: [CategoryComponent, ProductViewComponent, LoginComponent, ManageProductsComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  showProductSelected: any[] = [];
  showView3: boolean = false;
  showGeneralProducts: string = 'general';
  typeUser: boolean = false;
  userLogged : boolean = false;
  categoryPorducts: string = '';

  ngOnInit(){

  }

  changeProductView(category: string){
    this.categoryPorducts = category;
    this.showGeneralProducts = this.showGeneralProducts == 'general' ? 'category' : 'general';
  }

  showProduct(show: any){
    this.showProductSelected = [show];
    this.showView3 = true;
    this.showGeneralProducts = ''
  }

  returnHome(){
    this.showGeneralProducts = 'general';
    this.showView3 = false;
  }

}

