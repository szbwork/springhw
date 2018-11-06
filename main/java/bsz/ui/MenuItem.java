package bsz.ui;

import bsz.ui.actions.MenuAction;

public class MenuItem {
    private String text;
    private MenuAction action;
    private String key;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MenuAction getAction() {
        return action;
    }

    public void setAction(MenuAction action) {
        this.action = action;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
