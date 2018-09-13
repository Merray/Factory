import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Cursus} from '../model/cursus';
import {CursusService} from '../service/cursus/cursus.service';
import {RessourceMaterielleService} from '../service/ressource-materielle.service';
import {Salle} from '../model/RessourceMaterielleHeritage/salle';
import {VideoProjecteur} from '../model/RessourceMaterielleHeritage/videoProjecteur';
import {Gestionnaire} from '../model/RessourceHumaineHeritage/gestionnaire';
import {RessourceHumaineService} from '../service/RessourceHumaine/ressource-humaine.service';

@Component({
  selector: 'app-cursus-edit',
  templateUrl: './cursus-edit.component.html',
  styleUrls: ['./cursus-edit.component.css']
})
export class CursusEditComponent implements OnInit {

  constructor(private cursusService: CursusService, private ressourceMaterielleService: RessourceMaterielleService
    , private ar: ActivatedRoute, private router: Router) {
  }

  cursus: Cursus;
  ressourceSalle: Salle[];
  ressourceProjo: VideoProjecteur[];
  idSalle: number;
  idProjo: number;

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
    this.ressourceMaterielleService.listS().subscribe(resp => {
      this.ressourceSalle = resp;

    });
    this.ressourceMaterielleService.listV().subscribe(resp => {
      this.ressourceProjo = resp;

    });
  }


  public save() {
    this.ressourceMaterielleService.findById(this.idProjo).subscribe(resp => {
      // @ts-ignore
      this.cursus.videoProjecteur = resp;
      this.ressourceMaterielleService.findById(this.idSalle).subscribe(resp1 => {
        // @ts-ignore
        this.cursus.salle = resp1;
        this.cursusService.save(this.cursus).subscribe(resp3 => {
          this.router.navigate([`/cursus`]);
        });
      });
    });
  }
}
