package model;

import helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HostelType {
    int id;
    int hotelId;
    String hostelType;

    public HostelType() {
    }

    public HostelType(int id, int hotelId, String hostelType) {
        this.id = id;
        this.hotelId = hotelId;
        this.hostelType = hostelType;
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

    public String getHostelType() {
        return hostelType;
    }

    public void setHostelType(String hostelType) {
        this.hostelType = hostelType;
    }

    public boolean addHostelType(int hotelId, String hostelType) {
        String query = "INSERT INTO hotel_hostel_type (hotel_id, hostel_type) VALUES (?,?)";
        boolean isAdd;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, hostelType.trim());

            isAdd = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public HostelType getFetchHostelType(int hotelId, String hostelType) {
        String query = "SELECT * FROM hotel_hostel_type WHERE hotel_id = ? AND hostel_type = ?";

        HostelType hType = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, hostelType);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String HOSTEL_TYPE = resultSet.getString("hostel_type");
                hType = new HostelType(ID, HOTEL_ID, HOSTEL_TYPE);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hType;
    }

    public HostelType getFetchHostelType(int hostelTypeId) {
        String query = "SELECT * FROM hotel_hostel_type WHERE id = ?";

        HostelType hType = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hostelTypeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String HOSTEL_TYPE = resultSet.getString("hostel_type");
                hType = new HostelType(ID, HOTEL_ID, HOSTEL_TYPE);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hType;
    }

    public boolean updateHostelType(int id, String hostelType) {
        String query = "UPDATE hotel_hostel_type SET hostel_type=? WHERE id=?";
        boolean isUpdate;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, hostelType.trim());
            preparedStatement.setInt(2, id);
            isUpdate = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isUpdate;
    }

    public boolean deleteHostelType(int hostelTypeId) {
        String query = "DELETE FROM hotel_hostel_type WHERE id = ?";

        boolean isDelete;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hostelTypeId);
            isDelete = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDelete;
    }

    public boolean deleteAllHostelTypeOfHotel(int hotelId) {
        String query = "DELETE FROM hotel_hostel_type WHERE hotel_id = ?";

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

    public ArrayList<HostelType> getList(int hotelId) {
        String query = "SELECT * FROM hotel_hostel_type WHERE hotel_id = ?";

        ArrayList<HostelType> hostelTypeList = new ArrayList<>();
        HostelType hType;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                String HOSTEL_TYPE = resultSet.getString("hostel_type");
                hType = new HostelType(ID, HOTEL_ID, HOSTEL_TYPE);
                hostelTypeList.add(hType);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hostelTypeList;
    }


}
