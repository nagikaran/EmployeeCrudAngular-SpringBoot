import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {
  
  employeeSaveUrl:string="http://localhost:9999/api/v1/employee/saveEmployeeDetails";
  employeeGetListOfData:string="http://localhost:9999/api/v1/employee/getEmployeeData";
  deleteEmployeeAsPerId:string="http://localhost:9999/api/v1/employee/delete/";
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
    annualPackage:0
  }
  saveEmployeeDetails(employee:Employee)
  {
    return this.http.post(this.employeeSaveUrl,employee);
  }

  getAllEmployeeData(){
    return this.http.get<Employee[]>(this.employeeGetListOfData)
    
  }

  deleteEmployee(id:number){
    return this.http.delete(this.deleteEmployeeAsPerId+id)

  }
  
}
