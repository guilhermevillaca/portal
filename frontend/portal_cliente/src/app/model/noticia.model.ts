import { Categoria } from "./categoria.model";

export class Noticia {
    id!: number|null;
    titulo!: string|null;
    corpo!: string|null;
    categoria!: Categoria|null;
}
