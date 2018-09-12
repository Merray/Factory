import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Cursus} from '../model/cursus';
import {CursusService} from '../service/cursus/cursus.service';
import {RessourceMaterielle} from '../model/ressourceMaterielle';

@Component({
  selector: 'app-cursus-edit',
  templateUrl: './cursus-edit.component.html',
  styleUrls: ['./cursus-edit.component.css']
})
export class CursusEditComponent implements OnInit {

  constructor( private cursusSercive: CursusService, private ar: ActivatedRoute, private router: Router) {
  }

  cursus: Cursus;

  ngOnInit() {
    this.ar.params.subscribe(params => {
      if (params.id) {
        this.cursusSercive.findById(params.id).subscribe(resp => {
          this.cursus = resp;
        });
      } else {
        this.cursus = new Cursus();

      }
    });
  }

  public save() {
    this.cursusSercive.save(this.cursus).subscribe(resp => {
      this.router.navigate([`/cursus`]);
    });
  }

}
