package view.management;

import controller.HotelController;
import controller.UserController;
import helper.Config;
import helper.Help;
import model.*;

import javax.swing.*;
import java.sql.Date;

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
        userController.getHotelController().addHotel("MyHotel", "MyAddress", "mail@", "111", "3");
        userController.getHotelController().addHotel("MyHotel2", "MyAddress2", "mail2@", "222", "4");
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(11, "Suit", 5);
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(12, "XXXX", 3);
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(6, "TV");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(6, "Test");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(7, "Test");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(8, "Test");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(-1, "mom exist room");
        es();
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().updateRoomFeature(1, 6, "update");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().updateRoomFeature(-1, 11, "update");
        es();
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().deleteHotelRoomType(userController.getUser(), 1);
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().deleteHotelRoomType(userController.getUser(), -1);
        es();
        for (RoomFeature roomFeature : userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().getAll(6)) {
            System.out.println(" +" + roomFeature.getFeature());
        }
        es();
        userController.getHotelController().deleteHotel(userController.getUser(),11);
    }

    private void es() {
        System.out.println("******");
    }
}
