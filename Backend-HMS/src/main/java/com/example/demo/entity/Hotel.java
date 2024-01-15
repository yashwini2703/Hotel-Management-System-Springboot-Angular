package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer hid;

    @NotEmpty(message = "Hotel name cannot be empty")
    @Size(min = 3, max = 23, message = "Hotel name must be between 3 and 23 characters")
    @Column(name = "hotel_name")
    private String hotelname;
    
    @Column(name = "hotel_city")
    private String city;

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

    

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonIgnore    
//    private List<Room> rooms;
//    
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonIgnore    
//    private List<Guest> guest;
//    
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Reservation> reservation;
//    
}
