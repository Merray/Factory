import {Component, OnInit} from '@angular/core';
import {RessourceHumaine} from '../model/ressource-humaine';
import {RessourceHumaineService} from '../service/RessourceHumaine/ressource-humaine.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-ressource-humaine-edit',
  templateUrl: './ressource-humaine-edit.component.html',
  styleUrls: ['./ressource-humaine-edit.component.css']
})
export class RessourceHumaineEditComponent implements OnInit {

  ressourceHumaine: RessourceHumaine;

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

  public save() {
  }
}
