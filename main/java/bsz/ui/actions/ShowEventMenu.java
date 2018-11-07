package bsz.ui.actions;

import bsz.ui.EventMenu;


public class ShowEventMenu implements MenuAction {

    public void setEventMenu(EventMenu eventMenu) {
        this.eventMenu = eventMenu;
    }

    EventMenu eventMenu;

    @Override
    public void doAction() {
        eventMenu.show();
    }
}

