import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive, RouterModule, RouterOutlet } from '@angular/router';

@Component({
    selector: 'app-root',
    imports: [RouterOutlet, RouterModule, RouterLink, RouterLinkActive],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'portal_front';

   constructor(public router: Router) {}

  isLoginPage(): boolean {
    return this.router.url === '/login' || this.router.url === '/sair';
  }

}
