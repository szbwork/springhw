package bsz.ui.actions;

import bsz.service.UserServiceImp;

public class ListUsers extends UserAction implements MenuAction {

    private UserServiceImp userService;

    public void setUserService(UserServiceImp userService) {
        this.userService = userService;
    }

    @Override
    public void doAction() {
        listUsers(userService);
    }
}

