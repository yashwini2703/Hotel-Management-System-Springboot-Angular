package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
		
	@Table(name = "reservations")
	public class Reservation {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer rsvid;
	    
	    @Column(name ="firstname")	    
	    private String FirstName;
	    
	    @Column(name ="lastname")	    
	    private String LastName;

	    @Column(name ="address")	    
	    private String Address;
	    
	    @Column(name ="city")	    
	    private String City;
	    
	    @Column(name ="state")	    
	    private String State;
	    
	    @Column(name ="phone")	    
	    private String PhoneNumber;
	    
	    @Column(name ="email")	    
	    private String EmailAddress;
	    
	    @Column(name = "check_in_date")
	    private LocalDate checkInDate;

	    @Column(name = "check_out_date")
	    private LocalDate checkOutDate;
	    
	    @Column(name ="roomtype")	    
	    private String RoomType;
	    
	    @Column(name ="adults")	    
	    private Integer Adults;
	    
	    @Column(name ="childrens")	    
	    private Integer Childrens;
	   
	    @ManyToOne
	    @JoinColumn(name = "hotel_id")
	    private Hotel hotel;

	  //  private Integer hid;

		public Integer getRsvid() {
			return rsvid;
		}

		public void setRsvid(Integer rsvid) {
			this.rsvid = rsvid;
		}

		

		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String firstName) {
			FirstName = firstName;
		}

		public String getLastName() {
			return LastName;
		}

		public void setLastName(String lastName) {
			LastName = lastName;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String getCity() {
			return City;
		}

		public void setCity(String city) {
			City = city;
		}

		public String getState() {
			return State;
		}

		public void setState(String state) {
			State = state;
		}

		public String getPhoneNumber() {
			return PhoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			PhoneNumber = phoneNumber;
		}

		public String getEmailAddress() {
			return EmailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			EmailAddress = emailAddress;
		}

		public String getRoomType() {
			return RoomType;
		}

		public void setRoomType(String roomType) {
			RoomType = roomType;
		}

		public Integer getAdults() {
			return Adults;
		}

		public void setAdults(Integer adults) {
			Adults = adults;
		}

		public Integer getChildrens() {
			return Childrens;
		}

		public void setChildrens(Integer childrens) {
			Childrens = childrens;
		}

		public LocalDate getCheckInDate() {
			return checkInDate;
		}

		public void setCheckInDate(LocalDate checkInDate) {
			this.checkInDate = checkInDate;
		}

		public LocalDate getCheckOutDate() {
			return checkOutDate;
		}

		public void setCheckOutDate(LocalDate checkOutDate) {
			this.checkOutDate = checkOutDate;
		}

		public Hotel getHotel() {
			return hotel;
		}

		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}

//		public Integer getHid() {
//			return hid;
//		}
//
//		public void setHid(Integer hid) {
//			this.hid = hid;
//		}

	    
	}
