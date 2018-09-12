import {Component, OnInit} from '@angular/core';
import {RessourceHumaine} from '../model/ressource-humaine';
import {RessourceHumaineService} from '../service/RessourceHumaine/ressource-humaine.service';

@Component({
  selector: 'app-ressource-humaine',
  templateUrl: './ressource-humaine.component.html',
  styleUrls: ['./ressource-humaine.component.css']
})
export class RessourceHumaineComponent implements OnInit {

  ressourceHumaines: RessourceHumaine[];

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

  public delete(id: number) {
    if (confirm('Etes-vous sûr de vouloir supprimer cette ressource humaine?')) {
      this.ressourceHumaineService.delete(id).subscribe(resp => {
        this.list();
      });
    }
  }
}
