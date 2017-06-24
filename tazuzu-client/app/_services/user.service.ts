import { Observable } from 'rxjs/RX';

export interface IUserService {
    getActivities: (id: number) => Observable<any>;
    create: (obj: any) =>  Observable<any>;
    getCurrent: () => Observable<any>;
}