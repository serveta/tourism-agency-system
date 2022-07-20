import controller.UserController;
import helper.Help;
import helper.Role;
import model.User;
import view.management.ManagerGUI;
import view.management.OperatorGUI;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String username = "";
        String password = "";

        int test = 2;
        for (int i = 0; i < test; i++) {
            System.out.println("**********************************");
            if (i == 0) {
                System.out.println(" * MANAGER TEST");
                username = "Test-username-manager";
                password = "123";
            } else if (i == 1) {
                System.out.println(" * OPERATOR TEST");
                username = "Test-username";
                password = "123";
            }

            User user = new User(username, password);

            user = user.getFetch(username, password);
            if (user != null) {
                System.out.println("Signed in account " + user.getName());

                if (user.getRole() == Role.MANAGER.getRole()) {
                    ManagerGUI managerGUI = new ManagerGUI(new UserController(user));
                } else if (user.getRole() == Role.OPERATOR.getRole()) {
                    OperatorGUI operatorGUI = new OperatorGUI(new UserController(user));
                } else {
                    System.out.println("ERROR: The user role does not exist.");
                }
            } else {
                System.out.println("WARNING: username or password is wrong");
            }
        }
    }
}
