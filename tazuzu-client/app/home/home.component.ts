import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { User } from '../_models/index';
import { UserService, TeacherService, AuthenticationService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'home.component.html'
})
export class HomeComponent implements OnInit {
    currentUser: User;
    users: User[] = [];

    constructor(private userService: UserService, private authenticationService: AuthenticationService, private route: ActivatedRoute) {
    }

    logout(){
        this.authenticationService.logout();
    }

    ngOnInit() {
        this.currentUser = this.route.snapshot.data['user'];
    }

}