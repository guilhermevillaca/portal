import { Categoria } from "./categoria.model";
import { Posicao } from "./posicao.model";

export class Publicidade {
    id!: number;
    titulo!: string;
    imagemUrl!: string;
    linkDestino!: string;
    dataInicio!: string;  // pode ser `Date` se você for converter no service
    dataFim!: string;     // idem
    ativo!: boolean;
    posicao?: Posicao | null;
    categoria?: Categoria | null;
}