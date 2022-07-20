package view.management;

import controller.HotelController;
import controller.UserController;
import helper.Config;
import helper.Help;
import model.Hotel;
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
        /*
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
         */

        System.out.println("* Get hotel list Test");
        for (Hotel h : userController.getHotelController().getAll()) {
            System.out.println(" +" + h.getName());
        }

        System.out.println("* Add hotel Test");
        userController.getHotelController().add("Manager-add-hotel","address-m","m@mail.com","1212","2");

        System.out.println("* Add same hotel Test");
        userController.getHotelController().add("Manager-add-hotel","address-m","m@mail.com","1212","2");

        System.out.println("* Update non exist hotel Test");
        userController.getHotelController().update(-1,"no","no","no","1","1");

        System.out.println("* Update hotel Test");
        userController.getHotelController().update(1,"Updated Hotel","no","no","1","0");

        System.out.println("* Delete non exist hotel Test");
        userController.getHotelController().delete(userController.getUser(),-2);

        System.out.println("* Delete hotel Test");
        userController.getHotelController().delete(userController.getUser(),1);
    }
}
