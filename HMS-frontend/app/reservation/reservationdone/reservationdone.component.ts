import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Reservation } from 'src/app/Class/reservation';
import { ReservationService } from 'src/app/Service/reservation.service';

@Component({
  selector: 'app-reservationdone',
  templateUrl: './reservationdone.component.html',
  styleUrls: ['./reservationdone.component.css']
})
export class ReservationdoneComponent {
  reservation!: Reservation;

  constructor(private reservationService: ReservationService) {}

  ngOnInit() {
    this.getLatestReservation();
  }

  private getLatestReservation() {
    this.reservationService.getLatestReservation().subscribe((reservation) => {
      this.reservation = reservation;
    });
  }
}
