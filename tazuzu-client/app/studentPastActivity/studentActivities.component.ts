import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../_models/index';
import { AlertService, UserService, ActivityService } from '../_services/index';
import * as moment from 'moment';

@Component({
    moduleId: module.id,
    templateUrl: 'studentActivities.component.html'
})
export class StudentActivities implements OnInit {

    model: any = {};

    private currentUser: { id: number };

    private activities = {
        past: [],
        pending: [],
    };

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private studentService: UserService,
        private alertService: AlertService,
        private ActivityService: ActivityService
    ) { }

    goToActivityPage(activity) {
        this.router.navigate([`/students/activities/list/${activity.activityInstance.id}`]);
    }

    ngOnInit() {
        const activityMapper = (activity) => {
            switch (activity.activityInstance.activityType.measurementTypeId) {
                case 'TIME':
                    activity.measurement = activity.resultTimeSeconds / 60;
                    break;
                case 'QUANTITY':
                    activity.measurement = activity.resultQuantity;
                    break;
                case 'DISTANCE':
                    activity.measurement = activity.resultDistance;
                    break;
            }

            activity.activityInstance.formattedDate = moment(activity.activityInstance.activityDate).format("DD-MM-YYYY HH:mm:ss")

            return activity;
        };

        this.currentUser = this.route.snapshot.data['user'];
        this.ActivityService.getStudentActivities(this.currentUser.id)
            .subscribe(activities => {
                this.activities.past = activities.past.map(activityMapper);
                this.activities.pending = activities.pending.map(activityMapper);
            });
    }
}
