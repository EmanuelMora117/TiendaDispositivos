import { Product } from "./product";


export interface Marca {
    idMarca: number | null;
    descripcionMarca: string;
    marca: Product[];
    idCat: number | null;
  }