import { Http, XHRBackend, RequestOptions, Request, RequestOptionsArgs, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { config } from './../config/environment';

export class HttpService extends Http {
    constructor(backend: XHRBackend, options: RequestOptions) {
        super(backend, options);
    }

    request(url: string | Request, options?: RequestOptionsArgs): Observable<Response> {
        let token = localStorage.getItem('Authorization');
        if (typeof url === 'string') { // meaning we have to add the token to the options, not in url
            if (!options) {
                // let's make option object
                options = { headers: new Headers() };
            }
            options.headers.set('Authorization', `${token}`);
            return super.request(config.API_URL + url, options);
        } 

        // we have to add the token to the url object
        url.headers.set('Authorization', `${token}`);
        url.url = config.API_URL + url.url;
        return super.request(url, options);
    }


} 