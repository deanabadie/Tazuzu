import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Router } from '@angular/router';
import { Student, Activity } from '../_models/index';
import { HttpService } from './http.service';

@Injectable()
export class StudentService {
    constructor(private http: HttpService) { }

    getCurrent() {
        return this.http.get('/api/students/current')
            .map((response: Response) => response.json());
    }

    create(student: Student) {
        return this.http.post('/api/students', student)
            .map((response: Response) => response.json());
    }

    suggest(value: string) {
        return this.http.get(`/api/students/suggestions?search=${value}`)
            .map((response: Response) => response.json());
    }

}
