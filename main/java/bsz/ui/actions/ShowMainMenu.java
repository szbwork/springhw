package bsz.ui.actions;

import bsz.ui.MainMenu;

public class ShowMainMenu implements MenuAction {

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    MainMenu mainMenu;

    @Override
    public void doAction() {
        mainMenu.show();
    }
}

