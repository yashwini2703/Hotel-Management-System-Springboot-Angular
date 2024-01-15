package com.example.demo.service;

import java.util.List;

import com.example.demo.ExceptionHandling.ResourceNotFoundException;
import com.example.demo.entity.Hotel;

public interface HotelService {
	public Hotel addHotel(Hotel hotel);
    public  List<Hotel> getAllHotel(Hotel hotel);
    public  Hotel  getHotelById(int id) throws ResourceNotFoundException;
    public Hotel updateHotelById(Hotel hotel);
    public String deleteHotel(int id) throws ResourceNotFoundException;
    public List<Hotel> getHotelsByCity(String city);
}
