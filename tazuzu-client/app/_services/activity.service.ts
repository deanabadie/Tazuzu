import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Activity, NewActivity } from '../_models/index';
import { HttpService } from './http.service';

@Injectable()
export class ActivityService {
    constructor(private http: HttpService) { }

    get(id: number) {
        return this.http.get(`/api/activities/${id}`)
            .map( response => response.json());
    }

    getStatistics(id: number) {
        return this.http.get(`/api/activities/${id}/statistics`)
            .map( response => response.json());
    }

    create(activity: NewActivity) {
        return this.http.post('/api/activities', activity)
            .map( response => response.json());
    }

    getStudentActivities(studentId: number) {
        return this.http.get(`/api/activities/students/${studentId}`)
            .map(response => response.json());
    }

    getMeasurementsByActivityInstanceId(instanceId: number) {
        return this.http.get(`/api/activities/instances/${instanceId}/measurements`)
            .map(response => response.json());
    }

}
