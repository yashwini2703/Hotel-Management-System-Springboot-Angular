package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.HotelRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService{
@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	HotelRepository hotelRepository; 
	
	
	
	@Override
	public Reservation addReservation(Reservation reservation) {
	    Hotel hotel = reservation.getHotel(); 
	    return reservationRepository.save(reservation);
	}

//	@Override
//	public Reservation addReservation(Reservation reservation) {
//	    Integer hid = reservation.getHid();
//	    
//	    if (hid == null) {
//	        // Handle the case where hid is null (throw an exception, set a default value, etc.)
//	        // For example, you might throw a RuntimeException:
//	        throw new IllegalArgumentException("Hotel ID (hid) must not be null");
//	    }
//
//	    Hotel hotel = hotelRepository.findById(hid).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hid));
//	    reservation.setHotel(hotel);
//
//	    return reservationRepository.save(reservation);
//	}


	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return reservationRepository.findAll();
	}

	@Override
	public Reservation getReservationById(Integer id) throws ResourceNotFoundException {
		Optional<Reservation> option=reservationRepository.findById(id);
		if(option.isPresent()) {				
		    return reservationRepository.findById(id).get();
	}
		else {
			throw new ResourceNotFoundException("Reservation Not Available In Database");
		}
		
	}
	
	@Override
	public Reservation getLatestReservation() throws ResourceNotFoundException {
	    List<Reservation> reservations = reservationRepository.findAll(Sort.by(Sort.Direction.DESC, "checkInDate"));

	    if (reservations.isEmpty()) {
	        throw new ResourceNotFoundException("No reservations found");
	    }

	    return reservations.get(0);
	}

@Override
public Reservation updateReservationById(Reservation reservation) {
	// TODO Auto-generated method stub
	Reservation _r=reservationRepository.findById(reservation.getRsvid()).get();
	_r.setFirstName(reservation.getFirstName());
	_r.setLastName(reservation.getLastName());
	_r.setEmailAddress(reservation.getEmailAddress());
	_r.setPhoneNumber(reservation.getPhoneNumber());
	_r.setAddress(reservation.getAddress());
	_r.setAdults(reservation.getAdults());
	_r.setChildrens(reservation.getChildrens());
	_r.setState(reservation.getState());
	_r.setCity(reservation.getCity());
	_r.setCheckInDate(reservation.getCheckInDate());
	_r.setCheckOutDate(reservation.getCheckOutDate());
	return reservationRepository.save(_r);
}
@Override
public String deleteReservationById(Integer id) throws ResourceNotFoundException {
	Optional<Reservation> option=reservationRepository.findById(id);
	if(option.isPresent()) {	
		reservationRepository.deleteById(id);
		return "Reservation has be cancelled";
}
	else {
		throw new ResourceNotFoundException("Reservation is not Available In Database");
	}
	
	
}


}

