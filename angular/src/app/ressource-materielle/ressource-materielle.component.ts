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
}
