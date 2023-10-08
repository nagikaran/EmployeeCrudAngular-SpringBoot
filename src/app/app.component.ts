import { Component, OnInit ,ViewChild} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EmpAddEditComponent } from './emp-add-edit/emp-add-edit.component';
import { EmployeeServiceService } from './service/employee-service.service';
import { Employee } from './model/employee';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Employee-CRUD-APP';
  displayedColumns: string[] = [
  'id', 
  'firstName', 
  'lastName',
   'email',
   'gender',
   'dob',
   'education',
   'company',
   'experience',
   'annualPackage',
  'action'];
   
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private _dialog:MatDialog,private employeeService:EmployeeServiceService){
  }
  employeeList:Employee[]
  ngOnInit(): void {
    this.getAllEmployeeList();
  }
  openAddEditEmpForm(){
   const dialogRef= this._dialog.open(EmpAddEditComponent);
   dialogRef.afterClosed().subscribe({
    next:(val)=>{
      if(val){
        this.getAllEmployeeList();
      }
    }
   })
  }

  getAllEmployeeList(){
    this.employeeService.getAllEmployeeData().subscribe({
      next:(result)=>{
        console.log(result);
        this.dataSource=new MatTableDataSource(result);
        this.dataSource.sort=this.sort;
        this.dataSource.paginator=this.paginator;
      }
     // this.employeeList=result;console.log(result);
    })

  }

  deleteEmployee(id:number){
    this.employeeService.deleteEmployee(id).subscribe({
      next:(res)=>{
        alert("employee deleted succefully");
        this.getAllEmployeeList();
      },
      error:console.log,
    });
  }

  
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}


