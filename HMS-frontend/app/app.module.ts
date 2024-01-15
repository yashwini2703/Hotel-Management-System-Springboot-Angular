import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { CityComponent } from './home/city/city.component';
import { HotelComponent } from './hotel/hotel.component';
import { HotelListComponent } from './hotel/hotel-list/hotel-list.component';
import { CreateHotelComponent } from './hotel/create-hotel/create-hotel.component';
import { UpdateHotelComponent } from './hotel/update-hotel/update-hotel.component';
import { HotelDetailsComponent } from './hotel/hotel-details/hotel-details.component';
import { HomeAdminComponent } from './home/home-admin/home-admin.component';
import { HotelDetailsCityComponent } from './hotel/hotel-details-city/hotel-details-city.component';
import { ReservationComponent } from './reservation/reservation.component';
import { ReservationListComponent } from './reservation/reservation-list/reservation-list.component';
import { ReservationdoneComponent } from './reservation/reservationdone/reservationdone.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    CityComponent,
    HotelComponent,
    HotelListComponent,
    CreateHotelComponent,
    UpdateHotelComponent,
    HotelDetailsComponent,
    HomeAdminComponent,
    HotelDetailsCityComponent,
    ReservationComponent,
    ReservationListComponent,
    ReservationdoneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
