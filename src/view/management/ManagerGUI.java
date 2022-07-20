package view.management;

import controller.HotelController;
import controller.UserController;
import helper.Config;
import helper.Help;
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
        userController.getHotelController().addHotel("MyHotel","myAddress","myMail","1234567","4");
        userController.getHotelController().addHotel("MySecondHotel","mSecondyAddress","mySecondMail","1234765","5");
        es();
        for (Hotel hotel : userController.getHotelController().getAll()){
            System.out.println(" +"+hotel.getName());
        }
        es();
        userController.getHotelController().updateHotel(-1,"xx","xx","xx","","0");
        userController.getHotelController().updateHotel(6,"MySecondHotel","mySecondAddress","mySecondMail","9876543","5");
        es();
        userController.getHotelController().getHotelFacilityController().addFacility(6,"Facility-1");
        userController.getHotelController().getHotelFacilityController().addFacility(6,"Facility-2");
        es();
        userController.getHotelController().deleteHotel(userController.getUser(),-1);
        userController.getHotelController().deleteHotel(userController.getUser(),6);
        es();
        userController.getHotelController().getHotelFacilityController().addFacility(7,"Facility-A-1");
        userController.getHotelController().getHotelFacilityController().addFacility(8,"Facility-B-1");
        userController.getHotelController().getHotelFacilityController().addFacility(8,"Facility-B-2");
        userController.getHotelController().getHotelFacilityController().addFacility(8,"Facility-B-3");
        es();
        userController.getHotelController().getHotelFacilityController().updateFacility(9,"Facility-A");
        es();
        userController.getHotelController().getHotelFacilityController().deleteFacility(userController.getUser(),10);
        userController.getHotelController().getHotelFacilityController().deleteFacility(userController.getUser(),-1);
        es();
        for (HotelFacility hotelFacility : userController.getHotelController().getHotelFacilityController().getAll(8)){
            System.out.println(" +" + hotelFacility.getFacilityName());
        }
    }

    private void es(){
        System.out.println("******");
    }
}
