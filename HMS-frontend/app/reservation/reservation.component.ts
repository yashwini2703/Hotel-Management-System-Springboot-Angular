import { Component } from '@angular/core';
import { Hotel } from '../Class/hotel';
import { Reservation } from '../Class/reservation';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReservationService } from '../Service/reservation.service';
import { HotelService } from '../Service/hotel.service';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent {
  reservation: Reservation = new Reservation();
  reservations: Reservation[] = []; // Use an array to store multiple reservations
  hotels:Hotel[]=[];

  constructor(
    private reservationService: ReservationService,
    private router: Router,
    private hotelService: HotelService
  ) {}

  ngOnInit(): void {
    this.loadReservations();
    this.loadHotels(); // Add this line to fetch hotels when the component is initialized
  }

  loadReservations() {
    this.reservationService.getAllReservations().subscribe((reservations) => {
      this.reservations = reservations; // Assign the array of reservations
    });
  }

  saveReservation() {
    this.reservationService.createReservation(this.reservation).subscribe(
      (data) => {
        console.log(data);
        this.goToReservationList();
      },
      (error) => console.log(error)
    );
  }
  loadHotels() {
    this.hotelService.getHotelsList().subscribe(
      (data) => {
        this.hotels = data;
        console.log(this.hotels); // Log the hotels to the console
      },
      (error) => {
        console.error('Error fetching hotels:', error);
      }
    );
  }
  goToReservationList() {
    this.router.navigate(['/reservation-list']);
    this.router.navigate(['/done']);
  }

  onSubmit() {
    // You need to update this part based on your requirements
    alert(this.reservation);
    console.log(this.reservation);
    this.saveReservation();
    this.router.navigate(['/done']);
  }
}
