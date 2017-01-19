export class Teacher {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    gender: Gender;
    dateOfBirth: Date;
    email: string;
    school: string;
}

 enum Gender{
       male,
       female,
   };