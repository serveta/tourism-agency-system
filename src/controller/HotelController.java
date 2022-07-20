package controller;

import helper.Role;
import model.Hotel;
import model.HotelFacility;
import model.User;

import java.util.ArrayList;

public class HotelController {
    private Hotel hotel;
    private HotelFacilityController hotelFacilityController;

    public HotelController() {
        this.hotel = new Hotel();
        this.hotelFacilityController = new HotelFacilityController();
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public HotelFacilityController getHotelFacilityController() {
        return hotelFacilityController;
    }

    public void setHotelFacilityController(HotelFacilityController hotelFacilityController) {
        this.hotelFacilityController = hotelFacilityController;
    }

    public ArrayList<Hotel> getAll() {
        return hotel.getList();
    }

    public Hotel getFetch(int id){
        return hotel.getFetch(id);
    }

    public boolean addHotel(String name, String address, String mail, String phone, String star) {
        if (hotel.getFetch(name,address) == null) {
            if (hotel.add(name,address,mail,phone,star)) {
                System.out.println("Adding was successful.");
                return true;
            } else {
                System.out.println("An error occurred during the adding.");
                return false;
            }
        } else {
            System.out.println("The hotel is already in DB available.");
            return false;
        }
    }

    public boolean updateHotel(int id, String name, String address, String mail, String phone, String star) {
        if (hotel.getFetch(name,address) == null) {
            if (hotel.getFetch(id) != null) {
                if (hotel.update(id, name, address, mail, phone, star)) {
                    System.out.println("Hotel updated.");
                    return true;
                } else {
                    System.out.println("An error occurred during the update.");
                    return false;
                }
            } else {
                System.out.println("Hotel doesn't exist.");
                return false;
            }
        } else {
            System.out.println("The hotel is already in DB available.");
            return false;
        }
    }

    public boolean deleteHotel(User user, int hotelId) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (hotel.getFetch(hotelId) != null) {
                if (hotel.delete(hotelId)) {
                    HotelFacilityController hotelFacilityController1 = new HotelFacilityController();
                    hotelFacilityController1.deleteAllFacilitiesOfHotel(hotelId);
                    System.out.println("The hotel and its facilities were deleted.");
                    return true;
                } else {
                    System.out.println("An error occurred during the deletion.");
                    return  false;
                }
            } else {
                System.out.println("Hotel doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access delete operation.");
            return false;
        }
    }

}
