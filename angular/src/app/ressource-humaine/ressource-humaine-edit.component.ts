import {Component, OnInit} from '@angular/core';
import {RessourceHumaine} from '../model/ressource-humaine';
import {RessourceHumaineService} from '../service/RessourceHumaine/ressource-humaine.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Stagiaire} from '../model/RessourceHumaineHeritage/stagiaire';
import {Gestionnaire} from '../model/RessourceHumaineHeritage/gestionnaire';
import {Technicien} from '../model/RessourceHumaineHeritage/technicien';
import {Formateur} from '../model/RessourceHumaineHeritage/formateur';
import {RessourceMaterielleService} from '../service/ressource-materielle.service';
import {RessourceMaterielle} from '../model/ressourceMaterielle';
import {Adresse} from '../model/adresse';
import {Coordonnee} from '../model/coordonnee';

@Component({
  selector: 'app-ressource-humaine-edit',
  templateUrl: './ressource-humaine-edit.component.html',
  styleUrls: ['./ressource-humaine-edit.component.css']
})
export class RessourceHumaineEditComponent implements OnInit {

  constructor(private ressourceHumaineService: RessourceHumaineService, private ressourceMaterielservice: RessourceMaterielleService,
              private ar: ActivatedRoute, private router: Router) {
  }

  ressourceHumaine: RessourceHumaine;
  ressourceMaterielles: RessourceMaterielle[];
  stagiaire: Stagiaire;
  gestionnaire: Gestionnaire;
  technicien: Technicien;
  formateur: Formateur;
  idOrdi: number;

  ngOnInit() {
    this.ressourceHumaine = new Stagiaire();
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.ressourceHumaineService.findById(params.id).subscribe(resp => {
          this.ressourceHumaine = resp;
        });
      } else if (params.type === 'Stagiaire') {
        this.ressourceHumaine = new Stagiaire();
        this.ressourceHumaine.type = params.type;
      } else if (params.type === 'Gestionnaire') {
        this.ressourceHumaine = new Gestionnaire();
        this.ressourceHumaine.type = params.type;
      } else if (params.type === 'Technicien') {
        this.ressourceHumaine = new Technicien();
        this.ressourceHumaine.type = params.type;
      } else if (params.type === 'Formateur') {
        this.ressourceHumaine = new Formateur();
        this.ressourceHumaine.type = params.type;
      }
      this.ressourceHumaine.adresse = new Adresse();
      this.ressourceHumaine.coordonnee = new Coordonnee();
    });
    this.ressourceMaterielservice.list().subscribe(resp => {
      this.ressourceMaterielles = resp;
    });
  }

  public save(type: string) {
    if (type === 'Stagiaire') {
      // @ts-ignore
      this.stagiaire = this.ressourceHumaine;
      this.ressourceMaterielservice.findById(this.idOrdi).subscribe(resp => {
        // @ts-ignore
        this.stagiaire.ordinateur = resp;
        this.ressourceHumaineService.save(this.stagiaire).subscribe(resp => {
          this.router.navigate(['/ressourcehumaine']);
        });
      });
    } else if (type === 'Gestionnaire') {
      // @ts-ignore
      this.gestionnaire = this.ressourceHumaine;
      this.ressourceHumaineService.save(this.gestionnaire).subscribe(resp => {
        this.router.navigate(['/ressourcehumaine']);
      });
    } else if (type === 'Technicien') {
      // @ts-ignore
      this.technicien = this.ressourceHumaine;
      this.ressourceHumaineService.save(this.technicien).subscribe(resp => {
        this.router.navigate(['/ressourcehumaine']);
      });
    } else if (type === 'Formateur') {
      // @ts-ignore
      this.formateur = this.ressourceHumaine;
      this.ressourceHumaineService.save(this.formateur).subscribe(resp => {
        this.router.navigate(['/ressourcehumaine']);
      });
    }
  }

  public filterRessourceMaterielleOfType(filtre: string) {
    return this.ressourceMaterielles.filter(x => x.type === filtre);
  }
}
