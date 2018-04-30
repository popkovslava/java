package org.project.dao;

import java.util.ArrayList;

public class DaoMenu {
    private static final DaoMenu  INSTANCE = new DaoMenu ();
    public  static ArrayList getDaoMenu() {
        ArrayList ListMenu = new ArrayList();
        ListMenu.add("menu1");
        ListMenu.add("menu2");
        return ListMenu;
    }
    public static DaoMenu  getInstance() {
        return INSTANCE;
    }
}
