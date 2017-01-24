import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';
import { Router, NavigationStart } from '@angular/router';
//import { Observable } from 'rxjs';
import { Subject } from 'rxjs/Subject';
import { User } from '../_models/index';

@Injectable()
export class UserService {
    constructor(private http: Http) { }

    getAll() {
        return this.http.get('/api/users', this.jwt()).map((response: Response) => response.json());
    }

    getById(id: number) {
        return this.http.get('/api/users/' + id, this.jwt()).map((response: Response) => response.json());
    }

    create(user: User) {
      return this.http.post('http://nofar-pc:8080/api/students', JSON.stringify(user),this.jwt())
          .map(this.extractData);//.catch(this.handleError);
           
       // return this.http.post('/api/users/', user, this.jwt()).map((response: Response) => response.json());
    }

    update(user: User) {
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

  //  private handleError (error: Response | any){
        // In a real world app, we might use a remote logging infrastructure
   //let errMsg: string;
   // if (error instanceof Response) {
//const body = error.json() || '';
//const err = body.error || JSON.stringify(body);
   //   errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
 //   } else {
    //  errMsg = error.message ? error.message : error.toString();
 //   }
  //  console.error(errMsg);
  //  return Observable.throw(errMsg);
  //  }

    private jwt() {
        // create authorization header with jwt token
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (currentUser && currentUser.token) {
            let headers = new Headers({ 'Authorization': 'Bearer ' + currentUser.token });
            return new RequestOptions({ headers: headers });
        }
    }
}