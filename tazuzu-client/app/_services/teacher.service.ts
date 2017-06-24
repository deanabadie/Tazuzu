import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Router } from '@angular/router';
import { Teacher, Activity } from '../_models/index';
import { HttpService } from './http.service';
import { IUserService } from './index';

@Injectable()
export class TeacherService implements IUserService {
    constructor(private http: HttpService) {}

    getCurrent() {
        return this.http.get('/api/teachers/current')
            .map((response: Response) => response.json());
    }

    getActivities(id: number) {
        return this.http.get(`/api/activities/teachers/${id}`)
            .map(response => response.json());
    }

    create(user: Teacher) {
        return this.http.post('/api/teachers', user)
            .map((response: Response) => response.json());
    }

}
