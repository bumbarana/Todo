import { Component, OnInit, HostListener, ViewEncapsulation } from '@angular/core';
import { LoginService } from 'src/app/services/login-service/login.service';
import { Router } from '@angular/router';
import { AuthDataStorage } from 'src/app/security/auth-data-storage';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  // encapsulation: ViewEncapsulation.None
   
})
export class LoginComponent implements OnInit {

  user: any;
  error = '';
  email: string;
  password: string;

  constructor(private service: LoginService,
    private router: Router,
    private authDataStorage: AuthDataStorage
  ) { }


  ngOnInit() {
  }

  logIn(): void {
      console.log(this.email);
    this.service.login(this.email, this.password).subscribe(
      response => {
        let jwtToken = response.headers.get('Authorization');
        this.authDataStorage.setJwtToken(jwtToken);
        this.service.getLoggedUser().subscribe(
          data => {
            let loggedUser: any = data;
            this.authDataStorage.setLoggedUser(loggedUser);
            console.log(loggedUser);
            this.router.navigate(["/home"]);
          },
          err => {
            this.error = err;
          }
        );
      },
      err => {
        this.error = err;
      });
  }

  @HostListener('document:keypress', ['$event'])
  keyEvent(event: KeyboardEvent) {
    if (event.keyCode === 13) {
      this.logIn();
    }
  }

}