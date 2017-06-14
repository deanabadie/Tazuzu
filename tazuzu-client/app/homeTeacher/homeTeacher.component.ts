import { Component, OnInit } from '@angular/core';

import { User } from '../_models/index';
import { UserService, TeacherService, AuthenticationService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'homeTeacher.component.html'
})

export class HomeTeacherComponent implements OnInit {
    currentUser: User;
    users: User[] = [];

    constructor(private teacherService: UserService,  private authenticationService: AuthenticationService) {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }
    
    ngOnInit() {
        this.loadAllUsers();
    }

    logout(){
        this.authenticationService.logout();
    }

    deleteUser(id: number) {
        this.teacherService.delete(id).subscribe(() => { this.loadAllUsers() });
    }

    private loadAllUsers() {
        this.teacherService.getAll().subscribe(users => { this.users = users; });
    }
}