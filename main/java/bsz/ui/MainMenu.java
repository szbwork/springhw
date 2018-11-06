package bsz.ui;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu {

    public MainMenu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    private List<MenuItem> menuItems = new ArrayList();

     private boolean exitFromMainMenu = false;

    public void show() {
        super.show(menuItems, exitFromMainMenu);
    }

    public void setExitFromMainMenu(boolean exitFromMainMenu) {
        this.exitFromMainMenu = exitFromMainMenu;
    }

}
