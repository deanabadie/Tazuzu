import { Component, OnInit } from '@angular/core';
import { User } from './user.interface';

@Component({
  moduleId: module.id,
  selector: 'my-app',
  template: '<h1><img src="images/Tazuzu logo.jpg" alt="logo" /></h1><login></login>',
})
export class AppComponent implements OnInit {
  public user: User;

  ngOnInit() {
    this.user = {
      username: '',
      password: '',
      
    }
  }
}