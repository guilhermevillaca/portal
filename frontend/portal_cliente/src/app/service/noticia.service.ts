import { Injectable } from '@angular/core';
import { Noticia } from '../model/noticia.model';
import { HttpBackend } from '@angular/common/http';
import { GenericServiceService } from './generic-service.service';

@Injectable({
  providedIn: 'root'
})
export class NoticiaService extends GenericServiceService<Noticia> {

  constructor(handler: HttpBackend) { 
    let url = "http://localhost:8080/noticia";
    super(handler, url);
  }
}
