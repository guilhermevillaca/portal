import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CategoriaComponent } from './categoria/categoria.component';
import { NoticiaComponent } from './noticia/noticia.component';
import { NoticiaFormComponent } from './noticia/noticia-form/noticia-form.component';
import { CategoriaFormComponent } from './categoria/categoria-form/categoria-form.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
    {path: 'home', component: HomeComponent},
    {path: 'login', component: LoginComponent},
    {path: 'sair', component: LoginComponent},
    {path: '', component: LoginComponent},
    {path: 'categoria', component: CategoriaComponent},
    {path: 'categoria/novo', component: CategoriaFormComponent},
    {path: 'categoria/editar/:id', component: CategoriaFormComponent},
    {path: 'noticia', component: NoticiaComponent},
    {path: 'noticia/novo', component: NoticiaFormComponent},
    {path: 'noticia/editar/:id', component: NoticiaFormComponent}
];
