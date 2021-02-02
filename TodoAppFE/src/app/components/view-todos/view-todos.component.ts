import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user-service/user.service';
import { AuthDataStorage } from 'src/app/security/auth-data-storage';
import { Todo } from 'src/app/shared/data-types/Todo';

@Component({
  selector: 'app-view-todos',
  templateUrl: './view-todos.component.html',
  styleUrls: ['./view-todos.component.scss']
})
export class ViewTodosComponent implements OnInit {
  todos: any;
  user: any;
  constructor(private route: ActivatedRoute, public router:Router,
    private service: UserService, private authStorage: AuthDataStorage) { }

  ngOnInit() {
    this.user = this.authStorage.getLoggedUser();
    this.route.params.subscribe(params => { 
      this.service.getTodosByUserId(this.user.userId).subscribe(data=> {  
            console.log("--------");
            this.todos = data;
            console.log(this.todos);
      })
      })
    
  }

  deleteTodo(todo: Todo):void{
    this.service.deleteTodo(todo.todoId).subscribe(
      data => {  
        this.service.getTodosByUserId(this.user.userId).subscribe(data=> {  
          console.log("--------");
          this.todos = data;
          console.log(this.todos);
    })
      }
      ///this.router.navigate(["/viewSubjects"]);
      );
  }

  addTodo():void{
    this.router.navigate(["/addTodo"]);
  }

  logout():void{
    this.authStorage.clearAuthData();
    this.router.navigate(['/login']);
  }
}

