import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Router, NavigationStart } from '@angular/router';
//import { Observable } from 'rxjs';
import { Subject } from 'rxjs/Subject';
import { User , Activity} from '../_models/index';

import {config} from './../config/environment';

@Injectable()
export class UserService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get(config.API_URL + '/api/students', this.jwt()).map((response: Response) => response.json());
    }

    getById(id: number):any {
        return this.http.get(config.API_URL + '/api/students/' + id, this.jwt()).map((response: Response) => response.json());
    }

    getStudent(id: number){
        return this.http.get(config.API_URL + '/api/students/' + id, this.jwt()).map(response => response.json());
    }

    create(user: User) {
      return this.http.post(config.API_URL + '/api/students', JSON.stringify(user),this.jwt())
         .map(this.extractData);
    }

    createActivity(activity : Activity) {
        return this.http.post(config.API_URL + '/api/activities', JSON.stringify(activity),this.jwt())
         .map(this.extractData);
    }

    update(user: User) {
        return this.http.put(config.API_URL + '/api/students/' + user.govId , user, this.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete(config.API_URL + '/api/students/' + id, this.jwt()).map((response: Response) => response.json());
    }

    // private helper methods

    private extractData (res: Response){
        let body = res.json();
        return body.data || { };
    }

    getPendingActivities(id: number){
        return this.http.get(config.API_URL + '/api/students/' + id + '/activities/pending/', this.jwt()).map((response: Response) => response.json());
    }

    private jwt() {
           let headers = new Headers({ 'Content-Type': 'application/json' });
           headers.append('Authorization',localStorage.getItem("Authorization"));
            return new RequestOptions({ headers: headers }); 
        }
    }

