import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotelDetailsCityComponent } from './hotel-details-city.component';

describe('HotelDetailsCityComponent', () => {
  let component: HotelDetailsCityComponent;
  let fixture: ComponentFixture<HotelDetailsCityComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HotelDetailsCityComponent]
    });
    fixture = TestBed.createComponent(HotelDetailsCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
