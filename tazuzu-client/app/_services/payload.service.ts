import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { HttpService } from './http.service';

@Injectable()
export class PayloadService {
    constructor(private http: HttpService) { }

    get() {
        return this.http.get('/api/payload')
            .map((response: Response) => response.json());
    }

}
