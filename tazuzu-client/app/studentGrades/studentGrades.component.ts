import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../_models/index';
import { AlertService, UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'studentGrades.component.html'
})
export class StudentGradesComponent {

    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private studentService: UserService,
        private alertService: AlertService) { }

    getPastActivities() {
        this.loading = true;
        this.studentService.getStudentGrades(this.model)
    }
}
