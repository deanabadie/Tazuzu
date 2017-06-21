import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Router, NavigationStart } from '@angular/router';
import { Subject } from 'rxjs/Subject';
import { User, Activity } from '../_models/index';
import { HttpService } from './http.service';

@Injectable()
export class UserService {
    constructor(private http: HttpService) { }

    create(user: User) {
        return this.http.post('/api/students', user)
            .map((response: Response) => response.json());
    }

}