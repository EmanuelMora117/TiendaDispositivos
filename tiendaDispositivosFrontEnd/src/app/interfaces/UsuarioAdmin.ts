export interface UsuarioAdmin {
    id: number | null;
    nombreUsu: string;
    email: string;
    middle: string;
    tipo: string;
    idAdm: number | null;
    idUsu: number | null;
    estado: string;
    nivelAcceso: string;
}