package model;

import helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {
    private int id;
    private int reservationId;
    private int idNumber;
    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(int id, int reservationId, int idNumber, String firstName, String lastName) {
        this.id = id;
        this.reservationId = reservationId;
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean add(int reservationId, int idNumber, String firstName, String lastName) {
        String query = "INSERT INTO customer (reservation_id, id_number, first_name, last_name) VALUES (?,?,?,?)";
        boolean isAdd;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, reservationId);
            preparedStatement.setInt(2, idNumber);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            isAdd = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdd;
    }
}
