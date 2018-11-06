package bsz.ui.actions;

import bsz.domain.User;
import bsz.service.UserServiceImp;
import bsz.ui.Console;
import bsz.ui.UserMenu;

public class AddUser extends UserAction implements MenuAction {


    private UserServiceImp userService;

    @Override
    public void doAction() {
        User user = getUserData();
        userService.save(user);
        listUsers(userService);
    }

    private User getUserData() {
        String firstName = Console.readLine("First name? ");
        String lastName = Console.readLine("Last name? ");
        String email = Console.readLine("Email? ");
        return userService.createNewUser(firstName, lastName, email);
    }

    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }
}

