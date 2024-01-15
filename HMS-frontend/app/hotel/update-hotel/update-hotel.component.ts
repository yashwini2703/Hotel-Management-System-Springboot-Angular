import { Component } from '@angular/core';
import { Hotel } from '../../Class/hotel';
import { HotelService } from 'src/app/Service/hotel.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-hotel',
  templateUrl: './update-hotel.component.html',
  styleUrls: ['./update-hotel.component.css']
})
export class UpdateHotelComponent {

  hid!: number;
  hotel: Hotel = new Hotel();
  constructor(private hotelService: HotelService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.hid = this.route.snapshot.params['hid'];

    this.hotelService.getHotelById(this.hid).subscribe(data => {
      this.hotel = data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.hotelService.updateHotel(this.hid, this.hotel).subscribe( data =>{
      this.goToHotelList();
    }
    , error => console.log(error));
    this.router.navigate(['/home-admin'])
  }

  goToHotelList(){
    this.router.navigate(['/hotels']);
  }
}
