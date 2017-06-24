import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { TeacherService } from '../_services/index';

@Injectable()
export class TeacherServiceResolve implements Resolve<{}> {

  constructor(private teacherService: TeacherService) { }

  resolve(route: ActivatedRouteSnapshot) {
    return this.teacherService;
  }
}