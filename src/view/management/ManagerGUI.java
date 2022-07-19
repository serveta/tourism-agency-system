package view.management;

import controller.UserController;
import helper.Config;
import helper.Help;

import javax.swing.*;

public class ManagerGUI extends  JFrame{
    private JPanel wrapper;

    private UserController userController;

    public ManagerGUI(UserController userController) {
        this.userController = userController;

        add(wrapper);
        setSize(1000,1000);
        setLocation(Help.screenCenterPoint("x",getSize()),Help.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);
    }
}
