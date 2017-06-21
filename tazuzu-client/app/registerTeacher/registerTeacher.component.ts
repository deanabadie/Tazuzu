import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Teacher, IPayload } from '../_models/index';
import { AlertService, TeacherService, PayloadService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'registerTeacher.component.html'
})
export class RegisterTeacherComponent implements OnInit {

    teacher: Teacher = new Teacher();

    payload: IPayload;

    constructor(private router: Router,
        private teacherService: TeacherService,
        private alertService: AlertService, 
        private route: ActivatedRoute) {}

    register() {
        this.teacherService.create(this.teacher)
            .subscribe(
            data => {
                this.alertService.success('Registration successful', true);
                this.router.navigate(['/login']);
            },
            error => {
                this.alertService.error(error);
            });
    }

    ngOnInit() {
        this.payload = this.route.snapshot.data['payload'];
    }
}
