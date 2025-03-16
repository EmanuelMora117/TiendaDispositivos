import { Component } from '@angular/core';
import { ProductService } from '../../services/product/product.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Product } from '../../interfaces/product';
import { MarcaService } from '../../services/marca/marca.service';

@Component({
  selector: 'app-manage-products',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './manage-products.component.html',
  styleUrl: './manage-products.component.scss'
})
export class ManageProductsComponent {

  /*products: any[] = [
            {id: 1, titulo: "Iphone 13 128Gb", precio: '2.365.900', description: '', urlImage1:'images/Iphone 13.png', urlImage2:'images/Iphone 13 imagen2.png', urlImage3:'images/Iphone 13 imagen3.png'},
            {id: 2,titulo: "Iphone 11 128Gb", precio: '1.278.990', description: '', urlImage1:'images/Iphone 11.png', urlImage2:'images/Iphone 11 imagen2.png', urlImage3:'images/Iphone 11 imagen3.png'},
            {id: 3,titulo: "Iphone 14 128Gb 5G", precio: '3.175.489', description: '', urlImage1:'images/Iphone 14.png', urlImage2:'images/Iphone 14 imagen2.png', urlImage3:'images/Iphone 14 imagen3.png'},
            {id: 4,titulo: "SAMSUNG A35 256GB 5G Lila", precio: '1.599.990', description: '', urlImage1:'images/SAMSUNG A35 256GB.png', urlImage2:'images/SAMSUNG A35 256GB imagen2.png', urlImage3:'images/SAMSUNG A35 256GB imagen3.png'},
            {id: 5,titulo: "Samsung Galaxy S23 256GB 5G", precio: '4.899.990', description: '', urlImage1:'images/Samsung Galaxy S23 256GB 5G.png', urlImage2:'images/Samsung Galaxy S23 256GB 5G imagen2.png', urlImage3:'images/Samsung Galaxy S23 256GB 5G imagen3.png'},
            {id: 6,titulo: "SAMSUNG Galaxy A06 128GB", precio: '499.900', description: '', urlImage1:'images/SAMSUNG Galaxy A06 128GB.png', urlImage2:'images/SAMSUNG Galaxy A06 128GB imagen2.png', urlImage3:'images/SAMSUNG Galaxy A06 128GB imagen3.png'},
            {id: 7,titulo: "Celular Xiaomi 14T 512GB 5G", precio: '2.799.900', description: '',  urlImage1:'images/Xiaomi 14T 512GB 5G.png', urlImage2:'images/Xiaomi 14T 512GB 5G imagen2.png', urlImage3:'images/.png'},
            {id: 8,titulo: "XIAOMI Redmi A3 64GB", precio: '499.900', description: '', urlImage1:'images/XIAOMI Redmi A3 64GB.png', urlImage2:'images/XIAOMI Redmi A3 64GB imagen2.png', urlImage3:'images/XIAOMI Redmi A3 64GB imagen3.png'},
            {id: 9,titulo: "Celular REDMI Note 13 256GB", precio: '1.399.900', description: '', urlImage1:'images/REDMI Note 13 256GB.png', urlImage2:'images/REDMI Note 13 256GB imagen2.png', urlImage3:'images/REDMI Note 13 256GB imagen3.png'}
          ];*/

    keys: any[] = [];
    products: any[] = [];
    typeView: string = 'products';
    formNewProduct!:FormGroup;
    formUpdateProduct!:FormGroup;
    marcas: any[] = [];
    productUpdate: any = {};

    constructor(private productService : ProductService, private marcaService : MarcaService){
      this.formNewProduct = new FormGroup({
                titulo: new FormControl('', [Validators.required]),
                precio: new FormControl('', [Validators.required]),
                marca: new FormControl('', [Validators.required]),
                image1: new FormControl(null, [Validators.required]),
                image2: new FormControl(null, [Validators.required]),
                image3: new FormControl(null, [Validators.required]),
                idGestor: new FormControl(0, [Validators.required])
              });
              this.formUpdateProduct = new FormGroup({
                id: new FormControl(0, [Validators.required]),
                titulo: new FormControl('', [Validators.required]),
                precio: new FormControl('', [Validators.required]),
                marca: new FormControl('', [Validators.required]),
                image1: new FormControl(null, [Validators.required]),
                image2: new FormControl(null, [Validators.required]),
                image3: new FormControl(null, [Validators.required]),
                idGestor: new FormControl(0, [Validators.required])
              });
    }

    ngOnInit(){
      this.getAllProducts();
      this.getMarcas();
    }
  
    getAllProducts(refres?: string){
      this.productService.getAllProducts().subscribe((data =>{
        this.products = data;
        if(!refres){
          this.keys = Object.keys(this.products[0]);
        }
      }))
    }

    getMarcas(){
      this.marcaService.getAllMarcas().subscribe((data =>{
        this.marcas = data;
      }))
    }


    onFileChange(event: any, field: string) {
      const file = event.target.files[0];
      if (file) {
        this.formNewProduct.patchValue({
          [field]: file
        });
        console.log(`${field} - Archivo seleccionado:`, file);
      }
    }

    onFileChangeUpdate(event: any, field: string) {
      const file = event.target.files[0];
      if (file) {
        this.formUpdateProduct.patchValue({
          [field]: file
        });
        console.log(`${field} - Archivo seleccionado:`, file);
      }
    }

    validationProduct(){
            if (this.formNewProduct.valid) {
               const formData = new FormData();

               formData.append('titulo', this.formNewProduct.value.titulo);
               formData.append('precio', this.formNewProduct.value.precio);
               formData.append('marca', this.formNewProduct.value.marca);
           
               if (this.formNewProduct.value.image1) {
                 formData.append('image1', this.formNewProduct.value.image1);
               }
               if (this.formNewProduct.value.image2) {
                 formData.append('image2', this.formNewProduct.value.image2);
               }
               if (this.formNewProduct.value.image3) {
                 formData.append('image3', this.formNewProduct.value.image3);
               }
               formData.append('idGestor', '1');

               this.insertProduct(formData);
            }
        }
    
        validationUpdate(){
          if (this.formUpdateProduct.valid) {
            const formData = new FormData();

            formData.append('id', this.productUpdate.id);
            formData.append('titulo', this.formUpdateProduct.value.titulo);
            formData.append('precio', this.formUpdateProduct.value.precio);
            formData.append('marca', this.formUpdateProduct.value.marca);
        
            if (this.formUpdateProduct.value.image1) {
              formData.append('image1', this.formUpdateProduct.value.image1);
            }
            if (this.formUpdateProduct.value.image2) {
              formData.append('image2', this.formUpdateProduct.value.image2);
            }
            if (this.formUpdateProduct.value.image3) {
              formData.append('image3', this.formUpdateProduct.value.image3);
            }
            formData.append('idGestor', '1');

            this.updateProduct(formData);
         }
        }

    
    changeView(){
      this.typeView = this.typeView == 'products' ? 'formProducts' : 'products';
    }

    insertProduct(formData : FormData){
      this.productService.createProduct(formData).subscribe(response => {
        setTimeout(() => {
          this.getAllProducts('refresh');
          this.changeView();
        }, 2000);
        })
    }

    updateAdminForm(product: any){
      this.typeView = this.typeView == 'products' ? 'FormsUpdate' : 'products';
      this.productUpdate = product;
      this.formUpdateProduct.patchValue({
        titulo: this.productUpdate.titulo,
        precio: this.productUpdate.precio,
        marca: this.productUpdate.marca
      });
    }

    updateProduct(formData : FormData){
      this.productService.updateProduct(formData).subscribe(response => {
        setTimeout(() => {
          this.getAllProducts('refresh');
          this.changeView();
        }, 2000);
        })
    }

    deteleteProduct(product : Product){
      if(product.id){
        this.productService.deleteProduct(product.id).subscribe(response =>{
          setTimeout(() => {
            this.getAllProducts('refresh');
          }, 2000);
        })
      }
    }
}
