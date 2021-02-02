import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatInputModule, MatButtonModule, MatCommonModule, MatDividerModule, MatListModule, MatNavList, MatMenuModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { AuthDataStorage } from '../security/auth-data-storage';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule,
    MatInputModule,
    FormsModule,
    CommonModule,
    MatButtonModule,
    ToastrModule.forRoot(),
    MatDividerModule,
    MatListModule,
    MatMenuModule
  ],
  exports:[
    ToastrModule
  ],
  providers:[
    AuthDataStorage
  ]
})
export class SharedModule { }
