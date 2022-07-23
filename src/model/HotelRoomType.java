package model;

import helper.DBConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelRoomType {
    private int id;
    private int hotelId;
    private String roomType;
    private int stock;
    private int price;

    public HotelRoomType() {
    }

    public HotelRoomType(int id, int hotelId, String roomType, int stock, int price) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean addHotelRoomType(int hotelId, String roomType, int stock, int price) {
        String query = "INSERT INTO hotel_room_type (hotel_id, room_type, stock, price) VALUES (?,?,?,?)";
        boolean isAdd;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, roomType);
            preparedStatement.setInt(3, stock);
            preparedStatement.setInt(4, price);
            isAdd = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public HotelRoomType getFetchHotelRoomType(int hotelId, String roomType) {
        String query = "SELECT * FROM hotel_room_type WHERE hotel_id = ? AND room_type = ?";

        HotelRoomType hotelRoomType = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, roomType);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String ROOM_TYPE = resultSet.getString("room_type");
                int STOCK = resultSet.getInt("stock");
                int PRICE = resultSet.getInt("price");
                hotelRoomType = new HotelRoomType(ID, HOTEL_ID, ROOM_TYPE, STOCK, PRICE);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelRoomType;
    }

    public HotelRoomType getFetchHotelRoomType(int id) {
        String query = "SELECT * FROM hotel_room_type WHERE id = ?";

        HotelRoomType hotelRoomType = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String ROOM_TYPE = resultSet.getString("room_type");
                int STOCK = resultSet.getInt("stock");
                int PRICE = resultSet.getInt("price");
                hotelRoomType = new HotelRoomType(ID, HOTEL_ID, ROOM_TYPE, STOCK, PRICE);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelRoomType;
    }

    public boolean updateHotelRoomType(int id, int hotelId, String roomType, int stock, int price) {
        String query = "UPDATE hotel_room_type SET hotel_id=?, room_type=?, stock=?, price=? WHERE id=?";
        boolean isUpdate;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, roomType);
            preparedStatement.setInt(3, stock);
            preparedStatement.setInt(4, price);
            preparedStatement.setInt(5, id);
            isUpdate = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isUpdate;
    }

    public boolean deleteHotelRoomType(int id) {
        String query = "DELETE FROM hotel_room_type WHERE id = ?";

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

    public boolean deleteAllHotelRoomTypeOfHotel(int hotelId) {
        String query = "DELETE FROM hotel_room_type WHERE hotel_id = ?";

        boolean isDelete;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            isDelete = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDelete;
    }

    public ArrayList<HotelRoomType> getList(int hotelId) {
        String query = "SELECT * FROM hotel_room_type WHERE hotel_id = ?";

        ArrayList<HotelRoomType> hotelRoomTypeList = new ArrayList<>();
        HotelRoomType hotelRoomType;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String ROOM_TYPE = resultSet.getString("room_type");
                int STOCK = resultSet.getInt("stock");
                int PRICE = resultSet.getInt("price");
                hotelRoomType = new HotelRoomType(ID, HOTEL_ID, ROOM_TYPE, STOCK, PRICE);
                hotelRoomTypeList.add(hotelRoomType);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelRoomTypeList;
    }
}
