export class Employee {
  id: number = 0;
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  dob: Date | null = null;
  gender: string = '';
  education: string = '';
  company: string = '';
  experience: number = 0;
  annualPackage: number = 0;

  constructor(
      id: number = 0,
      firstName: string = '',
      lastName: string = '',
      email: string = '',
      dob: Date | null = null,
      gender: string = '',
      education: string = '',
      company: string = '',
      experience: number = 0,
      annualPackage: number = 0
  ) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.dob = dob;
      this.gender = gender;
      this.education = education;
      this.company = company;
      this.experience = experience;
      this.annualPackage = annualPackage;
  }
}
