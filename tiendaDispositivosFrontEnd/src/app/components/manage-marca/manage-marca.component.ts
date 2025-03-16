import { Component } from '@angular/core';
import { MarcaService } from '../../services/marca/marca.service';
import { CategoryService } from '../../services/category/category.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Marca } from '../../interfaces/marca';

@Component({
  selector: 'app-manage-marca',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './manage-marca.component.html',
  styleUrl: './manage-marca.component.scss'
})
export class ManageMarcaComponent {

  keys: any[] = [];
  marcas: any[] = [];
  typeView: string = 'Marcas';
  categorias: any[] = [];
  formNewMarca!: FormGroup;
  formUpdateMarca!: FormGroup;
  marcasUpdate: any = {};

  constructor(private marcaService: MarcaService, private categoryServices: CategoryService) {
    this.formNewMarca = new FormGroup({
      descripcionMarca: new FormControl('', [Validators.required]),
      idCategoria: new FormControl('', [Validators.required])
    });
    this.formUpdateMarca = new FormGroup({
      idMarca: new FormControl(0, [Validators.required]),
      descripcionMarca: new FormControl('', [Validators.required]),
      idCategoria: new FormControl('', [Validators.required])
    });
  }

  ngOnInit() {
    this.getAllMarcas();
    this.getAllCategoria();
  }

  getAllMarcas(refres?: string) {
    this.marcaService.getAllMarcas().subscribe((data => {
      this.marcas = data;
      if (!refres) {
        this.keys = Object.keys(this.marcas[0]);
      }
    }))
  }

  getAllCategoria() {
    this.categoryServices.getAllCategorias().subscribe((data => {
      this.categorias = data;
    }))
  }

  changeView() {
    this.typeView = this.typeView == 'Marcas' ? 'formMarca' : 'Marcas';
  }

  validationMarca() {

    if (this.formNewMarca.valid) {

      const formValues = this.formNewMarca.value;

      const marca: Marca = {
        idMarca: null,
        descripcionMarca: formValues.descripcionMarca,
        marca: [],
        idCat: parseInt(formValues.idCategoria, 10)
      };

      this.createMarca(marca);
    }

  }

  updateMarca() {
    if (this.formUpdateMarca.valid) {

      const formValues = this.formUpdateMarca.value;

      const marca: Marca = {
        idMarca: this.marcasUpdate.idMarca,
        descripcionMarca: formValues.descripcionMarca,
        marca: [],
        idCat: parseInt(formValues.idCategoria, 10)
      };

      this.updateMarcaData(marca);
    }

  }

  createMarca(marca: any) {
    this.marcaService.createMarca(marca).subscribe((response) => {
      setTimeout(() => {
        this.getAllMarcas('refresh');
        this.changeView();
      }, 2000);
    })
  }

  updateMarcaForm(cateogry: any) {
    this.typeView = this.typeView == 'Marcas' ? 'FormsUpdate' : 'Marcas';
    this.marcasUpdate = cateogry;
  }

  updateMarcaData(marca: Marca) {
    this.marcaService.updateMarca(marca).subscribe(response => {
      setTimeout(() => {
        this.getAllMarcas('refresh');
        this.changeView();
      }, 2000);
    })
  }

  deteleteMarca(marca: Marca) {
    if (marca.idMarca) {
      this.marcaService.deleteMarca(marca.idMarca).subscribe(response => {
        setTimeout(() => {
          this.getAllMarcas('refresh');
        }, 2000);
      })
    }
  }

}
