import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CategoryService } from '../../services/category/category.service';
import { Categoria } from '../../interfaces/categoria';

@Component({
  selector: 'app-manage-category',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './manage-category.component.html',
  styleUrl: './manage-category.component.scss'
})
export class ManageCategoryComponent {

  formNewCategory!:FormGroup;
  formUpdateCategory!:FormGroup;

  constructor(private categoryServices : CategoryService){


    this.formNewCategory = new FormGroup({
                    categoriaDescripcion: new FormControl('', [Validators.required]),
                    imagen1: new FormControl(null, [Validators.required]),
                    imagen2: new FormControl(null, [Validators.required]),
                    imagen3: new FormControl(null, [Validators.required])
                  });
                  this.formUpdateCategory = new FormGroup({
                    idCategoria: new FormControl(0, [Validators.required]),
                    categoriaDescripcion: new FormControl('', [Validators.required]),
                    imagen1: new FormControl(null, [Validators.required]),
                    imagen2: new FormControl(null, [Validators.required]),
                    imagen3: new FormControl(null, [Validators.required])
                  });
  }

    keys: any[] = [];
    categorias: any[] = [];
    typeView: string = 'category';
    categoryUpdate: any = {};

    ngOnInit(){
      this.getAllCategoria();
    }
  
    getAllCategoria(refres?: string){
      this.categoryServices.getAllCategorias().subscribe((data =>{
        this.categorias = data;
        if(!refres){
          this.keys = Object.keys(this.categorias[0]);
        }
      }))
    }

    changeView(){
      this.typeView = this.typeView == 'category' ? 'formCategory' : 'category';
    }

    onFileChange(event: any, field: string) {
      const file = event.target.files[0];
      if (file) {
        this.formNewCategory.patchValue({
          [field]: file
        });
        console.log(`${field} - Archivo seleccionado:`, file);
      }
    }

    onFileChangeUpdate(event: any, field: string) {
      const file = event.target.files[0];
      if (file) {
        this.formUpdateCategory.patchValue({
          [field]: file
        });
        console.log(`${field} - Archivo seleccionado:`, file);
      }
    }

    validationProduct(){
            if (this.formNewCategory.valid) {
               const formData = new FormData();

               formData.append('categoriaDescripcion', this.formNewCategory.value.categoriaDescripcion);
           
               if (this.formNewCategory.value.imagen1) {
                 formData.append('imagen1', this.formNewCategory.value.imagen1);
               }
               if (this.formNewCategory.value.imagen2) {
                 formData.append('imagen2', this.formNewCategory.value.imagen2);
               }
               if (this.formNewCategory.value.imagen3) {
                 formData.append('imagen3', this.formNewCategory.value.imagen3);
               }
               this.insertCategory(formData);
            }
        }
    
        validationUpdate(){
          if (this.formUpdateCategory.valid) {
            const formData = new FormData();

            formData.append('idCategoria', this.categoryUpdate.idCategoria);
            formData.append('categoriaDescripcion', this.formUpdateCategory.value.categoriaDescripcion);
        
            if (this.formUpdateCategory.value.imagen1) {
              formData.append('imagen1', this.formUpdateCategory.value.imagen1);
            }
            if (this.formUpdateCategory.value.imagen2) {
              formData.append('imagen2', this.formUpdateCategory.value.imagen2);
            }
            if (this.formUpdateCategory.value.imagen3) {
              formData.append('imagen3', this.formUpdateCategory.value.imagen3);
            }

            this.updateCategoryData(formData);
         }
        }



          insertCategory(formData : FormData){
              this.categoryServices.createCategoria(formData).subscribe(response => {
                setTimeout(() => {
                  this.getAllCategoria('refresh');
                  this.changeView();
                }, 2000);
                })
            }
    
            updateCategoryForm(cateogry: any){
              this.typeView = this.typeView == 'category' ? 'FormsUpdate' : 'category';
              console.log(cateogry)
              this.categoryUpdate = cateogry;
              this.formUpdateCategory.patchValue({
                categoriaDescripcion: this.categoryUpdate.categoriaDescripcion
              });
            }
        
            updateCategoryData(formData : FormData){
              this.categoryServices.updateCategory(formData).subscribe(response => {
                setTimeout(() => {
                  this.getAllCategoria('refresh');
                  this.changeView();
                }, 2000);
                })
            }
        
            deteleteCategory(categoria : Categoria){
              if(categoria.idCategoria){
                this.categoryServices.deleteCategory(categoria.idCategoria).subscribe(response =>{
                  setTimeout(() => {
                    this.getAllCategoria('refresh');
                  }, 2000);
                })
              }
            }
}
