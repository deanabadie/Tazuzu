import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Router } from '@angular/router';
import { Activity, NewActivity } from '../_models/index';
import { HttpService } from './http.service';

@Injectable()
export class ActivityService {
    constructor(private http: HttpService) { }

    create(activity: NewActivity) {
        return this.http.post('/api/activities', activity)
            .map((response: Response) => response.json());
    }

}
