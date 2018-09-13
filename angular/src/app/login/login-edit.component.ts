import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {UserService} from '../service/user.service';
import {User} from '../model/user';
import {Role} from '../model/role.enum';
import {UserRole} from '../model/user-role';

@Component({
  selector: 'app-login-edit',
  templateUrl: './login-edit.component.html',
  styleUrls: ['./login-edit.component.css']
})
export class LoginEditComponent implements OnInit {

  constructor(private userService: UserService, private ar: ActivatedRoute, private router: Router) {
  }

  user: User;
  role: Role;
  userRole: UserRole;

  ngOnInit() {
    this.user = new User();
    this.userRole = new UserRole();
  }

  public save() {
    this.userRole.role = this.role;
    this.user.roles = new Array<UserRole>(this.userRole);
    this.userService.save(this.user).subscribe(resp => {
      this.router.navigate(['/home']);
    });
  }
}
