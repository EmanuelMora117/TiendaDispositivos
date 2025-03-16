import { Component } from '@angular/core';
import { UsuarioAdmin } from '../../interfaces/UsuarioAdmin';
import { UserAdminService } from '../../services/userAdmin/user-admin.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';


@Component({
  selector: 'app-manage-admins',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './manage-admins.component.html',
  styleUrl: './manage-admins.component.scss'
})
export class ManageAdminsComponent {

  usersAdmin: any[] = [];
  keys: string[] = [];
  typeView : string = 'Admins';
  formNewUser!:FormGroup;
  formUpdateUser!:FormGroup;
  errorMiddle: string = '';
  userAdminUpdate!: UsuarioAdmin;

  constructor(private userAdminService : UserAdminService){
     this.formNewUser = new FormGroup({
          correo: new FormControl('', [Validators.required, Validators.email]),
          usuario: new FormControl('', [Validators.required]),
          middle: new FormControl('', [Validators.required, Validators.minLength(8)]),
          confirmarMiddle: new FormControl('', [Validators.required]),
          estado: new FormControl('', [Validators.required]),
          nivelAcceso: new FormControl('', [Validators.required])
        });
        this.formUpdateUser = new FormGroup({
          correo: new FormControl('', [Validators.required, Validators.email]),
          usuario: new FormControl('', [Validators.required]),
          middle: new FormControl('', [Validators.required, Validators.minLength(8)]),
          confirmarMiddle: new FormControl('', [Validators.required]),
          estado: new FormControl('', [Validators.required]),
          nivelAcceso: new FormControl('', [Validators.required])
        });
  }

  ngOnInit(){
    this.getAllAdmins();
  }

  getAllAdmins(refres?: string){
    this.userAdminService.getAllAdmin().subscribe((data =>{
      this.usersAdmin = data;
      console.log("Holaa")
      if(!refres){
        this.keys = Object.keys(this.usersAdmin[0]);
      }
    }))
  }

  changeView(){
    this.typeView = this.typeView == 'Admins' ? 'FormAdmins' : 'Admins';
  }

  middleMatchValidator(group: FormGroup){
    const middle = group.get('middle');
    const confirmarMiddle = group.get('confirmarMiddle');
    if (middle?.value !== confirmarMiddle?.value) {
      return 'Las contraseñas deben coincidir';
    } 
    return '';
  }


  validationUserAdmin(){
  
      this.errorMiddle = this.middleMatchValidator(this.formNewUser);
  
      if(this.errorMiddle == ''){
        this.errorMiddle = '';
        if(this.formNewUser.valid){
  
          const formValues = this.formNewUser.value;
    
          const userAdmin : UsuarioAdmin ={
            id: null,
            nombreUsu: formValues.usuario,
            email: formValues.correo,
            middle: formValues.middle,
            tipo: 'ADM',
            idAdm: null,
            idUsu: null,
            estado: formValues.estado,
            nivelAcceso: formValues.nivelAcceso
          };
            this.createUserAdmin(userAdmin);

        }
      }
    }

    validationUpdate(){

      this.errorMiddle = this.middleMatchValidator(this.formUpdateUser);

      if(this.errorMiddle == ''){
        this.errorMiddle = '';
        if(this.formUpdateUser.valid){
          const formValues = this.formUpdateUser.value;
    
          const userAdmin : UsuarioAdmin ={
          id: this.userAdminUpdate.id,
          nombreUsu: formValues.usuario,
          email: formValues.correo,
          middle: formValues.middle,
          tipo: 'ADM',
          idAdm: this.userAdminUpdate.idAdm,
          idUsu: this.userAdminUpdate.idUsu,
          estado: formValues.estado,
          nivelAcceso: formValues.nivelAcceso
        };

          this.updateUserAdmin(userAdmin);
        }
      }
    }

    createUserAdmin(createUserAdm : any){
      this.userAdminService.createUserAdmin(createUserAdm).subscribe((response) => {
        setTimeout(() => {
          this.getAllAdmins('refresh');
          this.changeView();
        }, 2000);
      })
    }

    updateUserAdmin(updateUserAdm : any){
      this.userAdminService.updateAdmin(updateUserAdm).subscribe((response) => {
        setTimeout(() => {
          this.getAllAdmins('refresh');
          this.changeView();
        }, 2000);
      })
    }



    deteleteAdmin(admin: any){
      this.userAdminService.deleteAdmin(admin.id).subscribe((response) => {
        setTimeout(() => {
          this.getAllAdmins('refresh');
        }, 3000);
      })
    }

    updateAdminForm(admin: any){
      this.typeView = this.typeView == 'Admins' ? 'FormsUpdate' : 'Admins';
      this.userAdminUpdate = admin;
      console.log(admin)
    }

}
