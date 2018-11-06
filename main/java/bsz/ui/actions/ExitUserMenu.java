package bsz.ui.actions;

import bsz.ui.UserMenu;

public class ExitUserMenu implements MenuAction {

    public void setUserMenu(UserMenu userMenu) {
        this.userMenu = userMenu;
    }

    UserMenu userMenu;

    @Override
    public void doAction() {
        userMenu.setExitFromUserMenu(true);
    }
}

