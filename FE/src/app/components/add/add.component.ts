import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/api.service';
import { TodoRequest } from 'src/app/models/todo.request';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.scss']
})
export class AddComponent implements OnInit {

  todoForm: FormGroup;
  isSubmit = false;

  constructor(
    private service: ApiService,
    private fb: FormBuilder,
    private router: Router
  ) {
    this.todoForm = this.fb.group({
      category: 1,
      deadline: '',
      note: '',
      status: 1,
      title: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.isSubmit = true;
    if (this.todoForm.status === 'VALID') {
      let request = Object.assign({}, this.todoForm.value);
      request.deadline = request.deadline.toLocaleDateString("vi");

      this.service.addTodo(request).subscribe(() => this.router.navigateByUrl('/list'));
    }
  }

}
