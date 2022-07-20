package view.management;

import controller.UserController;
import helper.Config;
import helper.Help;
import model.User;

import javax.swing.*;

public class ManagerGUI extends JFrame {
    private JPanel wrapper;

    private UserController userController;

    public ManagerGUI(UserController userController) {
        this.userController = userController;

        add(wrapper);
        setSize(1000, 1000);
        setLocation(Help.screenCenterPoint("x", getSize()), Help.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(false);

        System.out.println("* User List Test");
        for (User u : userController.getAllUser(userController.getUser().getRole())) {
            System.out.println(" +" + u.getName());
        }

        System.out.println("* User Add Test");
        System.out.println(" +" + userController.addUser("TEst-add", "testAdd", "111", 2));

        System.out.println("* User Delete Test");
        System.out.println(" +" +userController.deleteUser(4));

        System.out.println("* User Update Test (for its own)");
        System.out.println(" +" + userController.updateUser(7,"Test-M", "Test-username-manager", "123",1));

        System.out.println("* User Update Test-2");
        System.out.println(" +" + userController.updateUser(6,"Test-operator-2", "Test-username", "111",2));

    }
}
