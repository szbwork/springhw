package bsz.ui;

import java.util.ArrayList;
import java.util.List;

public class UserMenu {

    private List<MenuItem> menuItems = new ArrayList();

    public UserMenu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void showUserMenu() {
        System.out.println("-----------MENU--------------");
        for (MenuItem item : menuItems) {
            System.out.println(" (" + item.getKey() + ") " + item.getText());
        }
        System.out.println("-----------------------------");
        String choice = Console.readLine(null);
        System.out.println();
        for (MenuItem item : menuItems) {
            if (choice.equals(item.getKey())) {
                item.getAction().doAction();
            }
        }

    }
}
