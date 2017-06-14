import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../_models/index';
import { AlertService, UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'studentCreateActivity.component.html'
})
export class StudentCreateActivityComponent {

    measurements = [1, 2, 3];

    measAmount = [1, 2, 3];

    mandatory = ['true', 'false'];

    activitiesnames = ['running 2 km', 'running 100 m'];

    classes = [1];

    students = [245, 6];

    model: any = {};

    loading = false;

    constructor(
        private router: Router,
        private studentService: UserService,
        private alertService: AlertService) { }

    createActivity() {
        this.loading = true;
        this.studentService.createActivity(this.model)
            .subscribe(
            (data) => {
                this.alertService.success('New activity created successfully', true);
                this.router.navigate(['/students/current']);
            },
            (error) => {
                this.alertService.error(error);
                this.loading = false;
            });
    }
}
