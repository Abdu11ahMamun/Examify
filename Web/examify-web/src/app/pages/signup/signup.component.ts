import { Component, ViewEncapsulation } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { SignupData } from '../../models/signup-data.interface';
import { UserService } from '../../service/user.service';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import Swal from 'sweetalert2'

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
    FormsModule,
    MatSnackBarModule
  ],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  encapsulation: ViewEncapsulation.None,
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

  constructor(private userService: UserService, private _snackBar:MatSnackBar) {}

  onSubmit(): void {
    this.userService.addUser(this.signupData).subscribe({
      next: (response) => {
        // console.log('User added successfully:', response);
        // this._snackBar.open('User added successfully:', 'Ok', {
        //   duration: 3000,
        // });
        Swal.fire({
          title: '🎉 Successfully Registered! 🎉',
          html: 'Here is your ID: ' + response.id + '<br>✅ Please login to access the system!😃',
          icon: 'success',
          confirmButtonText: 'Cool 😎'
        });              
      },
      error: (error) => {
        console.error('Error during user registration:', error);
        this._snackBar.open('An error occurred during signup. Please try again.', '', {
          duration: 3000,
          panelClass: ['error-snackbar'], 
        });
      },
    });
  }  
}
