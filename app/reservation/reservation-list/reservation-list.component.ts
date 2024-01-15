import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Reservation } from 'src/app/Class/reservation';
import { ReservationService } from 'src/app/Service/reservation.service';

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent {
  reservation: Reservation[] = [];
  constructor(private reservationService:ReservationService, private router: Router){}
  ngOnInit():void{
   this.getReservations();
  }
  private getReservations() {
    this.reservationService.getAllReservations().subscribe(data=>{
      this.reservation=data;
    });}

    deleteReservation(rsvid: number) {
      const confirmed = window.confirm("Are you sure you want to delete the hotel?");
      if (confirmed) {
        this.reservationService.deleteReservation(rsvid).subscribe(data => {
          console.log(data);
          this.getReservations();
        });
      } else {
        // User clicked "cancel" or closed the alert, so we skip the deletion.
      }
    }
    
}
