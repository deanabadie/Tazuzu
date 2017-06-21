import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Activity, NewActivity } from '../_models/index';
import { HttpService } from './http.service';

@Injectable()
export class ActivityService {
    constructor(private http: HttpService) { }

    create(activity: NewActivity) {
        return this.http.post('/api/activities', activity)
            .map( response => response.json());
    }

    getStudentActivities(studentId: number) {
        return this.http.get(`/api/activities/students/${studentId}`)
            .map(response => response.json());
    }

}
