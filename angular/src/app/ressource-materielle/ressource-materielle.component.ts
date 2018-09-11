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
  value: string = '';

  constructor(private ressourceMaterielleService: RessourceMaterielleService) {
  }

  ngOnInit() {
    this.list();
    this.listO();
  }

  public list() {
    this.ressourceMaterielleService.list().subscribe(resp => {
      this.ressources = resp;
    }, error => console.log(error));
  }

  public listO() {
    this.ressourceMaterielleService.listO().subscribe(resp => {
      this.ressources = resp;
    }, error => console.log(error));
  }

  public delete(id: number) {
    this.ressourceMaterielleService.delete(id).subscribe(resp => {
      this.list();
    });
  }

 public somme() {
    this.calcul = 0;
    for (let i = 0; i < this.ressources.length; i++) {
      this.calcul = this.ressources[i].coutUtilisation + this.calcul;
    }
    return this.calcul;
  }

  testNom() {
    return this.ressources.filter(c => c.type.indexOf(this.value) !== -1);
  }
}

