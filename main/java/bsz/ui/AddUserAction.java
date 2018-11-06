package bsz.ui;

import bsz.domain.User;
import bsz.service.UserServiceImp;

public class AddUserAction implements MenuAction {
//    public class AddUserAction extends UserActions implements MenuAction {

    UserServiceImp userService;

    public AddUserAction(UserServiceImp userService) {
       this.userService  = userService;
    }

    @Override
    public void doAction() {
        User user = getUserData();
        userService.save(user);
        listUsers();
    }

    private User getUserData() {
        User user = new User();
        user.setFirstName(Console.readLine("First name?"));
        user.setLastName(Console.readLine("Last name?"));
        user.setEmail(Console.readLine("Email?"));
        return user;
    }

    protected void listUsers() {
        System.out.println("List of users:");
        userService.getAll().forEach(user -> printUserData(user));
        System.out.println("___________________________\n");
        Console.readLine(null);
    }

    private void printUserData(User user) {
        System.out.println("First name: " + user.getFirstName() + " Last name: " + user.getLastName() + " Email: " + user.getEmail());
    }
}

