import { Component }       from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector:    'login',
  template: `<div class="container">
  
  <form #f="ngForm" novalidate (ngSubmit)="save(f.value, f.valid)">
    <div class="form-group">
      <label> Please insert Username and Password: </label> <br> <br>
      <label for="">Username:</label>
      <input type="text" class="form-control" name="username" [ngModel]="user.username" 
        required minlength="5" maxlength="8" #username="ngModel">
      <small [hidden]="username.valid || (username.pristine && !f.submitted)" class="text-danger">
        Username is required (minimum 5 characters).
      </small>
      <!--<pre *ngIf="username.errors" class="margin-20">{{ username.errors | json }}</pre>-->
    </div><br>
    
    <div class="form-group">
      <label for="">Password:</label>
      <input type="password" class="form-control" name="password" [ngModel]="user.password" 
        required reverse="true" #password="ngModel">
      <small [hidden]="password.valid || (password.pristine && !f.submitted)" class="text-danger">
        Password is required
      </small>
      <!--<pre *ngIf="password.errors" class="margin-20">{{ password.errors | json }}</pre>-->
    </div><br>
    <button type="submit" class="btn btn-default" go-click="./teacherMenu">Login</button>
  </form>
</div>`,
  providers: [LoginService],
})
export class LoginComponent {
 // constructor(private loginService: LoginService) { }

 // getTax(name: string | number) {
 //   return this.loginService.getUsername(name);
 // }

 openMenu(){
   window.location.href = "http://www.ynet.co.il"
 }

}

/*`<h2>Please insert username and password</h2>
              Username: <input #usernameBox (change)="0">
               Password: <input #passwordBox (change)="0">
    <div *ngIf="usernameBox.value">
    The Username you inserted
     {{ get(usernameBox.value) | currency:'USD':true:'1.2-2' }}
    </div>`*/
