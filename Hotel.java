package code_alpha;


import java.util.*;

public class Hotel {
    private String name;
    private List<Room> rooms;
    private Map<Integer, Double> roomRates; // Map to store room rates

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.roomRates = new HashMap<>();
        initializeRooms();
        initializeRoomRates(); // Initialize room rates
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));
    }

    private void initializeRoomRates() {
        roomRates.put(101, 100.0); // Setting room rates for each room
        roomRates.put(102, 100.0);
        roomRates.put(201, 150.0);
        roomRates.put(202, 150.0);
        roomRates.put(301, 200.0);
    }

    public List<Room> searchAvailableRooms(String category) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void makeReservation(Room room) {
        room.setAvailable(false);
        System.out.println("Reservation made for room number " + room.getRoomNumber());
    }

    public void viewBookingDetails(Room room) {
        System.out.println("Booking details for room number " + room.getRoomNumber() + ":");
        System.out.println("Category: " + room.getCategory());
        System.out.println("Status: " + (room.isAvailable() ? "Available" : "Booked"));
        System.out.println("Rate per night: $" + roomRates.get(room.getRoomNumber())); // Display room rate
    }

    public void simulatePayment(Room room, int numberOfNights) {
        double totalAmount = roomRates.get(room.getRoomNumber()) * numberOfNights;
        System.out.println("Payment processed successfully:");
        System.out.println("Total Amount: $" + totalAmount);
    }

    public String getName() {
        return name;
    }
}
