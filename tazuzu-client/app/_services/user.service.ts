﻿import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Router, NavigationStart } from '@angular/router';
//import { Observable } from 'rxjs';
import { Subject } from 'rxjs/Subject';
import { User } from '../_models/index';

const config = require('../config/environment.json');

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
        return this.http.put(config.API_URL + '/api/users/' + user.govId, user, this.jwt()).map((response: Response) => response.json());
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
        // create authorization header with jwt token
       //let currentUser = JSON.parse(localStorage.getItem('currentUser'));
       //if (currentUser && currentUser.token) {
       // let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
       // headers.append('Access-Control-Allow-Origin','*');
       // return new RequestOptions({ headers: headers });


           let headers = new Headers({ 'Content-Type': 'application/json' });
           headers.append('Access-Control-Allow-Origin','*');
           headers.append('Access-Control-Allow-Methods','*');
           headers.append('Access-Control-Allow-Headers','*');
           headers.append('Access-Control-Allow-Credentials','true');
            return new RequestOptions({ headers: headers }); 
        }
    }

