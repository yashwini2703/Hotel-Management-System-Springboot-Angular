import { Component } from '@angular/core';
import { Hotel } from '../../Class/hotel';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { HotelService } from 'src/app/Service/hotel.service';

@Component({
  selector: 'app-hotel-details',
  templateUrl: './hotel-details.component.html',
  styleUrls: ['./hotel-details.component.css']
})
export class HotelDetailsComponent {

  hid!: number;
  hotel!: Hotel;
  hotelsInCity!: Hotel[];
  constructor(private route: ActivatedRoute, private hotelService: HotelService, private router:Router) { }

  ngOnInit(): void {
    this.hid = this.route.snapshot.params['hid'];

    this.hotel = new Hotel();
    this.hotelService.getHotelById(this.hid).subscribe( data => {
      this.hotel = data;
    });
  }
  getForm(){
    this.router.navigate(['reservation']);
  }
}
