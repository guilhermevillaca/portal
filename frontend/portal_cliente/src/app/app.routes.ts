import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DetalhesComponent } from './detalhes/detalhes.component';


export const routes: Routes = [
    {path: "home", component: HomeComponent},    
    {path: "", component: HomeComponent},
    {path: "detalhes/:id", component: DetalhesComponent}
    
];
