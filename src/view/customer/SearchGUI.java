package view.customer;

import controller.CustomerController;
import controller.HotelController;
import controller.ReservationController;
import controller.SearchController;
import model.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchGUI {

    private SearchController searchController;

    public SearchGUI() {
        Scanner scanner = new Scanner(System.in);
        HotelController hotelController = new HotelController();
        ReservationController reservationController = new ReservationController();
        CustomerController customerController = new CustomerController();
        this.searchController = new SearchController();

        Date startDate = Date.valueOf("2022-06-28");
        Date endDate = Date.valueOf("2022-07-01");
        String hotelAddress = "Istanbul";
        String hotelName = "";
        System.out.println("Results;");
        ArrayList<Hotel> hotelList = searchController.searchHotelBySeasonEnd(startDate, endDate, hotelAddress, hotelName);
        for (Hotel hotel : hotelList) {
            System.out.println(" + id:" + hotel.getId() + " name: " + hotel.getName());
        }

        System.out.print(" *Select (id): ");
        int hotelId = scanner.nextInt();

        Hotel hotel = hotelController.getFetch(hotelId);

        System.out.println(hotel.getName() + " address: " + hotel.getAddress() + " phone: " + hotel.getPhone());
        System.out.println("Hotel facilities; ");
        for (HotelFacility hotelFacility : hotelController.getHotelFacilityController().getAll(hotelId)) {
            System.out.println(" +" + hotelFacility.getFacilityName());
        }
        System.out.println("Hostel Types;");
        for (HostelType hostelType : hotelController.getHostelController().getAll(hotelId)) {
            System.out.println(" + id: " + hostelType.getId() + ", " + hostelType.getHostelType() + " price: " + hostelType.getPrice());
        }

        System.out.print(" *Select (id): ");
        int hostelId = scanner.nextInt();

        System.out.println("Room Types;");
        for (HotelRoomType hotelRoomType : hotelController.getHotelRoomTypeController().getAll(hotelId)) {
            System.out.println(" + id: " + hotelRoomType.getId() + ", " + hotelRoomType.getRoomType() + " price: " + hotelRoomType.getPrice());
        }

        System.out.print(" *Select (id): ");
        int roomId = scanner.nextInt();

        System.out.println("Your room features;");
        for (RoomFeature roomFeature : hotelController.getHotelRoomTypeController().getRoomFeatureController().getAll(roomId)) {
            System.out.println(" +" + roomFeature.getFeature());
        }

        System.out.print(" *How many people: ");
        int people = scanner.nextInt();

        reservationController.addReservation(hotelId, roomId, hostelId);
        int reservationId = reservationController.getLastReservationId();
        while (people-- > 0) {
            System.out.print("ID Number: ");
            int idNum = scanner.nextInt();
            System.out.print("First name: ");
            String firstName = scanner.next();
            System.out.print("Last name: ");
            String lastName = scanner.next();

            customerController.addCustomer(reservationId, idNum, firstName, lastName);
        }

        System.out.println("*****");
    }
}
