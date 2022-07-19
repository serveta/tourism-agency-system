import controller.UserController;
import helper.Help;
import helper.Role;
import model.User;
import view.management.ManagerGUI;
import view.management.OperatorGUI;

public class App {
    public static void main(String[] args) {
        Help.setLayout();

        // Manager TEST
        //String username = "Test-username-manager";
        //String password = "1234";

        // Operator TEST
        String username = "Test-username";
        String password = "123";

        User user = new User(username, password);

        user = user.getFetch(username, password);
        if(user != null){
            System.out.println("Signed in account " + user.getName());

            if (user.getRole() == Role.MANAGER.getRole()){
                ManagerGUI managerGUI = new ManagerGUI(new UserController(user));
            } else if (user.getRole() == Role.OPERATOR.getRole()) {
                OperatorGUI operatorGUI = new OperatorGUI(new UserController(user));
            } else {
                System.out.println("ERROR: The user role does not exist.");
            }
        } else {
            System.out.println("WARNING: username or password is wrong");
        }
    }
}
