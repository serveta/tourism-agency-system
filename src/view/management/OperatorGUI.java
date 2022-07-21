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
        userController.getHotelController().getHotelSeasonController().deleteHotelSeason(userController.getUser(), -1);
    }
    private void es(){
        System.out.println("******");
    }
}
