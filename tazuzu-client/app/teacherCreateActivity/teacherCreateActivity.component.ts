import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Teacher } from '../_models/index';
import { AlertService, TeacherService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'teacherCreateActivity.component.html'
})

export class TeacherCreateActivityComponent {

    measurements = [1,2,3];

    measAmount = [1,2,3];

    mandatory = ['true','false'];

    activitiesnames = ['running 2 km','running 100 m'];

    classes = [1];

    students =  [245,6];
    
    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private teacherService: TeacherService,
        private alertService: AlertService) { }

    createActivity() {
        this.loading = true;
        this.teacherService.createActivity(this.model)
            .subscribe(
                data => {
                    this.alertService.success('New activity created successfully', true);
                    this.router.navigate(['/teachers/current']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
