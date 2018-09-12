import { Component, OnInit } from '@angular/core';
import {Matiere} from '../model/matiere';
import {MatiereService} from '../service/matiere/matiere.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Lesson} from '../model/lesson';
import {LessonService} from '../service/lesson/lesson.service';

@Component({
  selector: 'app-lesson-edit',
  templateUrl: './lesson-edit.component.html',
  styleUrls: ['./lesson-edit.component.css']
})
export class LessonEditComponent implements OnInit {

  lesson: Lesson = new Lesson();

  constructor(private lessonService: LessonService, private ar: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.lessonService.findById(params.id).subscribe(resp => {
          this.lesson = resp;
        });
      }
    });
  }

  public save() {
    this.lessonService.save(this.lesson).subscribe(resp => {
        this.router.navigate(['/lesson']);
      }
    );
  }
}
