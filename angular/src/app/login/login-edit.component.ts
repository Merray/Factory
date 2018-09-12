import { Component, OnInit } from '@angular/core';
import {RessourceMaterielleService} from '../service/ressource-materielle.service';
import {ActivatedRoute, Router} from '@angular/router';
import {RessourceMaterielle} from '../model/ressourceMaterielle';
import {Ordinateur} from '../model/RessourceMaterielleHeritage/ordinateur';
import {VideoProjecteur} from '../model/RessourceMaterielleHeritage/videoProjecteur';
import {Salle} from '../model/RessourceMaterielleHeritage/salle';
import {UserService} from '../service/user.service';
import {User} from '../model/user';

@Component({
  selector: 'app-login-edit',
  templateUrl: './login-edit.component.html',
  styleUrls: ['./login-edit.component.css']
})
export class LoginEditComponent implements OnInit {

  constructor(private userService: UserService, private ar: ActivatedRoute, private router: Router) {
  }

  user: User;

  ngOnInit() {

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
      this.video_projecteur = this.ressourceMaterielle;
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

}
