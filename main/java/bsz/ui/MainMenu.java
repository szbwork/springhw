package bsz.ui;

import java.util.List;

public class MainMenu extends Menu {

    private List<MenuItem> menuItems;

    public void show() {
        super.show(menuItems);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}
