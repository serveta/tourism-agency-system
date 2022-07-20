package controller;

import helper.Role;
import model.Hotel;
import model.HotelFacility;
import model.User;

import java.util.ArrayList;

public class HotelFacilityController {
    HotelFacility hotelFacility;

    public HotelFacilityController() {
        this.hotelFacility = new HotelFacility();
    }

    public void setHotelFacility(HotelFacility hotelFacility) {
        this.hotelFacility = hotelFacility;
    }

    public boolean addFacility(int hotelId, String facilityName) {
        HotelController hotelController = new HotelController();
        if (hotelController.getFetch(hotelId) != null) {
            if (hotelFacility.getFetchFacility(hotelId, facilityName) == null) {
                if (hotelFacility.addFacility(hotelId, facilityName)) {
                    System.out.println("Hotel facility added.");
                    return true;
                } else {
                    System.out.println("An error occurred during the adding.");
                    return false;
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

    public boolean updateFacility(int facilityId, String facilityName) {
        if (hotelFacility.getFetchFacility(facilityId) != null) {
            if (hotelFacility.updateFacility(facilityId, facilityName)) {
                System.out.println("Hotel facility updated.");
                return true;
            } else {
                System.out.println("An error occurred during the update.");
                return false;
            }
        } else {
            System.out.println("Hotel facility doesn't exist.");
            return false;
        }
    }

    public boolean deleteFacility(User user, int hotelFacilityId) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (hotelFacility.getFetchFacility(hotelFacilityId) != null) {
                if (hotelFacility.deleteFacility(hotelFacilityId)) {
                    System.out.println("Hotel facility deleted.");
                    return true;
                } else {
                    System.out.println("An error occurred during the deletion.");
                    return false;
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

    public boolean deleteAllFacilitiesOfHotel(int hotelId) {
        if (hotelFacility.deleteAllFacilitiesOfHotel(hotelId)) {
            System.out.println("All facilities of hotel were deleted.");
            return true;
        }
        return false;
    }

    public ArrayList<HotelFacility> getAll(int hotelId) {
        return hotelFacility.getList(hotelId);
    }
}
