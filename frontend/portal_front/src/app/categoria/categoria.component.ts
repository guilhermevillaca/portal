import { Component, OnInit } from '@angular/core';
import { CategoriaService } from '../service/categoria.service';
import { Router, RouterModule } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { CommonModule, NgFor } from '@angular/common';
import jsPDF from 'jspdf';
import { Categoria } from '../model/categoria.model';


@Component({
  selector: 'app-categoria',
  imports: [RouterModule],
  templateUrl: './categoria.component.html',
  styleUrl: './categoria.component.css',
  standalone: true
})
export class CategoriaComponent implements OnInit {

  categoria$: any;
  categoria: any;

  constructor(private categoriaService: CategoriaService, private router: Router) {

  }
  ngOnInit(): void {
    this.getCategoria();
  }

  public async getCategoria() {
    this.categoria$ = await lastValueFrom(this.categoriaService.get());

  }


  public editar(id: number) {
    //this.categoria = await lastValueFrom(this.categoriaService.getCategoriaById(id));
    this.router.navigate(['categoria/editar/', id]);
    console.log(id);
  }

  public async remover(id: number) {
    let ret = await lastValueFrom(this.categoriaService.remover(id));
    this.categoria$ = await lastValueFrom(this.categoriaService.get());
  }

  relatorio() {    

    
    const doc = new jsPDF();

    // Título
    doc.setFontSize(16);
    doc.text('Relatório de Categorias', 10, 10);

    // Cabeçalhos
    doc.setFontSize(12);
    doc.text('ID', 10, 20);
    doc.text('Nome', 30, 20);
    doc.text('Descrição', 90, 20);
    doc.text('Categoria Pai', 150, 20);

    let y = 30;

    this.categoria$.forEach((categoria: Categoria) => {
      const descricao = categoria.descricao ?? '';
      const descricaoQuebrada = doc.splitTextToSize(descricao, 55); // largura máxima: 55

      doc.text(String(categoria.id ?? ''), 10, y);
      doc.text(categoria.nome ?? '', 30, y);
      doc.text(doc.splitTextToSize(categoria.descricao ?? '', 55) ?? '', 90, y);
      doc.text(categoria.categoria?.nome ?? '', 150, y);
      y += 10;

      // Quebra de página automática se passar do limite
      if (y > 270) {
        doc.addPage();
        y = 10;
      }
    });

    doc.save('relatorio_categorias.pdf');
  

  }

}
