package view.management;

import controller.HotelController;
import controller.UserController;
import helper.Config;
import helper.Help;
import model.HostelType;
import model.Hotel;
import model.HotelFacility;
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

        es();
        userController.getHotelController().getHostelController().addHostelType(9,"Test-h.type-1");
        userController.getHotelController().getHostelController().addHostelType(9,"Test-h.type-2");
        userController.getHotelController().getHostelController().addHostelType(-1,"Test-h.type-3");
        es();
        userController.getHotelController().getHostelController().updateHostelType(2,"update-test");
        userController.getHotelController().getHostelController().updateHostelType(-1,"update-test");
        es();
        userController.getHotelController().getHostelController().deleteHostelType(userController.getUser(),1);
        userController.getHotelController().getHostelController().deleteHostelType(userController.getUser(),-1);
        es();
        for (HostelType hostelType : userController.getHotelController().getHostelController().getAll(9)){
            System.out.println(" +" + hostelType.getHostelType());
        }
        es();
        userController.getHotelController().deleteHotel(userController.getUser(),9);
    }

    private void es(){
        System.out.println("******");
    }
}
