import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Cursus} from '../model/cursus';
import {CursusService} from '../service/cursus/cursus.service';
import {Salle} from '../model/RessourceMaterielleHeritage/salle';
import {VideoProjecteur} from '../model/RessourceMaterielleHeritage/videoProjecteur';
import {RessourceMaterielleService} from '../service/ressource-materielle.service';
import {RessourceMaterielle} from '../model/ressourceMaterielle';

@Component({
  selector: 'app-cursus-edit',
  templateUrl: './cursus-edit.component.html',
  styleUrls: ['./cursus-edit.component.css']
})
export class CursusEditComponent implements OnInit {

  constructor(private ressourceMaterielleService: RessourceMaterielleService, private cursusSercive: CursusService,
              private ar: ActivatedRoute, private router: Router) {
  }

  ressourceMaterielles: RessourceMaterielle[];
  cursus: Cursus;
  videoPojecteur: VideoProjecteur[];

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.cursusSercive.findById(params.id).subscribe(resp => {
          this.cursus = resp;
        });
      }
    });
  }

  public save() {
    this.cursusSercive.save(this.cursus).subscribe(resp => {
      this.router.navigate([`/cursus`]);
    });
  }

  public listMatos() {
    this.ressourceMaterielleService.list().subscribe(resp => {
      this.ressourceMaterielles = resp;
      console.log(resp);
    });
  }

}
