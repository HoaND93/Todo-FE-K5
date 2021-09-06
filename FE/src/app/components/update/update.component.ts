import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  todoForm: FormGroup;
  isSubmit = false;
  id: string | null;

  constructor(
    private service: ApiService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private router: Router
  ) {
    this.todoForm = this.fb.group({
      category: 1,
      deadline: '',
      note: '',
      status: 1,
      title: ['', Validators.required]
    });
    this.id = this.route.snapshot.paramMap.get('id');
    this.service.getTodo(this.id).subscribe(res => {
      this.todoForm.setValue({
        category: res.category,
        deadline: res.deadline,
        note: res.note,
        status: res.status,
        title: res.title
      });
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.isSubmit = true;
    if (this.todoForm.status === 'VALID') {
      let request = Object.assign({id: this.id}, this.todoForm.value);
      if (typeof request.deadline === 'object') {
        request.deadline = request.deadline.toLocaleDateString("vi");
      }

      this.service.updateTodo(request).subscribe(() => this.router.navigateByUrl('/list'));
    }
  }

}
