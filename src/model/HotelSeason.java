package model;

import helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

public class HotelSeason {
    int id;
    int hotelId;
    Date seasonStart;
    Date seasonEnd;
    String seasonName;

    public HotelSeason() {
    }

    public HotelSeason(int id, int hotelId, Date seasonStart, Date seasonEnd, String seasonName) {
        this.id = id;
        this.hotelId = hotelId;
        this.seasonStart = seasonStart;
        this.seasonEnd = seasonEnd;
        this.seasonName = seasonName;
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

    public Date getSeasonStart() {
        return seasonStart;
    }

    public void setSeasonStart(Date seasonStart) {
        this.seasonStart = seasonStart;
    }

    public Date getSeasonEnd() {
        return seasonEnd;
    }

    public void setSeasonEnd(Date seasonEnd) {
        this.seasonEnd = seasonEnd;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public boolean addHotelSeason(int hotelId, Date seasonStart, Date seasonEnd, String seasonName) {
        String query = "INSERT INTO hotel_season (hotel_id, season_start, season_end, season_name) VALUES (?,?,?,?)";
        boolean isAdd;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setDate(2, seasonStart);
            preparedStatement.setDate(3, seasonEnd);
            preparedStatement.setString(4, seasonName);
            isAdd = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public HotelSeason getFetchHotelSeason(int hotelId, String seasonName) {
        String query = "SELECT * FROM hotel_season WHERE hotel_id = ? AND season_name = ?";

        HotelSeason hotelSeason = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            preparedStatement.setString(2, seasonName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                Date SEASON_START = resultSet.getDate("season_start");
                Date SEASON_END = resultSet.getDate("season_end");
                String SEASON_NAME = resultSet.getString("season_name");
                hotelSeason = new HotelSeason(ID, HOTEL_ID, SEASON_START, SEASON_END, SEASON_NAME);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelSeason;
    }
    public HotelSeason getFetchHotelSeason(int seasonId) {
        String query = "SELECT * FROM hotel_season WHERE id = ?";

        HotelSeason hotelSeason = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, seasonId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                Date SEASON_START = resultSet.getDate("season_start");
                Date SEASON_END = resultSet.getDate("season_end");
                String SEASON_NAME = resultSet.getString("season_name");
                hotelSeason = new HotelSeason(ID, HOTEL_ID, SEASON_START, SEASON_END, SEASON_NAME);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelSeason;
    }

    public boolean updateHotelSeason(int id, int hotelId, Date seasonStart, Date seasonEnd, String seasonName) {
        String query = "UPDATE hotel_season SET hotel_id=?, season_start=?, season_end=?, season_name=? WHERE id=?";
        boolean isUpdate;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1,hotelId);
            preparedStatement.setDate(2, seasonStart);
            preparedStatement.setDate(3, seasonEnd);
            preparedStatement.setString(4,seasonName);
            preparedStatement.setInt(5, id);
            isUpdate = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isUpdate;
    }
    public boolean deleteHotelSeason(int hotelSeasonId) {
        String query = "DELETE FROM hotel_season WHERE id = ?";

        boolean isDelete;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelSeasonId);
            isDelete = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDelete;
    }

    public boolean deleteAllHotelSeasonOfHotel(int hotelId) {
        String query = "DELETE FROM hotel_season WHERE hotel_id = ?";

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

    public ArrayList<HotelSeason> getList(int hotelId) {
        String query = "SELECT * FROM hotel_season WHERE hotel_id = ?";

        ArrayList<HotelSeason> hotelSeasonList = new ArrayList<>();
        HotelSeason hotelSeason;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, hotelId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                int HOTEL_ID = resultSet.getInt("hotel_id");
                Date SEASON_START = resultSet.getDate("season_start");
                Date SEASON_END = resultSet.getDate("season_end");
                String SEASON_NAME = resultSet.getString("season_name");
                hotelSeason = new HotelSeason(ID, HOTEL_ID, SEASON_START, SEASON_END, SEASON_NAME);
                hotelSeasonList.add(hotelSeason);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelSeasonList;
    }
}
