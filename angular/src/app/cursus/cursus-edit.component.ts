import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Cursus} from '../model/cursus';
import {CursusService} from '../service/cursus/cursus.service';

@Component({
  selector: 'app-cursus-edit',
  templateUrl: './cursus-edit.component.html',
  styleUrls: ['./cursus-edit.component.css']
})
export class CursusEditComponent implements OnInit {

  constructor(private cursusService: CursusService, private ar: ActivatedRoute, private router: Router) {
  }

  cursus: Cursus;

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.cursusService.findById(params.id).subscribe(resp => {
          this.cursus = resp;
        });
      } else {
        this.cursus = new Cursus();

      }
    });
  }

  public save() {
    this.cursusService.save(this.cursus).subscribe(resp => {
      this.router.navigate([`/cursus`]);
    });
  }


  /*   <div class="form-group" *ngFor="let number of [0,1,2,3,4]">
        <label for="stagiaire">Ajout d'un stagiaire par Id :</label>
        <input id="stagiaire" name="stagiaire" type="number" class="form-control" required [(ngModel)]="cursus.stagiaires[number].id" #nom="ngModel"/>
      </div> */
}
