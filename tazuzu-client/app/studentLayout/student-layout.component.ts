import { Component } from '@angular/core';
import { AuthenticationService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'student-layout.component.html'
})
export class StudentLayout {

    constructor(private authenticationService: AuthenticationService){}

    logout() {
        this.authenticationService.logout();
    }

}