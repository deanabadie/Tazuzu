import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { StudentService } from '../_services/index';

@Injectable()
export class StudentServiceResolve implements Resolve<{}> {

  constructor(private studentService: StudentService) { }

  resolve(route: ActivatedRouteSnapshot) {
    return this.studentService;
  }
}