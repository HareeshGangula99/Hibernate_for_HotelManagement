package com.paritech;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")

public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	@ManyToOne
	@JoinColumn(name = "cusomer_id")
	
	private Customer customer;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private double totalPrice;
	
//	Getters and setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double calculateTotalPrice() {
		long numberOfNights = ChronoUnit.DAYS.between(checkIn, checkOut);
		return numberOfNights * room.getPricePerNight();
		
	}
	@Override
	public String toString() {
		return "Booking{" +
				", totalPrice="+totalPrice+
				"}";
				
	}
	
}
