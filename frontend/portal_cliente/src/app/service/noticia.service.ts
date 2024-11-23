import { Injectable } from '@angular/core';
import { Noticia } from '../model/noticia.model';
import { HttpBackend } from '@angular/common/http';
import { GenericService } from './generic.service';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NoticiaService extends GenericService<Noticia> {

  constructor(handler: HttpBackend) { 
    let url = "http://localhost:8080/noticia";
    super(handler, url);
  }

  public listarNoticiasPorCategoria(id_categoria: any){
    return this.http.get(this.url + '/listarNoticiasPorCategoria/' + id_categoria).pipe(map(response => response));
  }

  public findOneByUltimaNoticiaByCategoria(id_categoria: any){
    return this.http.get(this.url + '/findTopByCategoriaIdOrderByDataPublicacaoDesc/' + id_categoria).pipe(map(response => response));
  }

  public findOneByUltimaNoticiaByTodas(){
    return this.http.get(this.url + '/findTopByOrderByDataPublicacaoDesc').pipe(map(response => response));
  }
}
