package model;

import helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelFacility {
    int id;
    int hotelId;
    String facilityName;

    public HotelFacility(){}

    public HotelFacility(int id, int hotelId, String facilityName) {
        this.id = id;
        this.hotelId = hotelId;
        this.facilityName = facilityName;
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

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public boolean addFacility(int hotelId, String facilityName) {
        String query = "INSERT INTO hotel_facility (hotel_id, facility_name) VALUES (?,?)";
        boolean isAdd;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, facilityName.trim());

            isAdd = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }
    public HotelFacility getFetchFacility(int hotelId, String facilityName) {
        String query = "SELECT * FROM hotel_facility WHERE hotel_id = ? AND facility_name = ?";

        HotelFacility hotelFacility = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, facilityName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String FACILITY_NAME = resultSet.getString("facility_name");
                hotelFacility = new HotelFacility(ID, HOTEL_ID, FACILITY_NAME);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelFacility;
    }

    public HotelFacility getFetchFacility(int hotelFacilityId) {
        String query = "SELECT * FROM hotel_facility WHERE id = ?";

        HotelFacility hotelFacility = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelFacilityId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String FACILITY_NAME = resultSet.getString("facility_name");
                hotelFacility = new HotelFacility(ID, HOTEL_ID, FACILITY_NAME);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelFacility;
    }

    public boolean updateFacility(int id, String facilityName) {
        String query = "UPDATE hotel_facility SET facility_name=? WHERE id=?";
        boolean isUpdate;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, facilityName.trim());
            preparedStatement.setInt(2, id);
            isUpdate = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isUpdate;
    }

    public boolean deleteFacility(int facilityId) {
        String query = "DELETE FROM hotel_facility WHERE id = ?";

        boolean isDelete;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, facilityId);
            isDelete = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDelete;
    }

    public boolean deleteAllFacilitiesOfHotel(int hotelId) {
        String query = "DELETE FROM hotel_facility WHERE hotel_id = ?";

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

    public ArrayList<HotelFacility> getList(int hotelId) {
        String query = "SELECT * FROM hotel_facility WHERE hotel_id = ?";

        ArrayList<HotelFacility> hotelFacilityList = new ArrayList<>();
        HotelFacility hotelFacility;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,hotelId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String FACILITY_NAME = resultSet.getString("facility_name");
                hotelFacility = new HotelFacility(ID,HOTEL_ID,FACILITY_NAME);
                hotelFacilityList.add(hotelFacility);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelFacilityList;
    }
}
