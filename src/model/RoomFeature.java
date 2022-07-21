package model;

import helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomFeature {
    int id;
    int roomId;
    String feature;

    public RoomFeature() {
    }

    public RoomFeature(int id, int roomId, String feature) {
        this.id = id;
        this.roomId = roomId;
        this.feature = feature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public boolean addRoomFeature(int roomId, String feature) {
        String query = "INSERT INTO room_feature (room_id, feature) VALUES (?,?)";
        boolean isAdd;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, roomId);
            preparedStatement.setString(2, feature);
            isAdd = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public RoomFeature getFetchHotelRoomType(int roomId, String feature) {
        String query = "SELECT * FROM room_feature WHERE room_id = ? AND feature = ?";

        RoomFeature roomFeature = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, roomId);
            preparedStatement.setString(2, feature);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int ROOM_ID = resultSet.getInt("room_id");
                String FEATURE = resultSet.getString("feature");
                roomFeature = new RoomFeature(ID, ROOM_ID, FEATURE);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roomFeature;
    }

    public RoomFeature getFetchRoomFeature(int id) {
        String query = "SELECT * FROM room_feature WHERE id = ?";

        RoomFeature roomFeature = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int ROOM_ID = resultSet.getInt("room_id");
                String FEATURE = resultSet.getString("feature");
                roomFeature = new RoomFeature(ID, ROOM_ID, FEATURE);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roomFeature;
    }

    public boolean updateRoomFeature(int id, int roomId, String feature) {
        String query = "UPDATE room_feature SET room_id=?, feature=? WHERE id=?";
        boolean isUpdate;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, roomId);
            preparedStatement.setString(2, feature);
            preparedStatement.setInt(3, id);
            isUpdate = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isUpdate;
    }
    public boolean deleteRoomFeature(int id) {
        String query = "DELETE FROM room_feature WHERE id = ?";

        boolean isDelete;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            isDelete = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDelete;
    }

    public boolean deleteAllRoomFeatureOfHotelRoomType(int roomId) {
        String query = "DELETE FROM room_feature WHERE room_id = ?";

        boolean isDelete;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, roomId);
            isDelete = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDelete;
    }

    public ArrayList<RoomFeature> getList(int roomId) {
        String query = "SELECT * FROM room_feature WHERE room_id = ?";

        ArrayList<RoomFeature> roomFeatureList = new ArrayList<>();
        RoomFeature roomFeature;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, roomId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int ROOM_ID = resultSet.getInt("room_id");
                String FEATURE = resultSet.getString("feature");
                roomFeature = new RoomFeature(ID, ROOM_ID, FEATURE);
                roomFeatureList.add(roomFeature);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roomFeatureList;
    }
}
