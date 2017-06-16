import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HttpModule, RequestOptions, XHRBackend } from '@angular/http';
import { ReactiveFormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { AlertComponent } from './_directives/index';
import { CanActivateAuthGuard } from './_guards/index';
import { AlertService, AuthenticationService, UserService, TeacherService, PayloadService } from './_services/index';
import { HomeComponent } from './home/index';
import { HomeTeacherComponent } from './homeTeacher/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { RegisterTeacherComponent } from './registerTeacher/index';
import { TeacherCreateActivityComponent } from './teacherCreateActivity/index';
import { StudentCreateActivityComponent } from './studentCreateActivity/index';
import { StudentPastActivityComponent } from './studentPastActivity/index';
import { StudentGradesComponent } from './studentGrades/index';
import { HttpService } from './_services/http.service';
import { PayloadResolve } from './_resolvers/payload.resolver';
import { MdAutocompleteModule, MdSelectionModule, MdCardModule, MdInputModule } from '@angular/material';

@NgModule({
    imports: [
        BrowserModule, 
        FormsModule,
        ReactiveFormsModule,
        HttpModule,
        routing,
        BrowserAnimationsModule,
        MdAutocompleteModule,
        MdCardModule,
        MdInputModule,
        MdSelectionModule
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        HomeTeacherComponent,
        LoginComponent,
        RegisterComponent,
        RegisterTeacherComponent,
        TeacherCreateActivityComponent,
        StudentCreateActivityComponent,
        StudentPastActivityComponent,
        StudentGradesComponent,
    ],
    providers: [
        CanActivateAuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        PayloadService,
        TeacherService,
        {
            provide: HttpService,
            useFactory: (backend: XHRBackend, options: RequestOptions) => {
                return new HttpService(backend, options);
            },
            deps: [XHRBackend, RequestOptions]
        },
        PayloadResolve
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }