import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../_models/index';
import { StudentService, AlertService } from '../_services/index';
import * as moment from 'moment';

@Component({
    moduleId: module.id,
    templateUrl: 'student-activities-list.component.html'
})
export class StudentActivitiesList implements OnInit {

    model: any = {};

    private currentUser: { id: number };

    private activities = {
        past: [],
        pending: [],
    };

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private alertService: AlertService,
        private studentService: StudentService,
    ) { }

    goToActivityPage(activity) {
        this.router.navigate([`/students/activities/list/${activity.activityInstance.id}`]);
    }

    ngOnInit() {
        const activityMapper = (activity) => {
            switch (activity.activityInstance.activityType.measurementTypeId) {
                case 'TIME':
                    //Minutes
                    activity.measurement = activity.resultTimeSeconds;
                    break;
                case 'QUANTITY':
                    //Scalar
                    activity.measurement = activity.resultQuantity;
                    break;
                case 'DISTANCE':
                    //Meter
                    activity.measurement = activity.resultDistance;
                    break;
            }

            activity.activityInstance.formattedDate = moment(activity.activityInstance.activityDate).format("DD-MM-YYYY HH:mm:ss")

            return activity;
        };

        this.currentUser = this.route.snapshot.data['user'];

        this.route.queryParams.subscribe(params => {
            if ( params.confirmation && params.confirmation === 'ok' ) {
                this.alertService.success('Participation approved, thank you');
            }
        });

        this.studentService.getActivities(this.currentUser.id)
            .subscribe(activities => {
                this.activities.past = activities.past.map(activityMapper);
                this.activities.pending = activities.pending.map(activityMapper);
            });
    }

}
