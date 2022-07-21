package controller;

import helper.Role;
import model.HostelType;
import model.HotelFacility;
import model.User;

import java.util.ArrayList;

public class HostelController {
    private HostelType hostelType;

    public HostelController() {
        this.hostelType = new HostelType();
    }

    public HostelType getHostelType() {
        return hostelType;
    }

    public void setHostelType(HostelType hostelType) {
        this.hostelType = hostelType;
    }

    public boolean addHostelType(int hotelId, String hostelType) {
        HotelController hotelController = new HotelController();
        if (hotelController.getFetch(hotelId) != null) {
            if (getHostelType().getFetchHostelType(hotelId,hostelType) == null) {
                if (getHostelType().addHostelType(hotelId, hostelType)) {
                    System.out.println("Hostel type added for hotel : " + hotelController.getFetch(hotelId).getName());
                    return true;
                } else {
                    System.out.println("An error occurred during the adding.");
                    return false;
                }
            } else {
                System.out.println("The hostel type already there is.");
                return false;
            }
        } else {
            System.out.println("Hotel doesn't exist.");
            return false;
        }
    }

    public boolean updateHostelType(int hostelTypeId, String hostelType) {
        if (getHostelType().getFetchHostelType(hostelTypeId) != null) {
            if (getHostelType().updateHostelType(hostelTypeId, hostelType)) {
                System.out.println("Hostel type updated.");
                return true;
            } else {
                System.out.println("An error occurred during the update.");
                return false;
            }
        } else {
            System.out.println("Hostel type doesn't exist.");
            return false;
        }
    }

    public boolean deleteHostelType(User user, int hotelFacilityId) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (getHostelType().getFetchHostelType(hotelFacilityId) != null) {
                if (getHostelType().deleteHostelType(hotelFacilityId)) {
                    System.out.println("Hotel type deleted.");
                    return true;
                } else {
                    System.out.println("An error occurred during the deletion.");
                    return false;
                }
            } else {
                System.out.println("Hostel type doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access delete operation.");
            return false;
        }
    }

    public ArrayList<HostelType> getAll(int hotelId) {
        return getHostelType().getList(hotelId);
    }

    public boolean deleteAllHostelTypeOfHotel(int hotelId) {
        if (getHostelType().deleteAllHostelTypeOfHotel(hotelId)) {
            System.out.println("All hostel type of hotel were deleted.");
            return true;
        }
        return false;
    }
}
