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
        Date dateStart = Date.valueOf("2022-12-12");
        Date dateEnd = Date.valueOf("2022-04-12");
        userController.getHotelController().getHotelSeasonController().addHotelSeason(7, dateStart, dateEnd, "season-test-1");
        userController.getHotelController().getHotelSeasonController().addHotelSeason(7, dateStart, dateEnd, "season-test-2");
        userController.getHotelController().getHotelSeasonController().addHotelSeason(-1, dateStart, dateEnd, "season-test-3");
        es();
        userController.getHotelController().getHotelSeasonController().updateHotelSeason(1,7,dateStart,dateEnd,"update-test-season-name");
        userController.getHotelController().getHotelSeasonController().updateHotelSeason(-1,7,dateStart,dateEnd,"update-test");
        es();
        userController.getHotelController().getHotelSeasonController().deleteHotelSeason(userController.getUser(), 1);
        userController.getHotelController().getHotelSeasonController().deleteHotelSeason(userController.getUser(), -1);
        es();
        for (HotelSeason hotelSeason : userController.getHotelController().getHotelSeasonController().getAll(7)){
            System.out.println(" +" + hotelSeason.getSeasonName());
        }
        es();
        userController.getHotelController().deleteHotel(userController.getUser(),7);
    }

    private void es() {
        System.out.println("******");
    }
}
