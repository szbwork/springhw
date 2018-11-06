package bsz.ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    public Menu() {
    }

    public void show(List<MenuItem> menuItems, boolean endOfThisMenu) {
        do {
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
        } while (true);
    }
}
