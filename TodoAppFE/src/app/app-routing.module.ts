import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserRoleGuard } from './security/guards/user-role-guard';
import { AuthGuard } from './security/guards/auth-guard';
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { ViewTodosComponent } from './components/view-todos/view-todos.component';
import { AddTodoComponent } from './components/add-todo/add-todo.component';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [
  {
    path:'',
    //component: RegisterStudentComponent,
    redirectTo:'home',
    pathMatch: 'full'
  },
  {
    path:'register',
    component: RegisterUserComponent,

  },
  {
    path:'login',
    component: LoginComponent
  },
  {
    path: 'logout',
    component: LoginComponent,
    canActivate: [AuthGuard]
  },
  {
    path:'home',
    component: ViewTodosComponent,
    canActivate: [AuthGuard, UserRoleGuard]

  },
  {
    path:'addTodo',
    component: AddTodoComponent,
    canActivate: [AuthGuard, UserRoleGuard]
  },
  {
  path: '**', 
  redirectTo: '/404'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
