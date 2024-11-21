import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NoticiaService } from '../service/noticia.service';
import { Router } from 'express';
import { lastValueFrom } from 'rxjs';

@Component({
  selector: 'app-detalhes',
  standalone: true,
  imports: [],
  templateUrl: './detalhes.component.html',
  styleUrl: './detalhes.component.css'
})
export class DetalhesComponent implements OnInit{

  private activateRoute = inject(ActivatedRoute);
  id:any;
  noticia:any;
  constructor(private noticiaService: NoticiaService){

  }
  ngOnInit(): void {
    this.id = this.activateRoute.snapshot.params['id'];
    this.getById();
  }

  public async getById() {
    this.noticia = await lastValueFrom(this.noticiaService.getById(this.id));
  }
  
  
 

}
