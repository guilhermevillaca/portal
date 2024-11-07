import { HttpBackend, HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

interface Identifiable {
  id: number | null;
}

export class GenericServiceService<T extends Identifiable> {

  private http: HttpClient;

  constructor(handler: HttpBackend) { 
    this.http = new HttpClient(handler);
  }

  public getCategorias(){
    return this.http.get('http://localhost:8080/categoria/listar').pipe(map(response=>response));    
  }

  public getCategoriaById(id: number){
    return this.http.get('http://localhost:8080/categoria/listar/'+id).pipe(map(response=>response));    
  }

  public salvar(object: T): Observable<T>{
    const headers = new HttpHeaders();
    headers.set("Content-Type", "Application/json");    
    if(object.id !== null){
      return this.http.put<T>(`http://localhost:8080/categoria/atualizar/${object.id}`, object, {headers});
    }
    return this.http.post<T>('http://localhost:8080/categoria/novo', object, {headers});  
    
  }

  public remover(id:number){
    return this.http.delete<T>('http://localhost:8080/categoria/remover/'+id).pipe(map(response=>response));
  }
}
