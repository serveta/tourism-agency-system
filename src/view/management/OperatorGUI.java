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

        es();
        userController.getHotelController().addHotel("MyHotel","myAddress","myMail","1234567","4");
        userController.getHotelController().addHotel("MySecondHotel","mSecondyAddress","mySecondMail","1234765","5");
        es();
        for (Hotel hotel : userController.getHotelController().getAll()){
            System.out.println(" +"+hotel.getName());
        }
        es();
        userController.getHotelController().updateHotel(-1,"xx","xx","xx","","0");
        userController.getHotelController().updateHotel(7,"MySecondHotel","mySecondAddress","mySecondMail","9876543","5");
        es();
        userController.getHotelController().deleteHotel(userController.getUser(),-1);
        es();
        userController.getHotelController().getHotelFacilityController().deleteFacility(userController.getUser(),-1);
    }
    private void es(){
        System.out.println("******");
    }
}
