import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HotelService } from 'src/app/Service/hotel.service';
import { Hotel } from 'src/app/Class/hotel';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent {
  image1='../assets/mumbai.jpg'
  image2='../assets/pune.jpg'
  image3='../assets/jaipur.jfif'
  image4='../assets/bengluru.jpg'
  image5='../assets/Chennai.jpg'
  image6='../assets/delhi.jpg'

  city: string = '';
  hotels: Hotel[] = [];

  constructor(private router: Router, private hotelService: HotelService) {}


  Mumbai() {
    // Navigate to the hotel details page with the city parameter
    this.router.navigate(['/hotel-details-city'], { queryParams: { city: "Mumbai" } });
  }
  Pune() {
    // Navigate to the hotel details page with the city parameter
    this.router.navigate(['/hotel-details-city'], { queryParams: { city: "Pune" } });
  }
  Bengluru() {
    // Navigate to the hotel details page with the city parameter
    this.router.navigate(['/hotel-details-city'], { queryParams: { city: "Bengalore" } });
  }
  Delhi() {
    // Navigate to the hotel details page with the city parameter
    this.router.navigate(['/hotel-details-city'], { queryParams: { city: "Delhi" } });
  }
  Jaipur() {
    // Navigate to the hotel details page with the city parameter
    this.router.navigate(['/hotel-details-city'], { queryParams: { city: "Jaipur"} });
  }
  Chennai() {
    // Navigate to the hotel details page with the city parameter
    this.router.navigate(['/hotel-details-city'], { queryParams: { city: "Chennai" } });
  }
  
}
