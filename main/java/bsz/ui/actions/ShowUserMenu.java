package bsz.ui.actions;

import bsz.domain.User;
import bsz.service.UserServiceImp;
import bsz.ui.Console;
import bsz.ui.UserMenu;

public class ShowUserMenu implements MenuAction {

    public void setUserMenu(UserMenu userMenu) {
        this.userMenu = userMenu;
    }

    UserMenu userMenu;

    @Override
    public void doAction() {
        userMenu.show();
    }
}

