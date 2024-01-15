package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel addHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(int id) throws ResourceNotFoundException {
		Optional<Hotel> option= hotelRepository.findById(id);
		if(option.isPresent()) {
			return hotelRepository.findById(id).get();
		}
		else {
			throw new ResourceNotFoundException("Hotel with id "+id+" is not available in database");
		}
		
	}

	@Override
	public Hotel updateHotelById(Hotel hotel) {
	    // Retrieve the existing hotel from the repository by its hid
	    Optional<Hotel> optionalHotel = hotelRepository.findById(hotel.getHid());

	    if (optionalHotel.isPresent()) {
	        // Hotel found, update its properties
	        Hotel _hotel = optionalHotel.get();
	        _hotel.setHotelname(hotel.getHotelname());
	        _hotel.setCity(hotel.getCity());

	        // Save the updated hotel entity back to the repository
	        return hotelRepository.save(_hotel);
	    } else {
	        // Hotel not found, handle accordingly (throw an exception, return a default value, etc.)
	        throw new ResourceNotFoundException("Hotel not found with ID: " + hotel.getHid());
	    }
	}


	@Override
	public String deleteHotel(int id) throws ResourceNotFoundException {
		Optional<Hotel> option= hotelRepository.findById(id);
		if(option.isPresent()) {
			hotelRepository.deleteById(id);
			return "Hotel Booking is cancelled";
		}
		else {
			throw new ResourceNotFoundException("Hotel with id "+id+" is not available in database");
		}
		
	}
	 public List<Hotel> getHotelsByCity(String city) {
	        return hotelRepository.findByCity(city);
	    }
}
