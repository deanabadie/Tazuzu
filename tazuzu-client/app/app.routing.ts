import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './homeStudent/index';
import { HomeTeacherComponent } from './homeTeacher/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { RegisterTeacherComponent } from './registerTeacher/index';
import { CreateActivityComponent } from './createActivity/index';
import { ActivityComponent } from './activity/index';
import { StudentActivities } from './studentActivities/index';
import { CanActivateAuthGuard } from './_guards/index';
import { PayloadResolve, UserResolve } from './_resolvers/index';
import { StudentLayout } from './studentLayout/index';
import { TeacherLayout } from './teacherLayout/index';

const appRoutes: Routes = [
    {
        path: '', resolve: { payload: PayloadResolve }, children: [
            { path: 'login', component: LoginComponent },

            { path: 'teachers/registration', component: RegisterTeacherComponent },

            //Teachers states
            {
                path: 'teachers', component: TeacherLayout, canActivate: [CanActivateAuthGuard], children: [
                    { path: 'current', component: HomeTeacherComponent, resolve: { user: UserResolve } },
                    { path: 'students/registration', component: RegisterComponent, resolve: { user: UserResolve, payload: PayloadResolve } },
                    { path: 'activities/create', component: CreateActivityComponent, resolve: { user: UserResolve, payload: PayloadResolve } },
                    { path: 'activities/list/:id', component: ActivityComponent, resolve: { user: UserResolve } }
                ]
            },

            //Students states
            {
                path: 'students', component: StudentLayout, canActivate: [CanActivateAuthGuard], children: [
                    { path: 'current', component: HomeComponent, resolve: { user: UserResolve } },
                    { path: 'activities/create', component: CreateActivityComponent, resolve: { user: UserResolve, payload: PayloadResolve } },
                    { path: 'activities/list', component: StudentActivities, resolve: { user: UserResolve } },
                    { path: 'activities/list/:id', component: ActivityComponent, resolve: { user: UserResolve } }
                ]
            },

            //Default state - redirect to home
            { path: '**', redirectTo: 'login' }
        ]
    }
];

export const routing = RouterModule.forRoot(appRoutes);
