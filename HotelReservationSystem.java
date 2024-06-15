


package code_alpha;

import java.util.*;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("FiveStar Hotel");
        System.out.println("Welcome to " + hotel.getName());
        System.out.print("Enter room category (Standard/Deluxe/Suite): ");
        String category = scanner.nextLine();
        
        switch (category.toLowerCase()) {
            case "standard":
                handleRoomCategory(hotel, "Standard", scanner);
                break;
            case "deluxe":
                handleRoomCategory(hotel, "Deluxe", scanner);
                break;
            case "suite":
                handleRoomCategory(hotel, "Suite", scanner);
                break;
            default:
                System.out.println("Invalid category entered.");
                break;
        }

        scanner.close();
    }

    private static void handleRoomCategory(Hotel hotel, String category, Scanner scanner) {
        List<Room> availableRooms = hotel.searchAvailableRooms(category);
        
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms in the " + category + " category.");
        } else {
            System.out.println("Available " + category + " rooms:");
            for (Room room : availableRooms) {
                System.out.println("Room number: " + room.getRoomNumber());
            }
            System.out.print("Enter room number to make a reservation: ");
            int roomNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            Room selectedRoom = null;
            for (Room room : availableRooms) {
                if (room.getRoomNumber() == roomNumber) {
                    selectedRoom = room;
                    break;
                }
            }
            if (selectedRoom != null) {
                hotel.makeReservation(selectedRoom);
                hotel.viewBookingDetails(selectedRoom);

                // Simulate payment process
                System.out.print("Enter number of nights to stay: ");
                int numberOfNights = scanner.nextInt();
                hotel.simulatePayment(selectedRoom, numberOfNights);
            } else {
                System.out.println("Invalid room number.");
            }
        }
    }
}


