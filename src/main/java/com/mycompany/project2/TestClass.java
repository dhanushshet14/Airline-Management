/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.project2;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author justi
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String destination;

    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public String getFlightNumber() {
        
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }
}

class Passenger {
    private String name;
    private String ticketNumber;

    public Passenger(String name, String ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
    }

    public String getName() {
        return name;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
}

class Airport {
    private ArrayList<Flight> flights;
    private ArrayList<Passenger> passengers;

    public Airport() {
        flights = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Flight added: " + flight.getFlightNumber() + " to " + flight.getDestination());
    }

    public void removeFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flights.remove(flight);
                System.out.println("Flight removed: " + flightNumber);
                return;
            }
        }
        System.out.println("Flight not found with number: " + flightNumber);
    }

    public void displayFlights() {
        try {
            FileWriter writer = new FileWriter("flights.txt");

            if (flights.isEmpty()) {
                System.out.println("No available flights");
                writer.write("No available flights");
            } else {
                writer.write("Available Flights at Airport:\n");
                for (Flight flight : flights) {
                    System.out.println("Flight Number: " + flight.getFlightNumber() + ", Destination: " + flight.getDestination() + "\n");
                    writer.write("Flight Number: " + flight.getFlightNumber() + ", Destination: " + flight.getDestination() + "\n");
                }
            }

            writer.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void bookFlight(Passenger passenger, String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                passengers.add(passenger);
                System.out.println("Booking successful for " + passenger.getName() + " on Flight " + flightNumber);
                return;
            }
        }
        System.out.println("Flight not found with number: " + flightNumber);
    }

    public void displayBookedFlights(String passengerName) {
        System.out.println("Booked Flights for " + passengerName + ":");
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(passengerName)) {
                System.out.println("Ticket Number: " + passenger.getTicketNumber());
            }
        }
    }

    public void cancelFlight(String ticketNumber) {
        for (Passenger passenger : passengers) {
            if (passenger.getTicketNumber().equals(ticketNumber)) {
                passengers.remove(passenger);
                System.out.println("Booking canceled for Ticket Number: " + ticketNumber);
                return;
            }
        }
        System.out.println("Booking not found with Ticket Number: " + ticketNumber);
    }

    public void displayPassengerDetails(String passengerName) {
        System.out.println("Passenger Details for " + passengerName + ":");
        for (Passenger passenger : passengers) {
            if (passenger.getName().equals(passengerName)) {
                System.out.println("Ticket Number: " + passenger.getTicketNumber());
            }
        }
    }
}

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airport airport = new Airport();

        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Add Flight to Airport");
                System.out.println("2. Remove Flight from Airport");
                System.out.println("3. Display Available Flights at Airport");
                System.out.println("4. Book Flight");
                System.out.println("5. Display Booked Flights for Passenger");
                System.out.println("6. Cancel Flight Booking");
                System.out.println("7. Display Passenger Details");
                System.out.println("8. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Flight Number: ");
                        String flightNumber = scanner.next();
                        System.out.print("Enter Destination: ");
                        String destination = scanner.next();
                        airport.addFlight(new Flight(flightNumber, destination));
                        break;
                    case 2:
                        System.out.print("Enter Flight Number to Remove: ");
                        String removeFlightNumber = scanner.next();
                        airport.removeFlight(removeFlightNumber);
                        break;
                    case 3:
                        airport.displayFlights();
                        break;
                    case 4:
                         System.out.println("Enter your passport details:");
                        System.out.print("Enter Passenger Name: ");
                        String passengerName = scanner.next();
                         System.out.print("Enter Passport Number: ");
                        String passportNum= scanner.next();
                        System.out.print("Enter Ticket Number: ");
                        String ticketNumber = scanner.next();
                        System.out.print("Enter Flight Number to Book: ");
                        String bookFlightNumber = scanner.next();
                        airport.bookFlight(new Passenger(passengerName, ticketNumber), bookFlightNumber);
                        break;
                    case 5:
                        System.out.print("Enter Passenger Name to Display Booked Flights: ");
                        String displayPassengerName = scanner.next();
                        airport.displayBookedFlights(displayPassengerName);
                        break;
                    case 6:
                        System.out.print("Enter Ticket Number to Cancel Booking: ");
                        String cancelTicketNumber = scanner.next();
                        airport.cancelFlight(cancelTicketNumber);
                        break;
                    case 7:
                        System.out.print("Enter Passenger Name to Display Details: ");
                        String displayDetailsPassengerName = scanner.next();
                        airport.displayPassengerDetails(displayDetailsPassengerName);
                        break;
                    case 8:
                        System.out.println("Exiting program.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid value.");
                scanner.nextLine();
            }
            
        }
    }
}