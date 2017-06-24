import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpModule, RequestOptions, XHRBackend } from '@angular/http';
import { ReactiveFormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { AlertComponent } from './_directives/index';
import { CanActivateAuthGuard } from './_guards/index';
import { AlertService, AuthenticationService, PayloadService, ActivityService, StudentService, TeacherService } from './_services/index';
import { HomeComponent } from './homeStudent/index';
import { HomeTeacherComponent } from './homeTeacher/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { RegisterTeacherComponent } from './registerTeacher/index';
import { CreateActivityComponent } from './createActivity/index';
import { ActivityComponent } from './activity/index';
import { StudentActivitiesList } from './student-activities-list/index';
import { TeacherActivitiesList } from './teacher-activities-list/index';
import { HttpService } from './_services/http.service';
import { PayloadResolve, UserResolve } from './_resolvers/index';
import { MdAutocompleteModule, MdSelectionModule, MdCardModule, MdInputModule } from '@angular/material';
import { ChartsModule } from 'ng2-charts';
import { StudentLayout } from './studentLayout/index';
import { TeacherLayout } from './teacherLayout/index';
import { ActivityResults } from './activity-results/index';

import * as jwt from 'jwt-decode';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpModule,
        BrowserAnimationsModule,
        MdAutocompleteModule,
        MdCardModule,
        MdInputModule,
        MdSelectionModule,
        ChartsModule,
        routing,
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        HomeTeacherComponent,
        LoginComponent,
        RegisterComponent,
        RegisterTeacherComponent,
        CreateActivityComponent,
        ActivityComponent,
        StudentActivitiesList,
        TeacherActivitiesList,
        ActivityResults,
        StudentLayout,
        TeacherLayout
    ],
    providers: [
        CanActivateAuthGuard,
        AlertService,
        AuthenticationService,
        PayloadService,
        ActivityService,
        TeacherService,
        StudentService,
        {
            provide: HttpService,
            useFactory: (backend: XHRBackend, options: RequestOptions) => {
                return new HttpService(backend, options);
            },
            deps: [XHRBackend, RequestOptions]
        },
        PayloadResolve,
        UserResolve
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }