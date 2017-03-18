import { Injectable } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

const config = require('../../config/environment');

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(userName: string, password: string) {
        return this.http.post(config.API_URL + '/api/login', JSON.stringify({ userName: userName, password: password }),this.jwt())
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let user = response.json();
                if (user && user.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
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