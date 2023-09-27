export class Employee {
    id:number;
    firstName:String;
    lastName:String;
    email:String;
    dob:Date;
    gender:String;
    education:String;
    company:String;
    experience:number;
    packages:number;

    constructor(id: number,firstName:String,lastName:String,email:String,dob:Date,gender:String,education:String,company:String,experience:number,packages:number) {
        this.id = id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.dob=dob;
        this.gender=gender;
        this.education=education;
        this.company=company;
        this.experience=experience;
        this.packages=packages;

      }
}
