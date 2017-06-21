import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AlertService, AuthenticationService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {

    model: any = {};
    loading = false;
    returnUrl: string;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) { }

    ngOnInit() {
        this.checkIfConnectedAndRedirect();

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    private checkIfConnectedAndRedirect() {
        const currentUser = localStorage.getItem("currentUser");
        if (currentUser) {
            const parsedUser: {userType: string;} = JSON.parse(currentUser);
            this.redirect(parsedUser.userType)
        }
    }

    private redirect(userType: string) {
        if (userType == "Teacher") {
            this.router.navigate(['/teachers/current']);
        } else if (userType == "Student") {
            this.router.navigate(['/students/current']);
        }
    }

    login() {
        this.loading = true;
        this.authenticationService.login(this.model.idNumber, this.model.password)
            .subscribe(
            (user) => {
                this.redirect(user.userType);
            },
            (error) => {
                this.alertService.error(error);
                this.loading = false;
            });
    }
}
