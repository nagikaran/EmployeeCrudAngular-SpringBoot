import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { EmployeeServiceService } from '../service/employee-service.service';


@Component({
  selector: 'app-emp-add-edit',
  templateUrl: './emp-add-edit.component.html',
  styleUrls: ['./emp-add-edit.component.scss']
})
export class EmpAddEditComponent {
  empForm:FormGroup;
education:String[]=[
  "Matric",
  "Intermadiate",
  "Diploma",
  "Engineering",
  "Master Engineering"
];
constructor(private _fb:FormBuilder,private _dialog:MatDialog,private employeeService:EmployeeServiceService,
  private dialogRef:MatDialogRef<EmpAddEditComponent>){
  this.empForm=_fb.group({
    firstName:'',
    lastName:'',
    email:'',
    dob:'',
    gender:'',
    education:'',
    company:'',
    experience:'',
    annualPackage:'',
  })
}

onFormSubmit(){
  if(this.empForm.valid){
    this.employeeService.saveEmployeeDetails(this.empForm.value).subscribe({
      next:(val:any)=>{
        alert("Emplyee added successfully");
        this.dialogRef.close(true);
      },
            error:(err:any)=>{
              alert("Somethingh went wrong while saving the data");
              console.error(err);
            },
    })
    //console.log(this.empForm.value)
  }
}

clearTheFormAndClose(){
  this._dialog.closeAll();
}

}
