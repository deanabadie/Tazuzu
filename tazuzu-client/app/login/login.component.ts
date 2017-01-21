﻿import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { AlertService, AuthenticationService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    
    languages = ['English', 'Hebrew','Arabic'];  
    userTypes = ['Student','Teacher'];  

    model: any = {};
    loading = false;
    returnUrl: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    login() {
        this.loading = true;
        this.authenticationService.login(this.model.username, this.model.password)
            .subscribe(
                data => {
                    console.log(this.model.userType);
                    if (this.model.userType == "Teacher"){
                        this.router.navigate(['/homeTeacher']);
                    }else{
                        this.router.navigate(['/home']);
                    }
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}