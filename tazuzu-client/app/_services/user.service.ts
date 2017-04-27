import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Router, NavigationStart } from '@angular/router';
//import { Observable } from 'rxjs';
import { Subject } from 'rxjs/Subject';
import { User } from '../_models/index';

import {config} from './../config/environment';

@Injectable()
export class UserService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get(config.API_URL + '/api/users', this.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get(config.API_URL + '/api/users/' + id, this.jwt()).map((response: Response) => response.json());
    }

    create(user: User) {
      return this.http.post(config.API_URL + '/api/students', JSON.stringify(user),this.jwt())
         .map(this.extractData);
    }

    update(user: User) {
        return this.http.put(config.API_URL + '/api/users/' + user.idNumber, user, this.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete(config.API_URL + '/api/users/' + id, this.jwt()).map((response: Response) => response.json());
    }

    // private helper methods

    private extractData (res: Response){
        let body = res.json();
        return body.data || { };
    }

    private jwt() {
           let headers = new Headers({ 'Content-Type': 'application/json' });
           headers.append('Authorization',localStorage.getItem("Authorization"));
            return new RequestOptions({ headers: headers }); 
        }
    }

