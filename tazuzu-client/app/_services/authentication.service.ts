import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

import {config} from './../config/environment';

@Injectable()
export class AuthenticationService {
    constructor(private http: Http,private router: Router) { }

    login(idNumber: string, password: string) {
        return this.http.post(config.API_URL + '/api/login', JSON.stringify({ idNumber: idNumber, password: password }),this.jwt())
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let user = response.json();
                if (user) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                    localStorage.setItem('Authorization',response.headers.get("Authorization"));
                }
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser'); 
        localStorage.removeItem('Authorization');
        this.router.navigate(['/login']);
    }

      private jwt() {
           let headers = new Headers({ 'Content-Type': 'application/json' });
           headers.append('Authorization',localStorage.getItem("Authorization"));
            return new RequestOptions({ headers: headers }); 
        }
}