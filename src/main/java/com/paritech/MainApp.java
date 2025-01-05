package com.paritech;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		HotelDAO hotelDAO = new HotelDAO();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("\n--- Hotel Booking System");
			System.out.println("1. Add Room");
			System.out.println("2. Add Customer");
			System.out.println("3. Book Room");
			System.out.println("4. View Availble Rooms");
			System.out.println("5. View All Bookings");
			System.out.println("6. Exit");
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter room number: ");
				String roomNumber=scanner.next();
				System.out.println("Enter room type");
				String type = scanner.next();
				System.out.println("Enter price per night: ");
				double price=scanner.nextDouble();
				Room room = new Room();
				room.setRoomnumber(roomNumber);
				room.setType(type);
				room.setPricePerNight(price);
				room.setAvailble(true);
				hotelDAO.addRoom(room);
				System.out.println("Room added successfully!");
				break;
			case 2:
				System.out.println("Enter customer name: ");
				String name = scanner.next();
				System.out.println("Enter E-mail: ");
				String email = scanner.next();
				System.out.println("Enter phone: ");
				String phone= scanner.next();
				Customer customer = new Customer();
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				hotelDAO.addcustomer(customer);
				System.out.println("Customer added successfully");
				break;
			case 3:
				System.out.println("Available rooms: ");
				hotelDAO.getAvailableRooms().forEach(System.out::println);
				System.out.println("Enter room ID to book");
				int roomId = scanner.nextInt();
				System.out.println("Enter customer ID: ");
				int customerId = scanner.nextInt();
				System.out.println("Enter check-in date(yyyy-mm-dd): " );
				String checkInDate = scanner.next();
				System.out.println("Enter check-out date (yyyy-mm-dd): ");
				String checkOutDate = scanner.next();
				Booking booking = new Booking();
				booking.setRoom(hotelDAO.getRoomById(roomId));
				booking.setCustomer(hotelDAO.getCustomerById(customerId));

				
				LocalDate checkIn = LocalDate.parse(checkInDate);
				LocalDate checkOut = LocalDate.parse(checkOutDate);
				
				booking.setCheckIn(checkIn);
				booking.setCheckOut(checkOut);
				booking.setTotalPrice(booking.calculateTotalPrice());
				hotelDAO.addBooking(booking);
				System.out.println("Room booked successfully");
				break;
			case 4:
				hotelDAO.getAvailableRooms().forEach(System.out::println);
				break;
			case 5:
				hotelDAO.getAllBookings().forEach(System.out::println);
				break;
			case 6:
				System.out.println("Exiting...");
				scanner.close();
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
