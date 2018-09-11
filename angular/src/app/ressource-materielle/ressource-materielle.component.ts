import {Component, OnInit} from '@angular/core';
import {RessourceMaterielle} from '../model/ressourceMaterielle';
import {RessourceMaterielleService} from '../service/ressource-materielle.service';

@Component({
  selector: 'app-ressource-materielle',
  templateUrl: './ressource-materielle.component.html',
  styleUrls: ['./ressource-materielle.component.css']
})
export class RessourceMaterielleComponent implements OnInit {
  ressources: RessourceMaterielle[];
  calcul = 0;

  constructor(private ressourceMaterielleService: RessourceMaterielleService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.ressourceMaterielleService.list().subscribe(resp => {
      this.ressources = resp;
    }, error => console.log(error));
  }

  public delete(id: number) {
    this.ressourceMaterielleService.delete(id).subscribe(resp => {
      this.list();
    });
  }

  public somme() {
    for (let i = 0; i < this.ressources.length; i++) {
      this.calcul = this.ressources[i].coutUtilisation + this.calcul;
    }
    return this.calcul;
  }
}

