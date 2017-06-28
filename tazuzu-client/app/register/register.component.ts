import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User, IPayload, School } from '../_models/index';
import { AlertService, StudentService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'register.component.html'
})
export class RegisterComponent implements OnInit {

    private payload: IPayload;

    currentUser: { id: number; school: School; };
    student: any = {};

    classes: Array<{ id: number; name: string; }>;

    constructor(
        private router: Router,
        private studentService: StudentService,
        private alertService: AlertService,
        private route: ActivatedRoute) {
    }

    register() {
        const studentValue = { ...this.student };
        studentValue.teacherId = this.currentUser.id;

        this.studentService.create(studentValue)
            .subscribe(
            (data) => {
                this.alertService.success('Registration successful');
                this.router.navigate(['/teachers/current']);
            },
            (error) => {
                this.alertService.error(error);
            });
    }

    ngOnInit() {
        this.payload = this.route.snapshot.data['payload'];
        this.currentUser = this.route.snapshot.data['user'];
        const schoolId = this.currentUser.school.id;
        this.classes = this.payload.classes[schoolId];
    }
}
