import { Component, inject, OnInit } from '@angular/core';
import { NoticiaService } from '../service/noticia.service';
import { ActivatedRoute, NavigationEnd, Router, RouterModule } from '@angular/router';
import { last, lastValueFrom } from 'rxjs';
import { CategoriaService } from '../service/categoria.service';
import { NgFor, NgIf, SlicePipe } from '@angular/common';
import { Noticia } from '../model/noticia.model';
import { PublicidadeService } from '../service/publicidade.service';
import { Publicidade } from '../model/publicidade.model';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgFor, RouterModule, NgIf, SlicePipe],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  id: any;
  noticia$: any;
  categoria$: any;
  ultimaNoticia: any;

  noticias: any;           // todas as notícias
  noticiasPaginadas: Noticia[] = [];  // notícias visíveis na página atual
  paginaAtual: number = 1;
  itensPorPagina: number = 5;
  totalPaginas: number = 0;

  publicidadeTopo?: Publicidade;


  constructor(private noticiaService: NoticiaService, private categoriaService: CategoriaService,
    private publicidadeService: PublicidadeService,
    private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params['id']; // Captura o parâmetro 'id'      
      this.getNoticias();
      this.getUltimaNoticia();
    });

    this.publicidadeService.getPorPosicao('topo').subscribe(data => {
      this.publicidadeTopo = data[0];
    });

  }

  public async getNoticias() {
    /*if (this.id) {
      this.noticia$ = await lastValueFrom(this.noticiaService.listarNoticiasPorCategoria(this.id));
    } else {
      this.noticia$ = await lastValueFrom(this.noticiaService.get());
    }*/

    if (this.id) {
      this.noticias = await lastValueFrom(this.noticiaService.listarNoticiasPorCategoria(this.id));
    } else {
      this.noticias = await lastValueFrom(this.noticiaService.get());
    }

    this.totalPaginas = Math.ceil(this.noticias.length / this.itensPorPagina);
    this.atualizarPagina();

  }

  public async getUltimaNoticia() {
    console.log(this.id);
    if (this.id) {
      this.ultimaNoticia = await lastValueFrom(this.noticiaService.findOneByUltimaNoticiaByCategoria(this.id));
    } else {
      this.ultimaNoticia = await lastValueFrom(this.noticiaService.findOneByUltimaNoticiaByTodas());
    }
  }

  public abrirDetalhes(id: any) {
    this.router.navigate(['detalhes/', id]);
  }


  //cg

  carregarNoticias(): void {
    this.noticiaService.get().subscribe((data: any) => {
      this.noticias = data;
      this.totalPaginas = Math.ceil(this.noticias.length / this.itensPorPagina);
      this.atualizarPagina();
    });
  }

  atualizarPagina(): void {
    const inicio = (this.paginaAtual - 1) * this.itensPorPagina;
    const fim = inicio + this.itensPorPagina;
    this.noticiasPaginadas = this.noticias.slice(inicio, fim);
  }

  paginaAnterior(): void {
    if (this.paginaAtual > 1) {
      this.paginaAtual--;
      this.atualizarPagina();
    }
  }

  proximaPagina(): void {
    if (this.paginaAtual < this.totalPaginas) {
      this.paginaAtual++;
      this.atualizarPagina();
    }
  }

}
