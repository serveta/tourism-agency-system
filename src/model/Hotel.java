package model;

import helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Hotel {
    private int id;
    private String name;
    private String address;
    private String mail;
    private String phone;
    private String star;

    public Hotel(){}
    public Hotel(int id, String name, String address, String mail, String phone, String star) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public ArrayList<Hotel> getList() {
        String query = "SELECT * FROM hotel";

        ArrayList<Hotel> hotelList = new ArrayList<>();
        Hotel hotel;

        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String ADDRESS = resultSet.getString("address");
                String MAIL = resultSet.getString("mail");
                String PHONE = resultSet.getString("phone");
                String STAR = resultSet.getString("star");
                hotel = new Hotel(ID, NAME, ADDRESS, MAIL, PHONE, STAR);
                hotelList.add(hotel);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotelList;
    }

    public Hotel getFetch(int id) {
        String query = "SELECT * FROM hotel WHERE id = ?";

        Hotel hotel = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String ADDRESS = resultSet.getString("address");
                String MAIL = resultSet.getString("mail");
                String PHONE = resultSet.getString("phone");
                String STAR = resultSet.getString("star");
                hotel = new Hotel(ID, NAME, ADDRESS, MAIL, PHONE, STAR);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotel;
    }

    public Hotel getFetch(String name, String address) {
        String query = "SELECT * FROM hotel WHERE name = ? AND address = ?";

        Hotel hotel = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String ADDRESS = resultSet.getString("address");
                String MAIL = resultSet.getString("mail");
                String PHONE = resultSet.getString("phone");
                String STAR = resultSet.getString("star");
                hotel = new Hotel(ID, NAME, ADDRESS, MAIL, PHONE, STAR);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return hotel;
    }

    public boolean add(String name, String address, String mail, String phone, String star) {
        String query = "INSERT INTO hotel (name,address,mail,phone,star) VALUES (?,?,?,?,?)";
        boolean isAdd;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name.trim());
            preparedStatement.setString(2, address.trim());
            preparedStatement.setString(3, mail.trim());
            preparedStatement.setString(4, phone.trim());
            preparedStatement.setString(5, star.trim());

            isAdd = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isAdd;
    }

    public boolean delete(int hotelId) {
        String query = "DELETE FROM hotel WHERE id = ?";

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

    public boolean update(int id, String name, String address, String mail, String phone, String star) {
        String query = "UPDATE hotel SET name=?,address=?,mail=?,phone=?,star=? WHERE id=?";
        boolean isUpdate;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name.trim());
            preparedStatement.setString(2, address.trim());
            preparedStatement.setString(3, mail.trim());
            preparedStatement.setString(4, phone.trim());
            preparedStatement.setString(5, star.trim());
            preparedStatement.setInt(6,id);
            isUpdate = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isUpdate;
    }
}
