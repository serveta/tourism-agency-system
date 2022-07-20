package controller;

import helper.Role;
import model.Hotel;
import model.User;

import java.util.ArrayList;

public class HotelController {
    private Hotel hotel;

    public HotelController() {
        this.hotel = new Hotel();
    }
    public HotelController(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Hotel> getAll() {
        return hotel.getList();
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
    }

    public boolean deleteHotel(User user, int hotelId) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (hotel.getFetch(hotelId) != null) {
                if (hotel.delete(hotelId)) {
                    System.out.println("Hotel deleted.");
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

    public boolean addFacility(int hotelId, String facilityName) {
        if (hotel.getFetch(hotelId) != null) {
            if (hotel.getFetchFacility(hotelId,facilityName) == null) {
                if (hotel.addFacility(hotelId, facilityName)) {
                    System.out.println("Hotel facility added.");
                    return true;
                } else {
                    System.out.println("An error occurred during the adding.");
                    return  false;
                }
            } else {
                System.out.println("The facility already there is.");
                return false;
            }

        } else {
            System.out.println("Hotel doesn't exist.");
            return false;
        }
    }

    public boolean updateFacility(int hotelId, String facilityName) {
        if (hotel.getFetch(hotelId) != null) {
            if (hotel.updateFacility(hotelId, facilityName)) {
                System.out.println("Hotel facility updated.");
                return true;
            } else {
                System.out.println("An error occurred during the update.");
                return false;
            }
        } else {
            System.out.println("Hotel doesn't exist.");
            return false;
        }
    }

    public boolean deleteFacility(User user, int hotelFacilityId) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (hotel.getFetchFacility(hotelFacilityId) != null) {
                if (hotel.deleteFacility(hotelFacilityId)) {
                    System.out.println("Hotel facility deleted.");
                    return true;
                } else {
                    System.out.println("An error occurred during the deletion.");
                    return  false;
                }
            } else {
                System.out.println("Hotel facility doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access delete operation.");
            return false;
        }
    }
}
