import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl} from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user-service/user.service';
import { User } from 'src/app/shared/data-types/User';


@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.scss']
})
export class RegisterUserComponent implements OnInit {

  firstname: string;
  lastname: string;
  email: string;
  password: string;


  constructor(private service: UserService, public router: Router) {}
  private userForm: FormGroup;

  ngOnInit() {
    
    this.userForm = new FormGroup({
      firstname: new FormControl(''),
      lastname: new FormControl(''),
      email: new FormControl(''),
      password: new FormControl('')
    })
  }

  register() {
    const user: User = this.getUser();
    this.service.registerUser(user)
        .subscribe(_ => {
          // this.toastr.success('Welcome to our application',"",{
          //   "closeButton": true,
          //   "positionClass": "toast-bottom-right",
          //   "tapToDismiss": true});
          // this.router.navigate(["/login"]);
        }, err => {
          // this.toastr.error(err.error.Message,"",{
          //   "closeButton": true,
          //   "positionClass": "toast-bottom-right",
          //   "tapToDismiss": true});
        });
  }

  getUser(): User {
    const user: User = new User();
    let currentUser = this.userForm.value;
    user.firstName = currentUser.firstname;
    user.lastName = currentUser.lastname;
    user.email = currentUser.email;
    user.password = currentUser.password;

    return user;
  }


}
