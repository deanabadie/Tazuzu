import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { PayloadService } from '../_services/payload.service';

@Injectable()
export class PayloadResolve implements Resolve<{}> {

  constructor(private payloadService: PayloadService) { }

  resolve(route: ActivatedRouteSnapshot) {
    return this.payloadService.get();
  }
}