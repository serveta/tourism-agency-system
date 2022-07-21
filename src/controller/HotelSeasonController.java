package controller;

import helper.Role;
import model.HostelType;
import model.HotelSeason;
import model.User;

import java.sql.Date;
import java.util.ArrayList;

public class HotelSeasonController {
    HotelSeason hotelSeason;

    public HotelSeasonController() {
        this.hotelSeason = new HotelSeason();
    }

    public HotelSeason getHotelSeason() {
        return hotelSeason;
    }

    public void setHotelSeason(HotelSeason hotelSeason) {
        this.hotelSeason = hotelSeason;
    }

    public boolean addHotelSeason(int hotelId, Date seasonStart, Date seasonEnd, String seasonName) {
        HotelController hotelController = new HotelController();
        if (hotelController.getFetch(hotelId) != null) {
            if (getHotelSeason().getFetchHotelSeason(hotelId, seasonName) == null) {
                if (getHotelSeason().addHotelSeason(hotelId, seasonStart, seasonEnd, seasonName)) {
                    System.out.println("Season added for hotel : " + hotelController.getFetch(hotelId).getName());
                    return true;
                } else {
                    System.out.println("An error occurred during the adding.");
                    return false;
                }
            } else {
                System.out.println("The season already there is.");
                return false;
            }
        } else {
            System.out.println("Hotel doesn't exist.");
            return false;
        }
    }
    public boolean updateHotelSeason(int hotelSeasonId, int hotelId, Date seasonStart, Date seasonEnd, String seasonName) {
        if (getHotelSeason().getFetchHotelSeason(hotelSeasonId) != null) {
            if (getHotelSeason().updateHotelSeason(hotelSeasonId, hotelId, seasonStart, seasonEnd, seasonName)) {
                System.out.println("Hotel season updated.");
                return true;
            } else {
                System.out.println("An error occurred during the update.");
                return false;
            }
        } else {
            System.out.println("Hotel season doesn't exist.");
            return false;
        }
    }

    public boolean deleteHotelSeason(User user, int hotelSeasonId) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (getHotelSeason().getFetchHotelSeason(hotelSeasonId) != null) {
                if (getHotelSeason().deleteHotelSeason(hotelSeasonId)) {
                    System.out.println("Hotel season deleted.");
                    return true;
                } else {
                    System.out.println("An error occurred during the deletion.");
                    return false;
                }
            } else {
                System.out.println("Hotel season doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access delete operation.");
            return false;
        }
    }
    public boolean deleteAllHotelSeasonOfHotel(int hotelId) {
        if (getHotelSeason().deleteAllHotelSeasonOfHotel(hotelId)) {
            System.out.println("All hotel season of hotel were deleted.");
            return true;
        }
        return false;
    }

    public ArrayList<HotelSeason> getAll(int hotelId) {
        return getHotelSeason().getList(hotelId);
    }
}
