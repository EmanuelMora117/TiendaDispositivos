import { Component } from '@angular/core';
import { ManageAdminsComponent } from '../manage-admins/manage-admins.component';
import { ManageProductsComponent } from '../manage-products/manage-products.component';
import { ManageCategoryComponent } from '../manage-category/manage-category.component';
import { ManageMarcaComponent } from '../manage-marca/manage-marca.component';



@Component({
  selector: 'app-type-view-manage',
  imports: [ManageAdminsComponent, ManageProductsComponent, ManageCategoryComponent, ManageMarcaComponent],
  templateUrl: './type-view-manage.component.html',
  styleUrl: './type-view-manage.component.scss'
})
export class TypeViewManageComponent {

  typeView: string = '';

keys: any[] = [];

ngOnInit(){
}

changeView(view: string){
  this.typeView = view;
}
}
