export class Student {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    gender: Gender;
    dateOfBirth: Date;
    email: string;
    school: string;
    class: string;
    height: number;
    weight: number;
    
}

 enum Gender{
       male,
       female,
   };