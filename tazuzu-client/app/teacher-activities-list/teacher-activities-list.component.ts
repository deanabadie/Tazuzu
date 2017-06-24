import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../_models/index';
import { TeacherService } from '../_services/index';
import * as moment from 'moment';

@Component({
    moduleId: module.id,
    templateUrl: 'teacher-activities-list.component.html'
})
export class TeacherActivitiesList implements OnInit {

    model: any = {};

    private currentUser: { id: number };

    private activities = {
        past: [],
        pending: [],
    };

    constructor(
        private router: Router,
        private route: ActivatedRoute,
        private teacherService: TeacherService,
    ) { }

    goToActivityPage(activity) {
        this.router.navigate([`/teachers/activities/list/${activity.id}`]);
    }

    setResults(e: Event, activityId: number) {
        e.stopPropagation(); 
        console.log(e, activityId);
        
        this.router.navigate([`/teachers/activities/list/${activityId}/results`])
    }

    ngOnInit() {
        const activityMapper = (activity) => ({
            ...activity,
            formattedDate: moment(activity.activityDate).format("DD-MM-YYYY HH:mm:ss")
        });

        this.currentUser = this.route.snapshot.data['user'];

        this.teacherService.getActivities(this.currentUser.id)
            .subscribe(activities => {
                this.activities.past = activities.past.map(activityMapper);
                this.activities.pending = activities.pending.map(activityMapper);
            });
    }

}
