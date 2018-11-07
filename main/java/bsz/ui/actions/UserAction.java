package bsz.ui.actions;

import bsz.domain.User;
import bsz.service.UserServiceImp;
import bsz.ui.UserMenu;

public class UserAction  {

    protected void listUsers(UserServiceImp userService) {
        System.out.println();
        System.out.println("____ List of users ________");
        userService.getAll().forEach(user -> printUserData(user));
        System.out.println("___________________________\n");
    }

    private void printUserData(User user) {
        System.out.println("First name: " + user.getFirstName() + " Last name: " + user.getLastName() + " Email: " + user.getEmail());
    }
}

