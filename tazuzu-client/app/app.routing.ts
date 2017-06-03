import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { HomeTeacherComponent } from './homeTeacher/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { RegisterTeacherComponent } from './registerTeacher/index';
import { TeacherCreateActivityComponent } from './teacherCreateActivity/index';
import { StudentCreateActivityComponent } from './studentCreateActivity/index';
import { AuthGuard } from './_guards/index';

const appRoutes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'registerTeacher', component: RegisterTeacherComponent },
    { path: 'homeTeacher', component: HomeTeacherComponent },
    { path: 'home', component: HomeComponent },
    { path: 'teacherCreateActivity', component: TeacherCreateActivityComponent },
    { path: 'studentCreateActivity', component: StudentCreateActivityComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);