import { Component }       from '@angular/core';


@Component({
  selector:    'teacherMenu',
  template: `<div class="container">
  
  <form #f="ngForm" novalidate (ngSubmit)="save(f.value, f.valid)">
    <div class="form-group">
      <label> Please insert Username and Password: </label> <br> <br>
      <label for="">Username</label>
      <input type="text" class="form-control" name="username" [ngModel]="user.username" 
        required minlength="5" maxlength="8" #username="ngModel"><br>
      <small [hidden]="username.valid || (username.pristine && !f.submitted)" class="text-danger">
        Username is required (minimum 5 characters).
      </small>
      <!--<pre *ngIf="username.errors" class="margin-20">{{ username.errors | json }}</pre>-->
    </div><br>
    
    <div class="form-group">
      <input type="password" class="form-control" name="password" [ngModel]="user.password" 
        required reverse="true" #password="ngModel"><br>
      <small [hidden]="password.valid || (password.pristine && !f.submitted)" class="text-danger">
        Password is required
      </small>
      <!--<pre *ngIf="password.errors" class="margin-20">{{ password.errors | json }}</pre>-->
    </div><br>
   
  </form>
</div>`,
  
})
export class LoginComponent {
 // constructor(private loginService: LoginService) { }

 // getTax(name: string | number) {
 //   return this.loginService.getUsername(name);
 // }
}

/*`<h2>Please insert username and password</h2>
              Username: <input #usernameBox (change)="0">
               Password: <input #passwordBox (change)="0">
    <div *ngIf="usernameBox.value">
    The Username you inserted
     {{ get(usernameBox.value) | currency:'USD':true:'1.2-2' }}
    </div>`*/
