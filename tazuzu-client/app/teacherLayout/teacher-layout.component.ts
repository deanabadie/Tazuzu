import { Component } from '@angular/core';
import { AuthenticationService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'teacher-layout.component.html'
})
export class TeacherLayout {

    constructor(private authenticationService: AuthenticationService){}

    logout() {
        this.authenticationService.logout();
    }

}