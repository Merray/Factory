import {Component, OnInit} from '@angular/core';
import {RessourceHumaine} from '../model/ressource-humaine';
import {RessourceHumaineService} from '../service/RessourceHumaine/ressource-humaine.service';
import {Stagiaire} from '../model/RessourceHumaineHeritage/stagiaire';
import {Technicien} from '../model/RessourceHumaineHeritage/technicien';
import {Gestionnaire} from '../model/RessourceHumaineHeritage/gestionnaire';
import {Formateur} from '../model/RessourceHumaineHeritage/formateur';

@Component({
  selector: 'app-ressource-humaine',
  templateUrl: './ressource-humaine.component.html',
  styleUrls: ['./ressource-humaine.component.css']
})
export class RessourceHumaineComponent implements OnInit {

  ressourceHumaines: RessourceHumaine[];
  stagiaires: Stagiaire[];
  techniciens: Technicien[];
  gestionnaires: Gestionnaire[];
  formateurs: Formateur[];
  constructor(private ressourceHumaineService: RessourceHumaineService) {

  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.ressourceHumaineService.list().subscribe(resp => {
      this.ressourceHumaines = resp;
    });
  }

  public listStagiaire() {
    this.ressourceHumaineService.listStagiaire().subscribe(resp => {
      this.stagiaires = resp;
    }, error => console.log(error));
  }

  public listTechnicien() {
    this.ressourceHumaineService.listTechnicien().subscribe(resp => {
      this.techniciens = resp;
    }, error => console.log(error));
  }

  public listGestionnaire() {
    this.ressourceHumaineService.listGestionnaire().subscribe(resp => {
      this.gestionnaires = resp;
    }, error => console.log(error));
  }

  public listFormateur() {
    this.ressourceHumaineService.listFormateur().subscribe(resp => {
      this.formateurs = resp;
    }, error => console.log(error));
  }

  public delete(id: number) {
    if (confirm('Etes-vous sûr de vouloir supprimer cette ressource humaine?')) {
      this.ressourceHumaineService.delete(id).subscribe(resp => {
        this.list();
      });
    }
  }
}
