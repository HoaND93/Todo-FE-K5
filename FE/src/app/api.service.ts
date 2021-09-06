import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SearchTodoRequest } from './models/search.request';
import { TodoRequest } from './models/todo.request';
import { TodoResponse } from './models/todo.response';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(
    private htttp: HttpClient
  ) { }

  public getList(request: SearchTodoRequest): Observable<TodoResponse[]> {
    return this.htttp.post<TodoResponse[]>(`http://localhost:8080/api/search`, request);
  }

  public getTodo(id: string | null): Observable<TodoResponse> {
    return this.htttp.get<TodoResponse>(`http://localhost:8080/api/${id}`);
  }

  public addTodo(request: TodoRequest) {
    return this.htttp.post(`http://localhost:8080/api`, request);
  }

  public updateTodo(request: TodoRequest) {
    return this.htttp.put(`http://localhost:8080/api`, request);
  }

  public deleteTodo(id: string): Observable<string> {
    return this.htttp.delete<string>(`http://localhost:8080/api/${id}`);
  }
}
