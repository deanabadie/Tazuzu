import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import * as moment from 'moment';
import { User } from '../_models/index';
import { UserService, ActivityService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: 'activity.component.html'
})
export class ActivityComponent implements OnInit {
    currentUser: User;

    activity: any;

    constructor(private userService: UserService, private route: ActivatedRoute, private activityService: ActivityService) {
    }

    ngOnInit() {
        this.currentUser = this.route.snapshot.data['user'];

        this.route.params.subscribe(params => {
            this.activityService.get(+params.id)
                .subscribe(activity => {
                    activity.formattedDate = moment(activity.activityDate).format('YYYY-MM-DD HH:MM:SS');
                    this.activity = activity;
                });
        });
    }

}