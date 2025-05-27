import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      senha: ['', Validators.required]
    });

    // Loga os valores e status sempre que mudar algo no formulário
    /*this.loginForm.valueChanges.subscribe(value => {
      console.log('Form values:', value);
      console.log('Form valid:', this.loginForm.valid);
    });*/

  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      console.log('Login realizado com:', this.loginForm.value);
      this.router.navigate(['home']);
    } else {
      alert('Formulário inválido');

      /*const controls = this.loginForm.controls;
      for (const name in controls) {
        if (controls[name].invalid) {
          console.log(`Campo ${name} inválido. Erros:`, controls[name].errors);
        }
      }*/
    }
  }

}
