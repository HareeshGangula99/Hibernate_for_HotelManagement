package com.paritech;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HotelDAO {
	private SessionFactory sessionFactory;
	
	public HotelDAO() {
		sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Room.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Booking.class)
				.buildSessionFactory();
				
	}
	public Room getRoomById(int id) {
		try(Session session = sessionFactory.getCurrentSession()){
			session.beginTransaction();
			Room room=session.get(Room.class, id);
			session.getTransaction().commit();
			return room;
			
		}
	}
	public Customer getCustomerById(int id) {
		try(Session session = sessionFactory.getCurrentSession()){
			session.beginTransaction();
			Customer customer=session.get(Customer.class, id);
			session.getTransaction().commit();
			return customer;
			
		}
	}
	
	public void addRoom(Room room) {
		try(Session session = sessionFactory.getCurrentSession()){
			session.beginTransaction();
			session.save(room);
			session.getTransaction().commit();
		}
	}
	
	public void addcustomer(Customer customer) {
		try(Session session = sessionFactory.getCurrentSession()){
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
		}
	}
	
	public void addBooking(Booking booking) {
		try(Session session = sessionFactory.getCurrentSession()){
			session.beginTransaction();
			session.save(booking);
			
//			Update room availability
			Room room=session.get(Room.class, booking.getRoom().getId());
			room.setAvailble(false);
			session.update(room);
			session.getTransaction().commit();
			
		}
	}
	
	public List<Room> getAvailableRooms(){
		try(Session session = sessionFactory.getCurrentSession()){
			session.beginTransaction();
			List<Room> rooms = session.createQuery("From Room where available = true", Room.class).list();
			session.getTransaction().commit();
			return rooms;
		}
	}
//	LocalDate checkIn = LocalDate.parse(checkInDate);
	public List<Booking>getAllBookings(){
		try(Session session = sessionFactory.getCurrentSession()){
			session.beginTransaction();
			List<Booking> bookings = session.createQuery("from Booking", Booking.class).list();
			session.getTransaction().commit();
			return bookings;
		}
	}
}
