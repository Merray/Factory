import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../service/auth/auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  authStatus: boolean;

  username: String = 'admin';

  password: String = 'admin';

  usernameAuth: String = '';

  passwordAuth: String = '';

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.authStatus = this.authService.isAuth;
  }

  onSignIn() {

    if ((this.username === this.usernameAuth) && (this.password === this.passwordAuth)) {
      this.authService.signIn().then(
        () => {
          console.log('Sign in successful!');
          this.authStatus = this.authService.isAuth;
          this.router.navigate(['home']);
        }
      );
    } else {
      alert('Mauvais identifiants');
    }
  }

  onSignOut() {
    this.authService.signOut();
    this.authStatus = this.authService.isAuth;
  }
}
