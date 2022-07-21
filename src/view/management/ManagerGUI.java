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
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(10,"room type test",3);
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(8,"room type test",3);
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(8,"room type test-2",2);
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(-1,"room type test-3",3);
        es();
        userController.getHotelController().getHotelRoomTypeController().updateHotelRoomType(1,8,"update test",1);
        userController.getHotelController().getHotelRoomTypeController().updateHotelRoomType(-1,8,"update test",1);
        es();
        userController.getHotelController().getHotelRoomTypeController().deleteHotelRoomType(userController.getUser(),2);
        userController.getHotelController().getHotelRoomTypeController().deleteHotelRoomType(userController.getUser(),-1);
        es();
        for (HotelRoomType hotelRoomType : userController.getHotelController().getHotelRoomTypeController().getAll(8)){
            System.out.println(" +" + hotelRoomType.getRoomType());
        }
        es();
        userController.getHotelController().deleteHotel(userController.getUser(),8);
    }

    private void es() {
        System.out.println("******");
    }
}
