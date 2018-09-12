import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

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

  public save() {
    this.userService.save(this.user).subscribe(resp => {
      this.router.navigate(['/home']);
    });
  }
}
