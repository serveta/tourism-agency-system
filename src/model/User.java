package model;

import helper.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    int id;
    String name;
    String username;
    String password;
    int role;

    public User(String username, String password) {

    }

    public User(int id, String name, String username, String password, int role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User getFetch(int userId) {
        String query = "SELECT * FROM \"user\" WHERE id = ?";

        User user = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int role = resultSet.getInt("role");
                user = new User(id, name, username, password, role);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    public User getFetch(String username, String password) {
        String query = "SELECT * FROM \"user\" WHERE username = ? AND password = ?";

        User user = null;

        try {
            PreparedStatement preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int ID = resultSet.getInt("id");
                String NAME = resultSet.getString("name");
                String USERNAME = resultSet.getString("username");
                String PASSWORD = resultSet.getString("password");
                int ROLE = resultSet.getInt("role");
                user = new User(ID, NAME, USERNAME, PASSWORD, ROLE);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
