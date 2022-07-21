package controller;

import helper.Role;
import model.HotelRoomType;
import model.RoomFeature;
import model.User;

import java.util.ArrayList;

public class RoomFeatureController {
    RoomFeature roomFeature;

    public RoomFeatureController() {
        this.roomFeature = new RoomFeature();
    }

    public RoomFeature getRoomFeature() {
        return roomFeature;
    }

    public boolean addRoomFeature(int roomId, String feature) {
        HotelRoomType hotelRoomType = new HotelRoomType();
        if (hotelRoomType.getFetchHotelRoomType(roomId) != null) {
            if (getRoomFeature().getFetchHotelRoomType(roomId, feature) == null) {
                if (getRoomFeature().addRoomFeature(roomId, feature)) {
                    System.out.println("Room feature added for room type : " + hotelRoomType.getFetchHotelRoomType(roomId).getRoomType());
                    return true;
                } else {
                    System.out.println("An error occurred during the adding.");
                    return false;
                }
            } else {
                System.out.println("The room feature already there is.");
                return false;
            }
        } else {
            System.out.println("Room Type doesn't exist.");
            return false;
        }
    }

    public boolean updateRoomFeature(int id, int roomId, String feature) {
        if (getRoomFeature().getFetchRoomFeature(id) != null) {
            if (getRoomFeature().updateRoomFeature(id, roomId, feature)) {
                System.out.println("Room feature updated.");
                return true;
            } else {
                System.out.println("An error occurred during the update.");
                return false;
            }
        } else {
            System.out.println("Room feature doesn't exist.");
            return false;
        }
    }

    public boolean deleteHotelRoomType(User user, int roomFeatureId) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (getRoomFeature().getFetchRoomFeature(roomFeatureId) != null) {
                if (getRoomFeature().deleteRoomFeature(roomFeatureId)) {
                    System.out.println("Room feature deleted.");
                    return true;
                } else {
                    System.out.println("An error occurred during the deletion.");
                    return false;
                }
            } else {
                System.out.println("Hotel room feature doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access delete operation.");
            return false;
        }
    }

    public boolean deleteAllRoomFeatureOfHotelRoomType(int roomId) {
        if (getRoomFeature().deleteAllRoomFeatureOfHotelRoomType(roomId)) {
            System.out.println("All room feature of hotel room type were deleted.");
            return true;
        }
        return false;
    }

    public ArrayList<RoomFeature> getAll(int roomId) {
        return getRoomFeature().getList(roomId);
    }
}
