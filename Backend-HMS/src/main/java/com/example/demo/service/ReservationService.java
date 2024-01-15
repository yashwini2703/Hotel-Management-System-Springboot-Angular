package com.example.demo.service;

import java.util.List;

import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.entity.Reservation;


public interface ReservationService {
	   public Reservation addReservation(Reservation reservation);
		public  List<Reservation> getAllReservation();
		 public  Reservation getReservationById(Integer id) throws ResourceNotFoundException  ;
		  public   Reservation updateReservationById(Reservation reservation);
		   public String deleteReservationById(Integer id) throws ResourceNotFoundException;
		  public Reservation getLatestReservation() throws ResourceNotFoundException;
}
