package bsz.ui.actions;

import bsz.domain.User;
import bsz.service.UserServiceImp;
import bsz.ui.Console;

public class AddUser implements MenuAction {
//    public class AddUser extends UserActions implements MenuAction {

    UserServiceImp userService;

    public AddUser(UserServiceImp userService) {
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

