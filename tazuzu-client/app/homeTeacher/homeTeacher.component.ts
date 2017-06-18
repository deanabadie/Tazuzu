import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../_models/index';
import { UserService, TeacherService, AuthenticationService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'homeTeacher.component.html'
})
export class HomeTeacherComponent implements OnInit {
    currentUser: {school: {id: number; name: string;}};
    users: User[] = [];

    constructor(private teacherService: UserService, private authenticationService: AuthenticationService, private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.currentUser = this.route.snapshot.data['user'];
    }

    logout() {
        this.authenticationService.logout();
    }

    deleteUser(id: number) {
        this.teacherService.delete(id).subscribe(() => { this.loadAllUsers() });
    }

    private loadAllUsers() {
        this.teacherService.getAll().subscribe(users => { this.users = users; });
    }
}