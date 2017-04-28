import { Component, OnInit } from '@angular/core';

import { User } from '../_models/index';
import { UserService, TeacherService, AuthenticationService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
    currentUser: User;
    users: User[] = [];

    constructor(private userService: UserService, private authenticationService: AuthenticationService) {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        //this.currentUser.pendingActivities = userService.getPendingActivities(this.currentRawUser.id);
        //var currentUser = userService.getStudent(currentRawUser.id);
        //userServiceObj.subscribe(data => this.currentUser = JSON.parse(data));
    }

    logout(){
        this.authenticationService.logout();
    }

    ngOnInit() {
        this.loadAllUsers();

    }

    deleteUser(id: number) {
        this.userService.delete(id).subscribe(() => { this.loadAllUsers() });
    }

    private loadAllUsers() {
        this.userService.getAll().subscribe(users => { this.users = users; });
    }
}