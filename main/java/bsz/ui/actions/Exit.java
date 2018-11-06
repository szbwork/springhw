package bsz.ui.actions;

import bsz.ui.MainMenu;

public class Exit implements MenuAction {

    MainMenu mainMenu;

    @Override
    public void doAction() {
        System.exit(0);
    }
}

