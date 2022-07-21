package controller;

import helper.Role;
import model.Hotel;
import model.HotelFacility;
import model.HotelSeason;
import model.User;

import java.util.ArrayList;

public class HotelController {
    private Hotel hotel;
    private HotelFacilityController hotelFacilityController;
    private HostelController hostelController;
    private HotelSeasonController hotelSeasonController;
    private HotelRoomTypeController hotelRoomTypeController;

    public HotelController() {
        this.hotel = new Hotel();
        this.hotelFacilityController = new HotelFacilityController();
        this.hostelController = new HostelController();
        this.hotelSeasonController = new HotelSeasonController();
        this.hotelRoomTypeController = new HotelRoomTypeController();
    }

    public HotelRoomTypeController getHotelRoomTypeController() {
        return hotelRoomTypeController;
    }

    public void setHotelRoomTypeController(HotelRoomTypeController hotelRoomTypeController) {
        this.hotelRoomTypeController = hotelRoomTypeController;
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

    public HostelController getHostelController() {
        return hostelController;
    }

    public void setHostelController(HostelController hostelController) {
        this.hostelController = hostelController;
    }

    public HotelSeasonController getHotelSeasonController() {
        return hotelSeasonController;
    }

    public void setHotelSeasonController(HotelSeasonController hotelSeasonController) {
        this.hotelSeasonController = hotelSeasonController;
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
                    getHotelFacilityController().deleteAllFacilitiesOfHotel(hotelId);
                    getHostelController().deleteAllHostelTypeOfHotel(hotelId);
                    getHotelSeasonController().deleteAllHotelSeasonOfHotel(hotelId);
                    getHotelRoomTypeController().deleteAllRoomTypeOfHotel(hotelId);
                    System.out.println("The hotel were deleted.");
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
