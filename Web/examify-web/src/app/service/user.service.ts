import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SignupData } from '../models/signup-data.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'https://localhost:8080/users';

  constructor(private http: HttpClient) {}

  addUser(signupData: SignupData): Observable<any> {
    console.log('Sending signup data to the server:', signupData);
    return this.http.post<any>(`${this.apiUrl}`, signupData);
  }
}
