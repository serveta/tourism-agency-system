package view.management;

import controller.UserController;
import helper.Config;
import helper.Help;
import helper.Role;
import model.Hotel;
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

        /*
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
        */

        /*
        System.out.println("* Get hotel list Test");
        for (Hotel hotel : userController.getHotelController().getAll()) {
            System.out.println(" +" + hotel.getName());
        }

        System.out.println("* Add hotel Test");
        userController.getHotelController().addHotel("Operator-add-hotel","address-o","o@mail.com","","1");

        System.out.println("* Update hotel Test");
        userController.getHotelController().updateHotel(4,"Updated Hotel-opr","no","no","1","6");

        System.out.println("* Delete hotel Test");
        userController.getHotelController().deleteHotel(userController.getUser(),2);
        */

        /*
        System.out.println("* Testing of adding facility for existing hotel");
        userController.getHotelController().addFacility(4,"Test");

        System.out.println("* Testing of adding the facility for non-existing hotel");
        userController.getHotelController().addFacility(-1,"Test");

        System.out.println("* Testing of adding the existing facility");
        userController.getHotelController().addFacility(4,"Test");

        System.out.println("* Testing of update the non-existing facility");
        userController.getHotelController().updateFacility(-2,"Test");

        System.out.println("* Testing of update the existing facility");
        userController.getHotelController().updateFacility(4,"Test-update");

        System.out.println("* Testing of deleting the existing facility");
        userController.getHotelController().deleteFacility(userController.getUser(), 1);
         */

    }
}
