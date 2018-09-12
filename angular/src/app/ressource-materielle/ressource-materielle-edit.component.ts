import {Component, OnInit} from '@angular/core';
import {RessourceMaterielleService} from '../service/ressource-materielle.service';
import {ActivatedRoute, Router} from '@angular/router';
import {RessourceMaterielle} from '../model/ressourceMaterielle';
import {Ordinateur} from '../model/RessourceMaterielleHeritage/ordinateur';
import {VideoProjecteur} from '../model/RessourceMaterielleHeritage/videoProjecteur';
import {Salle} from '../model/RessourceMaterielleHeritage/salle';
import {Stagiaire} from '../model/RessourceHumaineHeritage/stagiaire';
import {Gestionnaire} from '../model/RessourceHumaineHeritage/gestionnaire';
import {Technicien} from '../model/RessourceHumaineHeritage/technicien';
import {Formateur} from '../model/RessourceHumaineHeritage/formateur';
import {Cursus} from '../model/cursus';

@Component({
  selector: 'app-ressource-materielle-edit',
  templateUrl: './ressource-materielle-edit.component.html',
  styleUrls: ['./ressource-materielle-edit.component.css']
})
export class RessourceMaterielleEditComponent implements OnInit {

  constructor(private ressourceMaterielleService: RessourceMaterielleService, private ar: ActivatedRoute, private router: Router) {
  }

  ressources: RessourceMaterielle[];
  ressourceMaterielle: RessourceMaterielle;
  ordinateur: Ordinateur;
  video_projecteur: VideoProjecteur;
  salle: Salle;

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.ressourceMaterielleService.findById(params.id).subscribe(resp => {
          this.ressourceMaterielle = resp;
        });
      } else if (params.type === 'ordinateur') {
        this.ressourceMaterielle = new Ordinateur();
        this.ressourceMaterielle.type = params.type;
      } else if (params.type === 'video_projecteur') {
        this.ressourceMaterielle = new VideoProjecteur();
        this.ressourceMaterielle.type = params.type;
      } else if (params.type === 'salle') {
        this.ressourceMaterielle = new Salle();
        this.ressourceMaterielle.type = params.type;
      }
    });
  }

  public save(type: string) {
    if (type === 'ordinateur') {
      // @ts-ignore
      this.ordinateur = this.ressourceMaterielle;
      this.ressourceMaterielleService.save(this.ordinateur).subscribe(resp => {
        this.router.navigate(['/ressourcematerielle']);
      });
    } else if (type === 'video_projecteur') {
      // @ts-ignore
      this.videoprojecteur = this.ressourceMaterielle;
      this.ressourceMaterielleService.save(this.video_projecteur).subscribe(resp => {
        this.router.navigate(['/ressourcematerielle']);
      });
    } else if (type === 'salle') {
      // @ts-ignore
      this.salle = this.ressourceMaterielle;
      this.ressourceMaterielleService.save(this.salle).subscribe(resp => {
        this.router.navigate(['/ressourcematerielle']);
      });
    }
  }


}
