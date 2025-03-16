import { Component, EventEmitter, Output } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { UsuarioCliente } from '../../interfaces/UsuarioCliente';
import { LoginValidateService } from '../../services/loginValidate/login-validate.service';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  showFormLogin : boolean = true;
  formNewUser!:FormGroup;
  isSaveInProgress: boolean = false;
  errorMiddle: string = '';
  userCreated: string = '';
  username: string = '';
  middle: string = '';
  messageError: string = '';
  closeModal: string = '';

  
  constructor(private user : UserService, private loginValidateService : LoginValidateService){
    this.formNewUser = new FormGroup({
      correo: new FormControl('', [Validators.required, Validators.email]),
      usuario: new FormControl('', [Validators.required]),
      middle: new FormControl('', [Validators.required, Validators.minLength(8)]),
      confirmarMiddle: new FormControl('', [Validators.required]),
      cedula: new FormControl('', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      celular: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(){

  }

  middleMatchValidator(group: FormGroup){
    const middle = group.get('middle');
    const confirmarMiddle = group.get('confirmarMiddle');
    console.log(middle?.value)
    console.log(confirmarMiddle?.value)
    if (middle?.value !== confirmarMiddle?.value) {
      return 'Las contraseñas deben coincidir';
    } 
    return '';
  }

  validationUserClient(){

    this.errorMiddle = this.middleMatchValidator(this.formNewUser);

    if(this.errorMiddle == ''){
      this.errorMiddle = '';
      if(this.formNewUser.valid){

        const formValues = this.formNewUser.value;
  
        const createUserCli : UsuarioCliente ={
          id: null,
          nombreUsu: formValues.usuario,
          email: formValues.correo,
          middle: formValues.middle,
          tipo: 'CLI',
          idCli: null,
          idUsu: null,
          cedula: formValues.cedula,
          direccion: formValues.direccion,
          celular: formValues.celular,
          telefono: formValues.telefono
        };
        this.createUserClient(createUserCli);
      }
    }
  }

  ValidateCredentials(){
    if(this.username!= '' && this.middle != ''){
      this.loginValidateService.validationLogin(this.username, this.middle).subscribe((response)=>{
        const answer : string = response.answer;
        console.log(answer)
        if(answer == 'Usuario no existente.'){
          this.messageError = 'Usuario no existente.';
        }else if(answer == 'Datos incorrectos.'){
          this.messageError = 'Datos incorrectos.';
        }else if (answer == 'Inicio de sesion Completado'){
          this.messageError = '';
          this.closeModal = 'modal';
          localStorage.setItem("Usuario", this.username);
          localStorage.setItem("Tipo", response.tipo);
          window.location.reload();
        }
      })
    }else{
      this.messageError = 'Debe llenar todos los campos';
    }
  }

  changeView(){
    this.showFormLogin = this.showFormLogin ? false : true;
    console.log(this.userCreated)

    if(this.userCreated !== ''){
      /*setTimeout(() => {
        this.userCreated = '';
      }, 7000);*/
    }
  }

  createUserClient(createUserCli : any){
    this.user.createUserCliente(createUserCli).subscribe((response) => {
      const answer : string = response.answer;
      if(answer == "Datos insertados correctamente."){
        this.userCreated = 'Usuario Creado correctamente, por favor inicie sesion.';
        this.changeView();
      }
    })
  }
}
