import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { User } from '../_models/index';
import { StudentService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'home.component.html'
})
export class HomeComponent implements OnInit {
    currentUser: User;
    users: User[] = [];

    constructor(
        private userService: StudentService, 
        private route: ActivatedRoute) {}

    ngOnInit() {
        this.currentUser = this.route.snapshot.data['user'];
    }

}