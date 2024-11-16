import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SignupData } from '../../models/signup-data.interface';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [
       CommonModule,
       ReactiveFormsModule,
       MatInputModule,
       MatCardModule,
       MatButtonModule,
       MatCheckboxModule,
       FormsModule
   ],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  signupData: SignupData = {
    username: '',
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    phone: '',
    active: true,
    imageUrl: ''
  };

  onSubmit() {
      // console.log(this.signupData);
      alert(`Welcome ${this.signupData.username}!`);
  }
}
