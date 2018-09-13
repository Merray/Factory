import {Component, OnInit} from '@angular/core';
import {RessourceMaterielle} from '../model/ressourceMaterielle';
import {RessourceMaterielleService} from '../service/ressource-materielle.service';
import {Ordinateur} from '../model/RessourceMaterielleHeritage/ordinateur';
import {Salle} from '../model/RessourceMaterielleHeritage/salle';
import {VideoProjecteur} from '../model/RessourceMaterielleHeritage/videoProjecteur';

@Component({
  selector: 'app-ressource-materielle',
  templateUrl: './ressource-materielle.component.html',
  styleUrls: ['./ressource-materielle.component.css']
})
export class RessourceMaterielleComponent implements OnInit {
  ressources: RessourceMaterielle[];
  calcul = 0;
  value: string = '';
  ordinateurs: Ordinateur[];
  salles: Salle[];
  videoprojecteurs: VideoProjecteur[];
  idOrdi: number;
  constructor(private ressourceMaterielleService: RessourceMaterielleService) {
  }

  ngOnInit() {
    this.list();
    this.listO();
    this.listV();
    this.listS();
  }

  public list() {
    this.ressourceMaterielleService.list().subscribe(resp => {
      this.ressources = resp;
    }, error => console.log(error));
  }

  public listO() {
    this.ressourceMaterielleService.listO().subscribe(resp => {
      this.ordinateurs = resp;
    }, error => console.log(error));
  }

  public listV() {
    this.ressourceMaterielleService.listV().subscribe(resp => {
      this.videoprojecteurs = resp;
    }, error => console.log(error));
  }

  public listS() {
    this.ressourceMaterielleService.listS().subscribe(resp => {
      this.salles = resp;
    }, error => console.log(error));
  }

  public delete(id: number) {
    if (confirm('Etes-vous sûr de vouloir supprimer cette ressource matérielle?')) {
      this.ressourceMaterielleService.delete(id).subscribe(resp => {
        this.list();
      });
    }
  }

  public somme() {
    this.calcul = 0;
    for (let i = 0; i < this.ressources.length; i++) {
      this.calcul = this.ressources[i].coutUtilisation + this.calcul;
    }
    return this.calcul;
  }

  testNom() {
    return this.ressources.filter(c => c.code.indexOf(this.value) !== -1);
  }
}

