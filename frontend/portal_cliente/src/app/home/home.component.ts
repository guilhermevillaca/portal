import { Component, inject, OnInit } from '@angular/core';
import { NoticiaService } from '../service/noticia.service';
import { ActivatedRoute, NavigationEnd, Router, RouterModule } from '@angular/router';
import { last, lastValueFrom } from 'rxjs';
import { CategoriaService } from '../service/categoria.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgFor, RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent  implements OnInit{
  
  id:any;
  noticia$: any;
  categoria$: any;
  ultimaNoticia: any;

  constructor(private noticiaService: NoticiaService, private categoriaService: CategoriaService, private router: Router, private activatedRoute: ActivatedRoute){       
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id']; // Captura o parâmetro 'id'      
      this.getNoticias();
      this.getUltimaNoticia();
    });

  }

  public async getNoticias(){    
    if(this.id){
      this.noticia$ = await lastValueFrom(this.noticiaService.listarNoticiasPorCategoria(this.id));
    }else{
      this.noticia$ = await lastValueFrom(this.noticiaService.get());
    }
    
  }

  public async getUltimaNoticia(){
    console.log(this.id);
    if(this.id){
      this.ultimaNoticia = await lastValueFrom(this.noticiaService.findOneByUltimaNoticiaByCategoria(this.id));
    }else{
      this.ultimaNoticia = await lastValueFrom(this.noticiaService.findOneByUltimaNoticiaByTodas());
    }
  }

  public abrirDetalhes(id: any){
    this.router.navigate(['detalhes/', id]);  
  }


}
