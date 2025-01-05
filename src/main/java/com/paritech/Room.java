package com.paritech;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="room")
public class Room {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "room_number")
	private String roomnumber;
	private String type;
	private double pricePerNight;
	private boolean available;
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomnumber() {
		return roomnumber;
	}
	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public boolean isAvailble() {
		return available;
	}
	public void setAvailble(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Room{" +
				"id=" + id +
				", type='" + type + '\''+
				", pricePerNight=" + pricePerNight+
				", available=" + available +
				", roomnumber=" + roomnumber+
				'}';
				
	}
	
		
}