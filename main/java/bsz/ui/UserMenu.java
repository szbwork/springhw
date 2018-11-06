package bsz.ui;

//import java.util.ArrayList;
//import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class UserMenu extends Menu {

    private List<MenuItem> menuItems = new ArrayList();

    private boolean exitFromUserMenu = false;

    public UserMenu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void show() {
        super.show(menuItems, exitFromUserMenu);
    }

    public void setExitFromUserMenu(boolean exitFromUserMenu) {
        this.exitFromUserMenu = exitFromUserMenu;
    }

}
