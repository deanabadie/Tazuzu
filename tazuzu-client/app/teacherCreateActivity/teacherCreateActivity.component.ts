import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Teacher, IPayload, Activity } from '../_models/index';
import { AlertService, TeacherService } from '../_services/index';

import 'rxjs/add/operator/startWith';
import 'rxjs/add/operator/map';

class NewActivity {
    type: object;
    activityDate: Date;
    isMandatory: boolean;
    classId: number;
    students: string;
}

@Component({
    moduleId: module.id,
    templateUrl: 'teacherCreateActivity.component.html'
})
export class TeacherCreateActivityComponent implements OnInit {

    activity: NewActivity = new NewActivity();

    private payload: IPayload;

    stateCtrl: FormControl;
    filteredStates: any;

    states = [
        'Alabama',
        'Alaska',
        'Arizona',
        'Arkansas',
        'California',
        'Colorado',
        'Connecticut',
        'Delaware',
        'Florida',
        'Georgia',
        'Hawaii',
        'Idaho',
        'Illinois',
        'Indiana',
        'Iowa',
        'Kansas',
        'Kentucky',
        'Louisiana',
        'Maine',
        'Maryland',
        'Massachusetts',
        'Michigan',
        'Minnesota',
        'Mississippi',
        'Missouri',
        'Montana',
        'Nebraska',
        'Nevada',
        'New Hampshire',
        'New Jersey',
        'New Mexico',
        'New York',
        'North Carolina',
        'North Dakota',
        'Ohio',
        'Oklahoma',
        'Oregon',
        'Pennsylvania',
        'Rhode Island',
        'South Carolina',
        'South Dakota',
        'Tennessee',
        'Texas',
        'Utah',
        'Vermont',
        'Virginia',
        'Washington',
        'West Virginia',
        'Wisconsin',
        'Wyoming',
    ];

    constructor(private router: Router, private teacherService: TeacherService, private alertService: AlertService, private route: ActivatedRoute) {
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
        this.teacherService.createActivity(this.activity)
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
        this.payload.classes = this.payload.classes[+JSON.parse(localStorage.getItem('currentUser')).schoolId]
    }
}
