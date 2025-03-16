import { Component } from '@angular/core';
import { CategoryComponent} from '../category/category.component';
import { ProductViewComponent } from '../product-view/product-view.component'; 
import { LoginComponent } from '../login/login.component';
import { ManageProductsComponent } from '../manage-products/manage-products.component';
import { CategoriaService } from '../../services/categoria.service';
import { Categoria } from '../../interfaces/categoria';
import { Data } from '../../models/data.model';
import { TypeViewManageComponent } from '../type-view-manage/type-view-manage.component';


@Component({
  selector: 'app-home',
  imports: [CategoryComponent, ProductViewComponent, LoginComponent, TypeViewManageComponent],
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
  categoria : Categoria[] = [];

  constructor(
    private categoriaService : CategoriaService,
    protected modelData: Data
  ){}

  ngOnInit(){
    console.log(localStorage.getItem("Usuario"))
    console.log(localStorage.getItem("Tipo"))
    if(localStorage.getItem("Usuario")){
      this.modelData.setSession(true);
      const tipo = localStorage.getItem("Tipo");
      if (tipo !== null) {
        this.modelData.setTipo(tipo);
      }
    }

    this.getAllCategorias();
  }

  getAllCategorias(){
    this.categoriaService.getAllCategoria().subscribe((data) =>{
      this.categoria = data;
      console.log(this.categoria)
    })
  }

  logOut(){
    localStorage.removeItem("Usuario");
    localStorage.removeItem("Tipo");
    window.location.reload();
  }

  changeProductView(category: any){
    this.categoryPorducts = category.categoriaDescripcion;
    this.modelData.setIdCategoria(category.idCategoria);
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

