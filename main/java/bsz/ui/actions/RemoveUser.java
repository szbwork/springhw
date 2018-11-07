package bsz.ui.actions;

import bsz.domain.User;
import bsz.service.UserServiceImp;
import bsz.ui.GetInput;

public class RemoveUser extends UserAction implements MenuAction {


    private UserServiceImp userService;

    @Override
    public void doAction() {
        User user = userService.getUserByEmail(getEmail());
        userService.remove(user);
        listUsers(userService);
    }

    private String getEmail() {
        return GetInput.read("Email? ", false);
    }

    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }
}

