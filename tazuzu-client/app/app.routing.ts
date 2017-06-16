import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { HomeTeacherComponent } from './homeTeacher/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { RegisterTeacherComponent } from './registerTeacher/index';
import { TeacherCreateActivityComponent } from './teacherCreateActivity/index';
import { StudentCreateActivityComponent } from './studentCreateActivity/index';
import { StudentPastActivityComponent } from './studentPastActivity/index';
import { StudentGradesComponent } from './studentGrades/index';
import { CanActivateAuthGuard } from './_guards/index';
import { PayloadResolve } from './_resolvers/payload.resolver';

const appRoutes: Routes = [
    {
        path: '', resolve: { payload: PayloadResolve }, children: [
            { path: 'login', component: LoginComponent },

            { path: 'teachers/registration', component: RegisterTeacherComponent },
            
            //Teachers states
            {
                path: 'teachers', canActivate: [CanActivateAuthGuard], children: [
                    { path: 'students/registration', component: RegisterComponent },
                    { path: 'current', component: HomeTeacherComponent },
                    { path: 'activities/create', component: TeacherCreateActivityComponent },
                ]
            },

            //Students states
            {
                path: 'students', canActivate: [CanActivateAuthGuard], children: [
                    { path: 'current', component: HomeComponent },
                    { path: 'activities/create', component: StudentCreateActivityComponent },
                    { path: 'activities/past', component: StudentPastActivityComponent },
                    { path: 'grades', component: StudentGradesComponent },
                ]
            },

            //Default state - redirect to home
            { path: '**', redirectTo: 'login' }
        ]
    }
];

export const routing = RouterModule.forRoot(appRoutes);