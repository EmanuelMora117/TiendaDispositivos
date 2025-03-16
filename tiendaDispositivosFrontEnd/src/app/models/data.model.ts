import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class Data {
    private idCategoria : number;
    private session :boolean = false;
    private tipo : string =  '';

    constructor(){
        this.idCategoria = 0;
    }

    getIdCategoria(): number{
        return this.idCategoria;
    }

    setIdCategoria(id : number): void {
        this.idCategoria = id;
    }

    getSession(): boolean{
        return this.session;
    }

    setSession(session : boolean): void {
        this.session = session;
    }
    getTipo(): string{
        return this.tipo;
    }

    setTipo(tipo : string): void {
        this.tipo = tipo;
    }
}
