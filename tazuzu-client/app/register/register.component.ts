import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService, UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'register.component.html'
})

export class RegisterComponent {
    
    schools = ['Rishon Le Zion - Mekif A', 'Rishon Le Zion - Mekif B',
            'Rishon Le Zion - Mekif C', 'Rishon Le Zion - Mekif D'];

    classes = ['A1', 'A2','A3', 'A4'];

    genders = ['Male','Female'];
     

    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }

    register() {
        this.loading = true;
        this.userService.create(this.model)
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
