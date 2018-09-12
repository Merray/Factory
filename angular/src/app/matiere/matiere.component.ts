import {Component, OnInit} from '@angular/core';
import {MatiereService} from '../service/matiere/matiere.service';
import {Matiere} from '../model/matiere';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.css']
})
export class MatiereComponent implements OnInit {

  matieres: Matiere[];

  constructor(private matiereService: MatiereService) {
  }

  ngOnInit() {
    this.list();
  }

  public list() {
    this.matiereService.list().subscribe(resp => {
      this.matieres = resp;
    }, error => {
      console.log(error);
    });
  }

  public delete(id: number) {
    if (confirm('Etes-vous sûr de vouloir supprimer cette matiere ?')) {
      this.matiereService.delete(id).subscribe(resp => {
        this.list();
      });
    }
  }
}
