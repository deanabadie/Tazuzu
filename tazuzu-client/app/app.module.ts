﻿import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

// used to create fake backend
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';

import { AppComponent } from './app.component';
import { routing } from './app.routing';

import { AlertComponent } from './_directives/index';
import { AuthGuard } from './_guards/index';
import { AlertService, AuthenticationService, UserService, TeacherService } from './_services/index';
import { HomeComponent } from './home/index';
import { HomeTeacherComponent } from './homeTeacher/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { RegisterTeacherComponent } from './registerTeacher/index';
import { TeacherCreateActivityComponent } from './teacherCreateActivity/index';
import { StudentCreateActivityComponent } from './studentCreateActivity/index';
import { StudentPastActivityComponent } from './studentPastActivity/index';
import { StudentGradesComponent } from './studentGrades/index';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        routing
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
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        TeacherService,
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }