import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';

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
constructor(private _fb:FormBuilder,private _dialog:MatDialog){
  this.empForm=_fb.group({
    firstName:'',
    lastName:'',
    email:'',
    dob:'',
    gender:'',
    education:'',
    company:'',
    experience:'',
    package:'',


  })
}

onFormSubmit(){
  if(this.empForm.valid){
    console.log(this.empForm.value)
  }
}

clearTheFormAndClose(){
  alert("hello");
  this._dialog.closeAll();


}

}
