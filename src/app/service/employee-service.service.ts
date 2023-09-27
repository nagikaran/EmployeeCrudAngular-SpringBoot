import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
  
  employeeSaveUrl:string="http://localhost:8085/saveData";

  constructor(private http:HttpClient) { }
  employee:Employee={
    id: 0,
    firstName:'',
    lastName:'',
    email:'',
    dob:null,
    gender:'',
    education:'',
    company:'',
    experience:0,
    packages:0
  }
  saveEmployeeDetails(employee:Employee)
  {
    return this.http.post(this.employeeSaveUrl,employee);
  }
}
