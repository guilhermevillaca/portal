import { Component, OnInit } from '@angular/core';
import { NoticiaService } from '../service/noticia.service';
import { Router, RouterModule } from '@angular/router';
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

  noticia$: any;
  categoria$: any;

  constructor(private noticiaService: NoticiaService, private categoriaService: CategoriaService, private router: Router){

  }

  ngOnInit(): void {
    console.log("teste");
    this.getNoticias();
  }

  public async getNoticias(){
    console.log('teste');
    this.noticia$ = await lastValueFrom(this.noticiaService.get());
  }



  public abrirDetalhes(id: any){
    this.router.navigate(['detalhes/', id]);  
  }


}
