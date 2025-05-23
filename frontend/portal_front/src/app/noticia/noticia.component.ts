import { Component, OnInit } from '@angular/core';
import { NoticiaService } from '../service/noticia.service';
import { lastValueFrom } from 'rxjs';
import { NgFor, SlicePipe } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Router } from 'express';


@Component({
    standalone: true,
    selector: 'app-noticia',
    imports: [RouterModule, NgFor, SlicePipe],
    templateUrl: './noticia.component.html',
    styleUrl: './noticia.component.css'
})
export class NoticiaComponent implements OnInit {
  noticia$: any;
  categoria: any;

  constructor(private noticiaService: NoticiaService, private router: Router){

  }
  ngOnInit(): void {
    this.getCategoria();
  }

  public async getCategoria(){
    this.noticia$ = await lastValueFrom(this.noticiaService.get());
    
  }


  public editar(id: number){
    //this.categoria = await lastValueFrom(this.categoriaService.getCategoriaById(id));
    this.router.navigate(['noticia/editar/', id]);
    console.log(id);
  }

  public async remover(id: number){
    let ret = await lastValueFrom(this.noticiaService.remover(id));
    this.noticia$ = await lastValueFrom(this.noticiaService.get());
  }
}
