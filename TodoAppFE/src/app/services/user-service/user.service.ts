import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthDataStorage } from 'src/app/security/auth-data-storage';
import { User } from 'src/app/shared/data-types/User';
import { Observable } from 'rxjs';
import { Todo } from 'src/app/shared/data-types/Todo';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private service : AuthDataStorage) { }

  public registerUser(user: User): Observable<User>{
    const url = 'http://localhost:8130/register';
    return this.http.post<User>(url, user);
  }

  public getStudent(): Observable<User> {
    console.log(this.service.getJwtToken());
    const url = 'http://localhost:8130/getUser';

    return this.http.get<User>(url);
  }
  
  public getSubjects(): Observable<Todo[]>{
    console.log("--------");
    const url = 'http://localhost:8131/getTodos';
    return this.http.get<Todo[]>(url);
  }

  public getTodosByUserId(id: String): Observable<Todo[]>{
    console.log("in service");
    console.log(id);
    return this.http.get<Todo[]>(`http://localhost:8131/getTodos/${id}`);
  }

  public deleteTodo(id: String): Observable<any>{
    let todo: any;
    return this.http.post<any>('http://localhost:8131/removeTodo/'+id,todo);
  }


  public addTodo(todo: Todo): Observable<User>{
    const url = 'http://localhost:8131/addTodo';
    return this.http.post<User>(url, todo);
  }

}
