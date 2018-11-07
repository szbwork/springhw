package bsz.ui;

import java.util.List;

public class Menu {

    public Menu() {
    }

    public void show(List<MenuItem> menuItems) {
        while (true) {
            System.out.println("-----------MENU--------------");
            menuItems.forEach(menuItem -> System.out.println(" (" + menuItem.getKey() + ") " + menuItem.getText()));
            System.out.println("-----------------------------");
            String inputKey = GetInput.read("", true);
            menuItems.forEach(menuItem -> inputKeyMatchingCheck(inputKey, menuItem));
        }
    }

    private void inputKeyMatchingCheck(String inputKey, MenuItem menuItem) {
        if (inputKey.equals(menuItem.getKey())) {
            menuItem.getAction().doAction();
        }
    }
}
