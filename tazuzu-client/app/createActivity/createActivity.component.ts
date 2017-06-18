import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Teacher, IPayload, Activity, NewActivity } from '../_models/index';
import { AlertService, TeacherService, ActivityService } from '../_services/index';

import 'rxjs/add/operator/startWith';
import 'rxjs/add/operator/map';

@Component({
    moduleId: module.id,
    templateUrl: 'CreateActivity.component.html'
})
export class CreateActivityComponent implements OnInit {

    activity: NewActivity = new NewActivity();

    private payload: IPayload;

    currentUser: { school: { id: number; name: string; } };
    stateCtrl: FormControl;
    filteredStates: any;

    states = [
        'Alabama',
        'Alaska',
        'Arizona',
        'Arkansas',
        'California',
        'Colorado',
    ];

    constructor(private router: Router, private teacherService: TeacherService, private alertService: AlertService, private route: ActivatedRoute, private activityService: ActivityService) {
        this.stateCtrl = new FormControl();
        this.filteredStates = this.stateCtrl.valueChanges
            .startWith(null)
            .map(name => this.filterStates(name));
    }

    filterStates(val: string) {
        return val ? this.states.filter(s => new RegExp(`^${val}`, 'gi').test(s))
            : this.states;
    }

    createActivity() {
        this.activityService.create(this.activity)
            .subscribe(
            (data) => {
                this.alertService.success('New activity created successfully', true);
                this.router.navigate(['/teachers/current']);
            },
            (error) => {
                this.alertService.error(error);
            });
    }

    ngOnInit() {
        this.payload = this.route.snapshot.data['payload'];
        this.currentUser = this.route.snapshot.data['user'];
        this.payload.classes = this.payload.classes[this.currentUser.school.id];
    }

}
