import { Component } from '@angular/core';
import { Hotel } from '../Class/hotel';
import { HotelService } from '../Service/hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  image1="../assets/hotelroom2.jpg"
  image2="../assets/hotelroom.jpg"
  search="../assets/search1.png"

  city: string = '';
  hotels: Hotel[] = [];

  constructor(private hotelService: HotelService, private router :Router) { }

  searchHotelsByCity() {
    if (this.city.trim() !== '') {
      this.hotelService.getHotelsByCity(this.city).subscribe(
        data => {
          this.hotels = data;
        },
        error => {
          console.error('Error fetching hotels:', error);
        }
      );
    }
  }
  searchHotels() {
    // Navigate to the hotel details page with the city parameter
    this.router.navigate(['/hotel-details-city'], { queryParams: { city: this.city } });
  }
}
