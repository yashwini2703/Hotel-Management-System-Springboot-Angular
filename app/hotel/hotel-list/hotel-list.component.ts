import { Component } from '@angular/core';
import { HotelService } from 'src/app/Service/hotel.service';
import { Hotel } from '../../Class/hotel';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hotel-list',
  templateUrl: './hotel-list.component.html',
  styleUrls: ['./hotel-list.component.css']
})
export class HotelListComponent {
   hotels: Hotel[] = [];
  constructor(private hotelService:HotelService, private router: Router){}
  ngOnInit():void{
   this.getHotels();
  }
  private getHotels() {
    this.hotelService.getHotelsList().subscribe(data=>{
      this.hotels=data;
    });}
    
  HotelDetails(hid: number){
    this.router.navigate(['hotel-details', hid]);
  }

  updateHotel(hid: number){
    this.router.navigate(['update-hotel', hid]);
  }
  deleteHotel(hid: number) {
    const confirmed = window.confirm("Are you sure you want to delete the hotel?");
    if (confirmed) {
      this.hotelService.deleteHotel(hid).subscribe(data => {
        console.log(data);
        this.getHotels();
      });
    } else {
      // User clicked "cancel" or closed the alert, so we skip the deletion.
    }
  }
  
}

