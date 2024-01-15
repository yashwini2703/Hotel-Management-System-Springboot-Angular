import { Component } from '@angular/core';
import { Hotel } from '../../Class/hotel';
import { HotelService } from 'src/app/Service/hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-hotel',
  templateUrl: './create-hotel.component.html',
  styleUrls: ['./create-hotel.component.css']
})
export class CreateHotelComponent {
  hotel:Hotel = new Hotel();
  constructor(private hotelService:HotelService, 
        private router:Router){}

  saveHotel(){
    this.hotelService.createHotel(this.hotel).subscribe(data=>{
      console.log(data);
      this.goToHotelList();
    },
    error=>console.log(error));
  }

  goToHotelList(){
    this.router.navigate(['/hotels']);

  }
  onSubmit(){
    alert(this.hotel);
    console.log(this.hotel);
    this.saveHotel();
    this.router.navigate(['/home-admin'])
  }
}
