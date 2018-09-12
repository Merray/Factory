import {Component, OnInit} from '@angular/core';
import {Cursus} from '../model/cursus';
import {CursusService} from '../service/cursus/cursus.service';

@Component({
  selector: 'app-cursus',
  templateUrl: './cursus.component.html',
  styleUrls: ['./cursus.component.css']
})
export class CursusComponent implements OnInit {
  cursus: Cursus[];

  constructor(private cursusService: CursusService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.cursusService.list().subscribe(resp => {
      this.cursus = resp;
      console.log(resp);
    });
  }

  public delete(id: number) {
    if (confirm('Etes-vous sûr de vouloir supprimer ce cursus?')) {
      this.cursusService.delete(id).subscribe(resp => {
        this.list();
      });
    }
  }

  public compteur(id: number) {
    console.log(this.cursus[id].stagiaires);
  }
}

//  +this.cursus[id].stagiaires.length
