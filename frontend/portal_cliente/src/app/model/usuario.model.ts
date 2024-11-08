import { Pessoa } from "./pessoa.model";

export class Usuario {
    id!: number|null;
    login!: string|null;
    password!: string|null;
    pessoa!: Pessoa|null;
}
