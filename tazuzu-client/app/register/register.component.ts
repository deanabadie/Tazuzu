import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../_models/index';
import { AlertService, UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'register.component.html'
})

export class RegisterComponent {

    schools = ['1', '2', '3', '4', 'Amal'];

    classes = ['1', '2', '3', '4', 'k'];

    genders = ['M', 'F'];

    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }

    register() {
        this.loading = true;

        const modelValue = { ...this.model };
        modelValue.teacherId = JSON.parse(localStorage.getItem('currentUser')).id;

        this.userService.create(modelValue)
            .subscribe(
            (data) => {
                this.alertService.success('Registration successful', true);
                this.router.navigate(['/teachers/current']);
            },
            (error) => {
                this.alertService.error(error);
                this.loading = false;
            });
    }
}
