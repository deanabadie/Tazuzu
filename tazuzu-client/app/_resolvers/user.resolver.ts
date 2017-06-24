import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { StudentService, TeacherService } from '../_services/index';
import * as jwt from 'jwt-decode';

@Injectable()
export class UserResolve implements Resolve<{}> {
  constructor(private studentService: StudentService, private teacherService: TeacherService) { }

  resolve(route: ActivatedRouteSnapshot) {
    const decoded = jwt(localStorage.getItem('Authorization'));

    if (decoded.user.userType === 'Student') {
      return this.studentService.getCurrent()
        .map((value) => {
          return {...value, userType: 'Student'};
        });
    } else {
      return this.teacherService.getCurrent()
        .map((value) => {
          return {...value, userType: 'Teacher'};
        });
    }
  }
}