import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../_models/index';
import { TeacherService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'homeTeacher.component.html'
})
export class HomeTeacherComponent implements OnInit {
    currentUser: { school: { id: number; name: string; } };

    constructor(
        private teacherService: TeacherService,
        private route: ActivatedRoute) { }

    ngOnInit() {
        this.currentUser = this.route.snapshot.data['user'];
    }
}