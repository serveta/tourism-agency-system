package view.management;

import controller.UserController;
import helper.Config;
import helper.Help;

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
        userController.getHotelController().addHotel("MyHotel","Address my hotel","mail@myhotel","111222","5");
        es();
        userController.getHotelController().getHotelFacilityController().addFacility(13,"F-1");
        userController.getHotelController().getHotelFacilityController().addFacility(13,"F-2");
        userController.getHotelController().getHotelFacilityController().addFacility(13,"F-3");
        es();
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(13,"RT-1",3,750);
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(13,"RT-2",6,500);
        userController.getHotelController().getHotelRoomTypeController().addHotelRoomType(13,"RT-3",5,400);
        es();
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(8,"RF-1-8");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(8,"RF-2-8");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(8,"RF-3-8");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(9,"RF-1-9");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(9,"RF-2-9");
        userController.getHotelController().getHotelRoomTypeController().getRoomFeatureController().addRoomFeature(10,"RF-1-10");
        es();
        userController.getHotelController().getHostelController().addHostelType(13,"HT-1",200);
        userController.getHotelController().getHostelController().addHostelType(13,"HT-2",150);
        userController.getHotelController().getHostelController().addHostelType(13,"HT-3",100);
        es();
        Date seasonStart1 = Date.valueOf("2022-01-01");
        Date seasonEnd1 = Date.valueOf("2022-06-01");
        Date seasonStart2 = Date.valueOf("2022-06-02");
        Date seasonEnd2 = Date.valueOf("2022-12-31");
        userController.getHotelController().getHotelSeasonController().addHotelSeason(13,seasonStart1,seasonEnd1,"Winter");
        userController.getHotelController().getHotelSeasonController().addHotelSeason(13,seasonStart2,seasonEnd2,"Summer");
    }

    private void es() {
        System.out.println("******");
    }
}
