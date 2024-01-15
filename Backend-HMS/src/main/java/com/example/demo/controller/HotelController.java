package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.demo.entity.Hotel;
import com.example.demo.repository.HotelRepository;
import com.example.demo.serviceImpl.HotelServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class HotelController {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private HotelServiceImpl hotelService;
	
	@GetMapping("/hotels")
	public List<Hotel> getAllHotels(){
		return hotelRepository.findAll();
	}
	
	@PostMapping("/hotels")
	public Hotel createHotel(@RequestBody Hotel hotel){
		return hotelRepository.save(hotel);
	}
	
	@GetMapping("/hotels/{hid}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable Integer hid) {
		Hotel hotel=hotelRepository.findById(hid).
				orElseThrow(() -> new ResourceNotFoundException("Hotel not exist with id: "+hid));
		return ResponseEntity.ok(hotel); 
	}
	
	@PutMapping("/hotels/{hid}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable Integer hid,@RequestBody Hotel hoteldetails){
		Hotel hotel=hotelRepository.findById(hid)
				.orElseThrow(() -> new ResourceNotFoundException ("Hotel not exist with id: "+hid));
		hotel.setHotelname(hoteldetails.getHotelname());
		hotel.setCity(hoteldetails.getCity());
		
		Hotel updatedHotel=hotelRepository.save(hotel);
		return ResponseEntity.ok(updatedHotel);
		
	}
	@GetMapping("/hotels/bycity/{city}")
    public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable String city) {
        List<Hotel> hotels = hotelService.getHotelsByCity(city);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

	
	@DeleteMapping("/hotels/{hid}")
	public ResponseEntity<Map<String,Boolean>> deleteHotel(@PathVariable Integer hid) 
	{
		Hotel hotel=hotelRepository.findById(hid)
				.orElseThrow(()-> new ResourceNotFoundException("Hotel not exist with id: "+hid));
		hotelRepository.delete(hotel);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

