import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { HomeTeacherComponent } from './homeTeacher/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { RegisterTeacherComponent } from './registerTeacher/index';
import { CreateActivityComponent } from './CreateActivity/index';
import { StudentActivities } from './studentPastActivity/index';
import { StudentGradesComponent } from './studentGrades/index';
import { CanActivateAuthGuard } from './_guards/index';
import { PayloadResolve, UserResolve } from './_resolvers/index';

const appRoutes: Routes = [
    {
        path: '', resolve: { payload: PayloadResolve }, children: [
            { path: 'login', component: LoginComponent },

            { path: 'teachers/registration', component: RegisterTeacherComponent },
            
            //Teachers states
            {
                path: 'teachers', canActivate: [CanActivateAuthGuard], resolve: { user: UserResolve }, children: [
                    { path: 'students/registration', component: RegisterComponent },
                    { path: 'current', component: HomeTeacherComponent }
                ]
            },

            //Activities
            {
                path: 'activities', canActivate: [CanActivateAuthGuard], resolve: { user: UserResolve }, children: [
                    { path: 'create', component: CreateActivityComponent }
                ]
            },

            //Students statesya
            {
                path: 'students', canActivate: [CanActivateAuthGuard], resolve: { user: UserResolve }, children: [
                    { path: 'current', component: HomeComponent },
                    { path: 'activities', component: StudentActivities },
                    { path: 'grades', component: StudentGradesComponent },
                ]
            },

            //Default state - redirect to home
            { path: '**', redirectTo: 'login' }
        ]
    }
];

export const routing = RouterModule.forRoot(appRoutes);
