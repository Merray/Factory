import {Component, OnInit} from '@angular/core';
import {RessourceHumaine} from '../model/ressource-humaine';
import {RessourceHumaineService} from '../service/RessourceHumaine/ressource-humaine.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Stagiaire} from '../model/RessourceHumaineHeritage/stagiaire';

@Component({
  selector: 'app-ressource-humaine-edit',
  templateUrl: './ressource-humaine-edit.component.html',
  styleUrls: ['./ressource-humaine-edit.component.css']
})
export class RessourceHumaineEditComponent implements OnInit {

  ressourceHumaine: RessourceHumaine;
  stagiaire: Stagiaire;

  constructor(private ressourceHumaineService: RessourceHumaineService, private ar: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.ressourceHumaineService.findById(params.id).subscribe(resp => {
          this.ressourceHumaine = resp;
        });
      }
    });
  }

  public save(type: string) {
    if (type === 'Stagiaire') {
    // @ts-ignore
      this.stagiaire = this.ressourceHumaine;
      this.ressourceHumaineService.save(this.stagiaire).subscribe(resp => {
        this.router.navigate(['/ressourcehumaine']);
      });
    } else {
      console.log('l\'egalité ne passe pas');
    }
    // this.adherentService.save(this.adherent).subscribe(resp => {
    //  this.router.navigate(['/adherent']);
    // });
  }
}
