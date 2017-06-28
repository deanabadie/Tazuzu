import { Observable } from 'rxjs';

export interface IUserService {
    getActivities: (id: number) => Observable<any>;
    create: (obj: any) =>  Observable<any>;
    getCurrent: () => Observable<any>;
}