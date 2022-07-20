package controller;

import helper.Role;
import model.User;

import java.util.ArrayList;

public class UserController {
    private User user;

    public UserController(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getAllUser(int role) {
        if (role == Role.MANAGER.getRole()) {
            return user.getList();
        } else if (role == Role.OPERATOR.getRole()) {
            return user.getList(role);
        } else {
            System.out.println("No users were found.");
            return null;
        }
    }

    public boolean addUser(String name, String username, String password, int role) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (user.getFetch(username) == null) {
                if(user.add(name, username, password, role)) {
                    System.out.println("Adding was successful.");
                    return true;
                } else {
                    System.out.println("An error occurred during the adding.");
                    return  false;
                }
            } else {
                System.out.println("Username already in use.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access add operation.");
            return false;
        }
    }

    public boolean deleteUser(int id) {
        if (user.getRole() == Role.MANAGER.getRole()) {
            if (user.getFetch(id) != null) {
                if (user.delete(id)) {
                    System.out.println("User deleted.");
                    return true;
                } else {
                    System.out.println("An error occurred during the deletion.");
                    return  false;
                }
            } else {
                System.out.println("User doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access delete operation.");
            return false;
        }
    }

    public boolean updateUser(int id, String name, String username, String password, int role) {
        if (user.getRole() == Role.MANAGER.getRole() || user.getId() == id) {
            if (user.getFetch(id) != null) {
                if (user.update(id, name, username, password, role)) {
                    System.out.println("User updated.");
                    return true;
                } else {
                    System.out.println("An error occurred during the update.");
                    return false;
                }
            } else {
                System.out.println("User doesn't exist.");
                return false;
            }
        } else {
            System.out.println("Your role cannot access update operation.");
            return false;
        }
    }
}
