import { HttpBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Publicidade } from '../model/publicidade.model';
import { GenericService } from './generic.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PublicidadeService extends GenericService<Publicidade> {

  private baseUrl = "http://localhost:8080/publicidade";

  constructor(handler: HttpBackend) {
    super(handler, "http://localhost:8080/publicidade");
  }

  getTodas(): Observable<Publicidade[]> {
    return this.http.get<Publicidade[]>(this.baseUrl);
  }

  getPorPosicao(nome: string): Observable<Publicidade[]> {
    return this.http.get<Publicidade[]>(`${this.baseUrl}/posicao/${nome}`);
  }
}
