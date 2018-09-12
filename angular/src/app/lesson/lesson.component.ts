import {Component, OnInit} from '@angular/core';
import {Lesson} from '../model/lesson';
import {LessonService} from '../service/lesson/lesson.service';

@Component({
  selector: 'app-lesson',
  templateUrl: './lesson.component.html',
  styleUrls: ['./lesson.component.css']
})
export class LessonComponent implements OnInit {

  lessons: Lesson[];

  constructor(private lessonService: LessonService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.lessonService.list().subscribe(resp => {
      this.lessons = resp;
    }, error => {
      console.log(error);
    });
  }

  public delete(id: number) {
    if (confirm('Etes-vous sûr de vouloir supprimer cette leçon ?')) {
      this.lessonService.delete(id).subscribe(resp => {
        this.list();
      });
    }
  }

}
