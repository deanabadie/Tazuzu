import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Teacher } from '../_models/index';
import { AlertService, TeacherService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'registerTeacher.component.html'
})

export class RegisterTeacherComponent {

    schools = ['1', '2', '3', '4', 'Amal'];

    classes = ['1', '2', '3', '4', 'k'];

    genders = ['M', 'F'];

    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private teacherService: TeacherService,
        private alertService: AlertService) { }

    register() {
        this.loading = true;
        this.teacherService.create(this.model)
            .subscribe(
            data => {
                this.alertService.success('Registration successful', true);
                this.router.navigate(['/login']);
            },
            error => {
                this.alertService.error(error);
                this.loading = false;
            });
    }
}
