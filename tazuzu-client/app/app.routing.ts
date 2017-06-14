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
import { AuthGuard } from './_guards/index';

const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },

    //Teachers states
    { path: 'teachers/students/registration', component: RegisterComponent },
    { path: 'teachers/registration', component: RegisterTeacherComponent },
    { path: 'teachers/current', component: HomeTeacherComponent },
    { path: 'teachers/activities/create', component: TeacherCreateActivityComponent },

    //Students states
    { path: 'students/current', component: HomeComponent },
    { path: 'students/activities/create', component: StudentCreateActivityComponent },
    { path: 'students/activities/past', component: StudentPastActivityComponent },
    { path: 'students/grades', component: StudentGradesComponent },
    
    //Default state - redirect to home
    { path: '**', redirectTo: 'login' }
];

export const routing = RouterModule.forRoot(appRoutes);