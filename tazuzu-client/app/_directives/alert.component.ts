import { Component, OnInit } from '@angular/core';

import { AlertService } from '../_services/index';

@Component({
    moduleId: module.id,
    selector: 'alert',
    templateUrl: 'alert.component.html'
})
export class AlertComponent {
    message: any;

    private timeout: NodeJS.Timer;

    constructor(private alertService: AlertService) { }

    ngOnInit() {
        this.alertService.getMessage()
            .subscribe(message => {
                if (this.timeout) {
                    clearTimeout(this.timeout);
                }

                this.message = message;

                this.timeout = setTimeout(() => {
                    this.message = null;
                }, 5000);
            });
    }
}