package model;

import helper.DBConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Search {
    public ArrayList<Hotel> searchHotelBySeasonEnd(Date seasonEnd) {
        String query = "SELECT hotel.* FROM hotel_season " +
                "LEFT JOIN hotel ON hotel.id = hotel_season.hotel_id " +
                "WHERE season_end >= ?";

        ArrayList<Hotel> responseList = new ArrayList<>();

        Hotel response;


        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setDate(1, seasonEnd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String ADDRESS = resultSet.getString("address");
                String MAIL = resultSet.getString("mail");
                String PHONE = resultSet.getString("phone");
                String STAR = resultSet.getString("star");
                response = new Hotel(ID, NAME, ADDRESS, MAIL, PHONE, STAR);
                responseList.add(response);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return responseList;
    }
}
