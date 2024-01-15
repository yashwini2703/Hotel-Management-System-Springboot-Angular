import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationdoneComponent } from './reservationdone.component';

describe('ReservationdoneComponent', () => {
  let component: ReservationdoneComponent;
  let fixture: ComponentFixture<ReservationdoneComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ReservationdoneComponent]
    });
    fixture = TestBed.createComponent(ReservationdoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
