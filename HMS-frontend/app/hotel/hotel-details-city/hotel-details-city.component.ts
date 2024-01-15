import { Component } from '@angular/core';
import { Hotel } from '../../Class/hotel';
import { HotelService } from 'src/app/Service/hotel.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-hotel-details-city',
  templateUrl: './hotel-details-city.component.html',
  styleUrls: ['./hotel-details-city.component.css']
})
export class HotelDetailsCityComponent {
  city: string = '';
  hotels: Hotel[] = [];

  constructor(private hotelService: HotelService, private router: Router,private route: ActivatedRoute) { }

  
  ngOnInit(): void {
    // Retrieve the city parameter from the URL
    this.route.queryParams.subscribe((params) => {
      this.city = params['city'];
      this.loadHotels();
    });
  }

  loadHotels() {
    // Fetch hotels based on the selected city
    this.hotelService.getHotelsByCity(this.city).subscribe(
      (data) => {
        this.hotels = data;
      },
      (error) => {
        console.error('Error fetching hotels:', error);
      }
    );
  }
  HotelDetails(hid: number){
    this.router.navigate(['hotel-details', hid]);
  }
}

