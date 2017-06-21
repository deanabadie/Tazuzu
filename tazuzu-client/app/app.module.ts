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
import { AlertService, AuthenticationService, UserService, PayloadService, ActivityService, StudentService, TeacherService } from './_services/index';
import { HomeComponent } from './home/index';
import { HomeTeacherComponent } from './homeTeacher/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { RegisterTeacherComponent } from './registerTeacher/index';
import { CreateActivityComponent } from './createActivity/index';
import { ActivityComponent } from './activity/index';
import { StudentActivities } from './studentActivities/index';
import { HttpService } from './_services/http.service';
import { PayloadResolve, UserResolve } from './_resolvers/index';
import { MdAutocompleteModule, MdSelectionModule, MdCardModule, MdInputModule } from '@angular/material';
import { ChartsModule } from 'ng2-charts';
import { StudentLayout } from './studentLayout/index';
import { TeacherLayout } from './teacherLayout/index';

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
        StudentActivities,
        StudentLayout,
        TeacherLayout
    ],
    providers: [
        CanActivateAuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
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