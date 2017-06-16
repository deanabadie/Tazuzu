import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Router } from '@angular/router';
import { Teacher, Activity } from '../_models/index';
import { HttpService } from './http.service';

@Injectable()
export class TeacherService {
    constructor(private http: HttpService) { }

    getAll() {
        return this.http.get('/api/users')
            .map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/users/' + id)
            .map((response: Response) => response.json());
    }

    create(user: Teacher) {
        return this.http.post('/api/teachers', user)
            .map((response: Response) => response.json());
    }

    createActivity(activity: Activity) {
        return this.http.post('/api/activities', activity)
            .map((response: Response) => response.json());
    }

    update(user: Teacher) {
        return this.http.put('/api/users/' + user.govId, user)
            .map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/users/' + id)
            .map((response: Response) => response.json());
    }

}
