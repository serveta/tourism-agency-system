package model;

import helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reservation {
    private int id;
    private int hotel_id;
    private int room_id;
    private int hostel_id;

    public Reservation(){

    }

    public Reservation(int id, int hotel_id, int room_id, int hostel_id) {
        this.id = id;
        this.hotel_id = hotel_id;
        this.room_id = room_id;
        this.hostel_id = hostel_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getHostel_id() {
        return hostel_id;
    }

    public void setHostel_id(int hostel_id) {
        this.hostel_id = hostel_id;
    }

    public boolean add(int hotelId, int room_id, int hostel_id) {
        String query = "INSERT INTO reservation (hotel_id, room_id, hostel_id) VALUES (?,?,?)";
        boolean isAdd;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setInt(2, room_id);
            preparedStatement.setInt(3, hostel_id);
            isAdd = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd;
    }

    public int getLastReservationId() {
        String query = "SELECT id FROM reservation ORDER BY id DESC LIMIT 1";

        int lastReservationId = -1;

        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                lastReservationId = resultSet.getInt("id");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lastReservationId;
    }
}
