import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username:string = '';
  password:string = '';
  message = "Signin pls..";
  constructor( private router:Router ){}

  loginEmployee(form: NgForm){
   
     if( this.username=="Ashwini" && this.password=='12345'){
        this.router.navigate(['home']);
        alert("Login Successful");}
     else if( this.username=="Admin" && this.password=='12345' ) {
        this.router.navigate(['home-admin']);
        alert("Login Successful as Admin");
     }  
        
      else
{
        this.router.navigate(['/']);
        alert("Sorry!! Invalid Credentials...");
        form.resetForm();
     }
    
  }

}
