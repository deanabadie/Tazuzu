import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Router, NavigationStart } from '@angular/router';
//import { Observable } from 'rxjs';
import { Subject } from 'rxjs/Subject';
import { Teacher } from '../_models/index';

@Injectable()
export class TeacherService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get('/api/users', this.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/users/' + id, this.jwt()).map((response: Response) => response.json());
    }

    create(user: Teacher) {
       return this.http.post('http://localhost:8080/api/teachers', JSON.stringify(user),this.jwt())
         .map(this.extractData);//.catch(this.handleError);
    }

    update(user: Teacher) {
        return this.http.put('/api/users/' + user.id, user, this.jwt()).map((response: Response) => response.json());
    }

    delete(id: number) {
        return this.http.delete('/api/users/' + id, this.jwt()).map((response: Response) => response.json());
    }

    // private helper methods

        private extractData (res: Response){
        let body = res.json();
        return body.data || { };
    }

    private jwt() {
           let headers = new Headers({ 'Content-Type': 'application/json' });
           headers.append('Access-Control-Allow-Origin','*');
           headers.append('Access-Control-Allow-Methods','*');
           headers.append('Access-Control-Allow-Headers','*');
           headers.append('Access-Control-Allow-Credentials','true');
            return new RequestOptions({ headers: headers }); 
    }
    
    }
