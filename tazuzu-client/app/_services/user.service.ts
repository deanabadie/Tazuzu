import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Router, NavigationStart } from '@angular/router';
import { Subject } from 'rxjs/Subject';
import { User, Activity } from '../_models/index';
import { HttpService } from './http.service';

@Injectable()
export class UserService {
    constructor(private http: HttpService) { }

    getAll() {
        return this.http.get('/api/students')
            .map((response: Response) => response.json());
    }

    getById(id: number): any {
        return this.http.get('/api/students/' + id)
            .map((response: Response) => response.json());
    }

    getPastActivities(id: number): any {
        return this.http.get('/api/activities/' + id)
            .map((response: Response) => response.json());
    }

    getStudentGrades(id: number): any {
        return this.http.get('/api/students/' + id)
            .map((response: Response) => response.json());
    }

    getStudent(id: number) {
        return this.http.get('/api/students/' + id)
            .map(response => response.json());
    }

    create(user: User) {
        return this.http.post('/api/students', user)
            .map((response: Response) => response.json());
    }

    createActivity(activity: Activity) {
        return this.http.post('/api/activities', activity)
            .map((response: Response) => response.json());
    }

    update(user: User) {
        return this.http.put('/api/students/' + user.govId, user)
            .map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/students/' + id)
            .map((response: Response) => response.json());
    }

    getPendingActivities(id: number) {
        return this.http.get('/api/students/' + id + '/activities/pending/')
            .map((response: Response) => response.json());
    }

}