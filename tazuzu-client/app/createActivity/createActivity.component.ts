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
    templateUrl: 'createActivity.component.html'
})
export class CreateActivityComponent implements OnInit {

    //Activity object, holds all the data the user enters to the form (using binding)
    activity = new NewActivity();

    //Payload used to populate some of the fields on the client side
    private payload: IPayload;

    //Object that holds the current logged in user
    currentUser: { school: School };

    //Angular form control used to interact with the auto complete component API
    studentsSuggestionCtrl: FormControl;

    //Autocomplete suggestions list, populated with values from the server side
    suggestedStudents = [];

    //Only classes relevant for the current user school
    //In order to avoid mutating the payload object
    schoolClasses: Array<SchoolClass>;

    //Chosen students
    studentsList = [];

    //Helper object
    validations = {
        time: false
    };

    //The minimum date for the activity
    private minDateTime: string;

    constructor(
        private router: Router,
        private studentService: StudentService,
        private alertService: AlertService,
        private route: ActivatedRoute,
        private activityService: ActivityService) {
            
        this.studentsSuggestionCtrl = new FormControl();

        this.minDateTime = moment().add(0, 'day').format("YYYY-MM-DD");

        //studentsSuggestionCtrl emits all input changes on the observable stream
        this.studentsSuggestionCtrl.valueChanges
            .startWith(null)
            .filter(v => {
                this.suggestedStudents = [];
                return v != null && v.length > 1;
            })
            //Debounce prevents calling the server multiple times
            .debounceTime(250)
            //getSuggestions returns observable (async http call)
            .flatMap(v => this.getSuggestions(v))
            //
            .map(suggestions => {
                return suggestions.filter(suggestion => {
                    //`some` stops on the first time it finds the condition to be true
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

        if (this.activity.target === 0) {
            //Class
            activity.classId = +this.activity.classId;
        } else {
            //Individuals
            activity.studentIds = this.studentsList.map(s => s.id);
        }

        this.activityService.create(activity)
            .subscribe(
            (data) => {
                this.alertService.success('New activity created successfully');
                this.router.navigate(['/login']);
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
