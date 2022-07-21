package controller;

import helper.Role;
import model.HotelRoomType;
import model.HotelSeason;
import model.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

public class HotelRoomTypeController {
    HotelRoomType hotelRoomType;
    RoomFeatureController roomFeatureController;

    public HotelRoomTypeController() {
        this.hotelRoomType = new HotelRoomType();
        this.roomFeatureController = new RoomFeatureController();
    }

    public HotelRoomType getHotelRoomType() {
        return hotelRoomType;
    }

    public void setHotelRoomType(HotelRoomType hotelRoomType) {
        this.hotelRoomType = hotelRoomType;
    }

    public RoomFeatureController getRoomFeatureController() {
        return roomFeatureController;
    }

    public boolean addHotelRoomType(int hotelId, String roomType, int stock) {
        HotelController hotelController = new HotelController();
        if (hotelController.getFetch(hotelId) != null) {
            if (getHotelRoomType().getFetchHotelRoomType(hotelId, roomType) == null) {
                if (getHotelRoomType().addHotelRoomType(hotelId, roomType, stock)) {
                    System.out.println("Room Type added for hotel : " + hotelController.getFetch(hotelId).getName());
                    return true;
                } else {
                    System.out.println("An error occurred during the adding.");
                    return false;
                }
            } else {
                System.out.println("The room type already there is.");
                return false;
            }
        } else {
            System.out.println("Hotel doesn't exist.");
            return false;
        }
    }

    public boolean updateHotelRoomType(int id, int hotelId, String roomType, int stock) {
        if (getHotelRoomType().getFetchHotelRoomType(id) != null) {
            if (getHotelRoomType().updateHotelRoomType(id, hotelId, roomType, stock)) {
                System.out.println("Room type updated.");
                return true;
            } else {
                System.out.println("An error occurred during the update.");
                return false;
            }
        } else {
            System.out.println("Room type doesn't exist.");
            return false;
        }
    }

    public boolean deleteHotelRoomType(User user, int roomTypeId) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (getHotelRoomType().getFetchHotelRoomType(roomTypeId) != null) {
                if (getHotelRoomType().deleteHotelRoomType(roomTypeId)) {
                    getRoomFeatureController().deleteAllRoomFeatureOfHotelRoomType(roomTypeId);
                    System.out.println("Room type deleted.");
                    return true;
                } else {
                    System.out.println("An error occurred during the deletion.");
                    return false;
                }
            } else {
                System.out.println("Hotel room type doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access delete operation.");
            return false;
        }
    }

    public boolean deleteAllRoomTypeOfHotel(int hotelId) {
        HashSet<Integer> idOfHotelRoomType = new HashSet<>();

        for (HotelRoomType hotelRT : getHotelRoomType().getList(hotelId)) {
            idOfHotelRoomType.add(hotelRT.getId());
        }

        if (getHotelRoomType().deleteAllHotelRoomTypeOfHotel(hotelId)) {
            for (Integer roomTypeId : idOfHotelRoomType) {
                getRoomFeatureController().deleteAllRoomFeatureOfHotelRoomType(roomTypeId);
            }
            System.out.println("All room type of hotel were deleted.");
            return true;
        }
        return false;
    }

    public ArrayList<HotelRoomType> getAll(int hotelId) {
        return getHotelRoomType().getList(hotelId);
    }
}
