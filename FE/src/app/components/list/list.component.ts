import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiService } from 'src/app/api.service';
import { TodoResponse } from 'src/app/models/todo.response';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  $todoList: Observable<TodoResponse[]>;
  textSearch: string = '';
  page: number = 0;

  constructor(
    private service: ApiService
  ) {
    this.$todoList = this.service.getList({
      title: this.textSearch,
      page: this.page
    });
  }

  ngOnInit(): void {
  }

  search() {
    this.page = 0;
    this.getTodoList();
  }

  changePage(page: number) {
    this.page = page;
    this.getTodoList();
  }

  getTodoList() {
    this.$todoList = this.service.getList({
      title: this.textSearch,
      page: this.page
    });
  }

}
