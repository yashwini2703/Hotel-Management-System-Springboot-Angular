package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    

    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation) {
    	return reservationService.addReservation(reservation);
    }
    @GetMapping("/reservations")
    public List<Reservation> getAllReservation(){
    	return reservationService.getAllReservation();
    }
    @GetMapping("/reservations/latest")
    public ResponseEntity<Reservation> getLatestReservation() {
        try {
            Reservation reservation = reservationService.getLatestReservation();
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("reservation/{id}")
    public Reservation getReservationById(@PathVariable int id) throws ResourceNotFoundException{
    	return reservationService.getReservationById(id);
    }

    @DeleteMapping("/reservations/{id}")
    public String deleteReservation(@PathVariable int id) throws ResourceNotFoundException
    {
    	return reservationService.deleteReservationById(id);
    }

    @PutMapping("/reservations")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
    	return reservationService.updateReservationById(reservation);
    }
}
