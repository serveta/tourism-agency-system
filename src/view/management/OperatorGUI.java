package view.management;

import controller.UserController;
import helper.Config;
import helper.Help;
import helper.Role;
import model.User;

import javax.swing.*;

public class OperatorGUI extends JFrame {
    private JPanel wrapper;
    private JLabel welcomeLabel;
    private JButton logoutButton;

    private UserController userController;

    public OperatorGUI(UserController userController) {
        this.userController = userController;

        add(wrapper);
        setSize(1000, 1000);
        setLocation(Help.screenCenterPoint("x", getSize()), Help.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(false);

        System.out.println("* User List Test");
        for (User u : userController.getAllUser(userController.getUser().getRole())) {
            System.out.println(" +" +u.getName());
        }

        System.out.println("* User Add Test");
        System.out.println(" +" +userController.addUser("Marry","mry","1212",1));

        System.out.println("* User Delete Test");
        System.out.println(" +" +userController.deleteUser(4));

        System.out.println("* User Update Test (for its own)");
        System.out.println(" +" + userController.updateUser(1,"Test-operator", "Test-username", "123",2));

        System.out.println("* User Update Test-2");
        System.out.println(" +" + userController.updateUser(7,"Test-operator", "Test-username-manager", "123",1));

    }
}
