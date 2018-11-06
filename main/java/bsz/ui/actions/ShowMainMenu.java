package bsz.ui.actions;

import bsz.ui.MainMenu;
import bsz.ui.UserMenu;

public class ShowMainMenu implements MenuAction {

    MainMenu mainMenu;

    @Override
    public void doAction() {
        mainMenu.show();
    }
}

