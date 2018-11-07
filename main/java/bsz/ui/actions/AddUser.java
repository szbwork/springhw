package bsz.ui.actions;

import bsz.domain.User;
import bsz.service.UserServiceImp;
import bsz.ui.GetInput;

public class AddUser extends UserAction implements MenuAction {


    private UserServiceImp userService;

    @Override
    public void doAction() {
        User user = getUserData();
        userService.save(user);
        listUsers(userService);
    }

    private User getUserData() {
        String firstName = GetInput.read("First name? ", false);
        String lastName = GetInput.read("Last name? ", false);
        String email = GetInput.read("Email? ", false);
        return userService.createNewUser(firstName, lastName, email);
    }

    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }
}

