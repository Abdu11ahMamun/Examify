import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { SignupData } from '../../models/signup-data.interface';
import { UserService } from '../../service/user.service';

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
  styleUrls: ['./signup.component.css']
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

  constructor(private userService: UserService) {}

  onSubmit(): void {
    this.userService.addUser(this.signupData).subscribe({
      next: (response) => {
        console.log('User added successfully:', response);
        alert('User registered successfully!');
      },
      error: (error) => {
        console.error('Error during user registration:', error);
        alert('An error occurred during signup. Please try again.');
      }
    });
  }
}
