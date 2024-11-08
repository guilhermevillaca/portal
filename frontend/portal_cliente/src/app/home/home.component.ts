import { Component, OnInit } from '@angular/core';
import { NoticiaService } from '../service/noticia.service';
import { Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent  implements OnInit{

  noticia$: any;
  categoria: any;

  constructor(private noticiaService: NoticiaService, private router: Router){

  }

  ngOnInit(): void {
    this.getNoticias();
  }

  public async getNoticias(){
    this.noticia$ = await lastValueFrom(this.noticiaService.get());
  }



}
