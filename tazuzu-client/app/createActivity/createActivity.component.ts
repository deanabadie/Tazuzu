import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Teacher, IPayload, SchoolClass, School, Activity, NewActivity } from '../_models/index';
import { AlertService, StudentService, ActivityService } from '../_services/index';
import { Observable } from 'rxjs';
import 'rxjs/Rx';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import * as moment from 'moment';

@Component({
    moduleId: module.id,
    templateUrl: 'CreateActivity.component.html'
})
export class CreateActivityComponent implements OnInit {

    activity = new NewActivity();

    private payload: IPayload;

    currentUser: { school: School };

    studentsSuggestionCtrl: FormControl;

    suggestedStudents = [];

    schoolClasses: Array<SchoolClass>;

    studentsList = [];

    validations = {
        time: false
    };

    private minDateTime: string;

    constructor(private router: Router, private studentService: StudentService, private alertService: AlertService, private route: ActivatedRoute, private activityService: ActivityService) {
        this.studentsSuggestionCtrl = new FormControl();

        this.minDateTime = moment().add(1, 'day').format("YYYY-MM-DD");

        this.studentsSuggestionCtrl.valueChanges
            .startWith(null)
            .filter((v) => {
                this.suggestedStudents = [];
                return v != null && v.length > 1;
            })
            .debounceTime(250)
            .flatMap(name => this.getSuggestions(name))
            .map(suggestions => {
                return suggestions.filter(suggestion => {
                    return !this.studentsList.some(student => student.id === suggestion.id);
                });
            })
            .subscribe(suggestions => {
                this.suggestedStudents = suggestions;
            });

    }

    getSuggestions(val: string = "") {
        return this.studentService.suggest(val);
    }

    removeStudent(student) {
        this.studentsList = this.studentsList.filter(s => {
            return s.id !== student.id;
        });
    }

    selection(e) {
        this.studentsList.push(e.source.value);
        this.studentsSuggestionCtrl.setValue(null);
    }

    createActivity() {
        const activity: any = {
            activityTypeId: this.activity.type.id,
            time: moment(this.activity.time),
            isMandatory: +this.activity.isMandatory
        };

        if ( this.activity.target === 0 ) {
            activity.classId = +this.activity.classId;
        } else {
            activity.studentIds = this.studentsList.map(s => s.id);
        }

        this.activityService.create(activity)
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
        this.schoolClasses = this.payload.classes[this.currentUser.school.id];
    }

    studentSuggestionDisplayFunction(student: any): string {
        return student ? `${student.firstName} ${student.lastName}` : student;
    }

}
