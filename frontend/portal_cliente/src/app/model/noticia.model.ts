import { Categoria } from "./categoria.model";

export class Noticia {
    id!: number|null;
    titulo!: string|null;
    corpo!: string|null;
    imagem_url!: string|null;
    categoria!: Categoria|null;
}
