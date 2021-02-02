import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user-service/user.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl } from '@angular/forms';
import { Todo } from 'src/app/shared/data-types/Todo';
import { AuthDataStorage } from 'src/app/security/auth-data-storage';

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.scss']
})
export class AddTodoComponent implements OnInit {
  subject: string;
  description: string;
  priority: string;
  user: any;
  constructor(private service: UserService, public router: Router, private authStorage: AuthDataStorage) {}
  private todoForm: FormGroup;

  ngOnInit() {
    this.user = this.authStorage.getLoggedUser();
    this.todoForm = new FormGroup({
      subject: new FormControl(''),
      description: new FormControl(''),
      priority: new FormControl(''),
    })
  }

  add() {
    const todo: Todo = this.getTodo();
    this.service.addTodo(todo)
        .subscribe(_ => {
          // this.toastr.success('Welcome to our application',"",{
          //   "closeButton": true,
          //   "positionClass": "toast-bottom-right",
          //   "tapToDismiss": true});
          this.router.navigate(["/home"]);
        }, err => {
          // this.toastr.error(err.error.Message,"",{
          //   "closeButton": true,
          //   "positionClass": "toast-bottom-right",
          //   "tapToDismiss": true});
        });
  }

  getTodo(): Todo {
    const todo: Todo = new Todo();
    let currentTodo = this.todoForm.value;
    todo.subject = currentTodo.subject;
    todo.description = currentTodo.description;
    todo.priority = currentTodo.priority;
    todo.userId = this.user.userId;
    return todo;
  }

}
